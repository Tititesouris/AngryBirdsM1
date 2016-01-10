package angrybirds.models.objects;

import angrybirds.utils.Vector2d;

/**
 * TODO: Description
 *
 * @author Tititesouris
 * @since 2016/01/10
 */
public abstract class RectangularObjectModel extends ObjectModel {

    /**
     * Créé un nouvel objet rectangulaire.
     *
     * @param position     Position de l'objet en m.
     * @param velocity     Vélocité de l'objet en m/s.
     * @param acceleration Accélération de l'objet en m/s^2.
     * @param size         Taille de l'objet en m.
     * @param density      Densité (ou masse surfacique) de l'objet en kg/m^2.
     * @param rotation     Rotation de l'objet en radians par rapport au 0 du cercle trigonométrique.
     * @param angularSpeed Vitesse de rotation de l'objet en rad/s
     * @param gravity      True si l'objet est soumis à la pesanteur, false sinon.
     */
    public RectangularObjectModel(Vector2d position, Vector2d velocity, Vector2d acceleration, Vector2d size, float density, float rotation, float angularSpeed, boolean gravity) {
        super(position, velocity, acceleration, size, density, rotation, angularSpeed, gravity);
    }

    @Override
    public boolean collidesWith(ObjectModel object) {
        return false;
    }

    @Override
    public float getSurface() {
        return size.x * size.y;
    }

}
