package angrybirds.models.objects;

import angrybirds.models.LevelModel;
import angrybirds.models.Model;
import angrybirds.notifications.updates.actions.ObjectUpdateAction;
import angrybirds.utils.Constants;
import angrybirds.utils.Vector2d;

/**
 * Cette classe représente les données et actions d'un objet.
 * Un objet est défini comme un élément du jeu qui intéragit physiquement avec d'autres objets.
 *
 * @author Quentin Brault
 * @since 2013/10/01
 */
public abstract class ObjectModel extends Model {

    /**
     * Modèle du niveau.
     */
    protected LevelModel level;

    /**
     * Position du centre de l'objet en m.
     */
    protected Vector2d position;

    /**
     * Vélocité de l'objet en m/s.
     */
    protected Vector2d velocity;

    /**
     * Accélération de l'objet en m/s^2.
     */
    protected Vector2d acceleration;

    /**
     * Taille de l'objet en m.
     */
    protected Vector2d size;

    /**
     * Densité (ou masse surfacique) de l'objet en kg/m^2.
     */
    protected float density;

    /**
     * Rotation de l'objet en rad par rapport au 0 du cercle trigonométrique.
     */
    protected float rotation;

    /**
     * Vitesse de rotation de l'objet en rad/s
     */
    protected float angularSpeed;

    /**
     * True si l'objet est soumis à la pesanteur, false sinon.
     */
    protected boolean gravity;

    /**
     * Créé un nouvel objet.
     *
     * @param level        Modèle du niveau.
     * @param position     Position du centre de l'objet en m.
     * @param velocity     Vélocité de l'objet en m/s.
     * @param acceleration Accélération de l'objet en m/s^2.
     * @param size         Taille de l'objet en m.
     * @param density      Densité (ou masse surfacique) de l'objet en kg/m^2.
     * @param rotation     Rotation de l'objet en radians par rapport au 0 du cercle trigonométrique.
     * @param angularSpeed Vitesse de rotation de l'objet en rad/s
     * @param gravity      True si l'objet est soumis à la pesanteur, false sinon.
     */
    public ObjectModel(LevelModel level, Vector2d position, Vector2d velocity, Vector2d acceleration, Vector2d size, float density, float rotation, float angularSpeed, boolean gravity) {
        this.level = level;
        this.position = position;
        this.velocity = velocity;
        this.acceleration = acceleration;
        this.size = size;
        this.density = density;
        this.rotation = rotation;
        this.angularSpeed = angularSpeed;
        this.gravity = gravity;
    }

    @Override
    public void update(int delta) {
        if (gravity)
            accelerate(acceleration.sum(Constants.FRICTION.product(velocity)).sum(Constants.GRAVITY.product(getMass())).product(delta));
        else
            accelerate(acceleration.sum(Constants.FRICTION.product(velocity)).product(delta));
        move(velocity.product(delta));
        rotate(angularSpeed * delta);
    }

    /**
     * Déplace l'objet de la distance spécifiée.
     *
     * @param distance L'objet est déplacé de cette distance.
     */
    public void move(Vector2d distance) {
        if (!distance.equals(Vector2d.ZERO)) {
            setPosition(position.sum(distance));
            checkGround();
        }
    }

    /**
     * Regarde si l'objet rentre dans le sol et ajuste sa position si c'est le cas.
     */
    private void checkGround() {
        float ground = Constants.WINDOW_HEIGHT - level.getGround() - size.y / 2;
        if (position.y - ground > 0)
            setPosition(new Vector2d(position.x, ground));
    }

    /**
     * Accélère l'objet de l'accélération spécifiée.
     *
     * @param acceleration L'objet est accéléré de cette accélération.
     */
    public void accelerate(Vector2d acceleration) {
        if (!acceleration.equals(Vector2d.ZERO)) {
            setVelocity(velocity.sum(acceleration));
        }
    }

    /**
     * Tourne l'objet de l'angle spécifié.
     *
     * @param angle L'objet tourne de cet angle.
     */
    public void rotate(float angle) {
        if (angle > 0) {
            setRotation(rotation + angle);
        }
    }

    /**
     * Vérifie si l'objet spécifié entre en collision avec cet objet.
     *
     * @param object Objet à vérifier.
     * @return True si l'objet entre en collision, false sinon.
     */
    public abstract boolean collidesWith(ObjectModel object);

    /**
     * Calcule et retourne la masse de l'objet en kg à partir de sa densité (ou masse surfacique) et de sa surface.
     *
     * @return Masse de l'objet en kg.
     */
    public float getMass() {
        return density * getSurface();
    }

    /**
     * Calcule et retourne la surface de l'objet en m^2.
     *
     * @return Surface de l'objet en m^2.
     */
    public abstract float getSurface();

    /**
     * Calcule et retourne la tangente au mouvement de l'objet.
     *
     * @return  Tangente du mouvement de l'objet.
     */
    public Vector2d getTangent() {
        return position.sum(velocity).difference(position);
    }

    /**
     * TODO
     * @return
     */
    public float getKineticEnergy() {
        return 0;
    }

    /**
     * Retourne la position de l'objet en m.
     *
     * @return Position de l'objet en m.
     */
    public Vector2d getPosition() {
        return position;
    }

    /**
     * Change la position de l'objet par celle spécifiée.
     * Notifie les observateurs.
     *
     * @param position Nouvelle position de l'objet en m.
     */
    public void setPosition(Vector2d position) {
        this.position = position;
        notifyObservers(new ObjectUpdateAction.MoveTo(position));
    }

    /**
     * Retourne la vélocité de l'objet en m/s.
     *
     * @return Vélocité de l'objet en m/s.
     */
    public Vector2d getVelocity() {
        return velocity;
    }

    /**
     * Change la vélocité de l'objet par celle spécifiée.
     * Notifie les observateurs.
     *
     * @param velocity Nouvelle vélocité de l'objet en m/s.
     */
    public void setVelocity(Vector2d velocity) {
        this.velocity = velocity;
        notifyObservers(new ObjectUpdateAction.AccelerateTo(velocity));
    }

    /**
     * Retourne l'accélération de l'objet en m/s^2.
     *
     * @return Accélération de l'objet en m/s^2.
     */
    public Vector2d getAcceleration() {
        return acceleration;
    }

    /**
     * Change l'accélération de l'objet par celle spécifiée.
     *
     * @param acceleration Nouvelle accélération de l'objet en m/s^2.
     */
    public void setAcceleration(Vector2d acceleration) {
        this.acceleration = acceleration;
    }

    /**
     * Retourne la taille de l'objet en m.
     *
     * @return Taille de l'objet en m.
     */
    public Vector2d getSize() {
        return size;
    }

    /**
     * Change la taille de l'objet par celle spécifiée.
     *
     * @param size Nouvelle taille de l'objet en m.
     */
    public void setSize(Vector2d size) {
        this.size = size;
    }

    /**
     * Retourne la densité (ou masse surfacique) de l'objet en kg/m^2.
     *
     * @return Densité (ou masse surfacique) de l'objet en kg/m^2.
     */
    public float getDensity() {
        return density;
    }

    /**
     * Change la densité (ou masse surfacique) de l'objet par celle spécifiée.
     *
     * @param density Nouvelle densité (ou masse surfacique) de l'objet en kg/m^2.
     */
    public void setDensity(float density) {
        this.density = density;
    }

    /**
     * Retourne la rotation de l'objet en rad par rapport au 0 du cercle trigonométrique.
     *
     * @return Rotation de l'objet en rad par rapport au 0 du cercle trigonométrique.
     */
    public float getRotation() {
        return rotation;
    }

    /**
     * Change la rotation de l'objet par celle spécifiée.
     * Notifie les observateurs.
     *
     * @param rotation Nouvelle rotation de l'objet en rad par rapport au 0 du cercle trigonométrique.
     */
    public void setRotation(float rotation) {
        this.rotation = rotation;
        notifyObservers(new ObjectUpdateAction.RotateTo(rotation));
    }

    /**
     * Retourne la vitesse de rotation de l'objet en rad/s.
     *
     * @return Vitesse de rotation de l'objet en rad/s.
     */
    public float getAngularSpeed() {
        return angularSpeed;
    }

    /**
     * Change la vitesse de rotation de l'objet par celle spécifiée.
     *
     * @param angularSpeed Nouvelle vitesse de rotation de l'objet en rad/s.
     */
    public void setAngularSpeed(float angularSpeed) {
        this.angularSpeed = angularSpeed;
    }

    /**
     * Retourne true si l'objet est affecté par la pesanteur, false sinon.
     *
     * @return True si l'objet est affecté par la pesanteur, false sinon.
     */
    public boolean hasGravity() {
        return gravity;
    }

    /**
     * Change l'affectation de la gravité sur l'objet par celle spécifiée.
     *
     * @param gravity True pour que l'objet soit affecté par la gravité, false sinon.
     */
    public void setGravity(boolean gravity) {
        this.gravity = gravity;
    }

}
