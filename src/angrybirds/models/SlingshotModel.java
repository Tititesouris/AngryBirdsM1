package angrybirds.models;

import angrybirds.models.objects.birds.BirdModel;
import angrybirds.utils.Constants;
import angrybirds.utils.Vector2d;
import angrybirds.notifications.updates.actions.SlingshotUpdateAction;

/**
 * Cette classe représente les données et actions d'un lance-oiseau.
 *
 * @author Quentin Brault
 * @since  2013/10/01
 */
public class SlingshotModel extends Model {

    /**
     * Modèle du niveau.
     */
    private LevelModel level;

    /**
     * Oiseau placé sur le lance-oiseau.
     * Null si il n'y a pas d'oiseau.
     */
    private BirdModel bird;

    /**
     * Position du lance-oiseau en m.
     */
    private Vector2d position;

    /**
     * Taille du lance-oiseau en m.
     */
    private Vector2d size;

    /**
     * Position du holder du lance-oiseau par rapport à sa position au repos en m.
     * Le holder est la partie du lance-oiseau qui porte l'oiseau
     * Cette valeur est le vecteur nul au repos.
     * L'hypoténuse de ce vecteur ne peut pas dépasser la portée du lance-oiseau.
     */
    private Vector2d holderPosition;

    /**
     * Portée du lance-oiseau en m.
     * La portée est la distance maximale entre la position du holder lorsque
     * l'élastique est tendu et sa position par default lorsque l'élastique est détendu.
     * Cette portée permet de limiter la puissance de tir.
     */
    private int range;

    /**
     * Créé un nouveau lance-oiseau.
     *
     * @param level    Modèle du niveau.
     * @param position Position du lance-oiseau.
     * @param range    Portée du lance-oiseau.
     */
    public SlingshotModel(LevelModel level, Vector2d position, int range) {
        this.level = level;
        this.position = position;
        this.size = new Vector2d(100, 200);
        this.holderPosition = Vector2d.ZERO;
        this.range = range;
    }

    @Override
    public void update(int delta) {

    }

    /**
     * Cette méthode déplace le holder à la position spécifiée
     * (ou la plus proche si elle dépasse la portée du lance-oiseau)
     * par rapport à sa position au repos et notifie les observateurs.
     *
     * @param holderPosition Nouvelle position du holder par rapport à sa position au repos.
     */
    public void pull(Vector2d holderPosition) {
        if (bird != null) {
            if (!this.holderPosition.equals(holderPosition)) {
                setHolderPosition(getInRange(holderPosition));
                bird.setPosition(getAbsoluteHolderPosition());
                //bird.rotate(?);
                notifyObservers(new SlingshotUpdateAction.Pull(getHolderPosition()));
            }
        }
    }

    /**
     * Cette méthode relâche le holder, lançant l'oiseau, et notifie les observateurs.
     */
    public void release() {
        bird.launch(getInitialVelocity());
        setBird(null);
        notifyObservers(new SlingshotUpdateAction.Release());
    }

    /**
     * Cette méthode prépare le lance-oiseau à tirer l'oiseau spécifié et notifie les observateurs.
     *
     * @param bird Oiseau à équipper.
     */
    public void ready(BirdModel bird) {
        setBird(bird);
        setHolderPosition(Vector2d.ZERO);
        bird.ready(getAbsoluteHolderPosition());
    }

    /**
     * Cette méthode calcule la position du holder en respectant la portée du lance-oiseau.
     *
     * @param holderPosition Position du holder avant vérification.
     * @return Position du holder après vérification.
     */
    private Vector2d getInRange(Vector2d holderPosition) {
        return holderPosition.normalized().product(Math.min(range, holderPosition.hypotenuse()));
    }

    /**
     * Cette méthode calcule retourne la vitesse initiale de l'oiseau au lancé.
     *
     * @return Vitesse initiale de l'oiseau au lancé.
     */
    private Vector2d getInitialVelocity() {
        return holderPosition.normalized().product(-holderPosition.hypotenuse() / Constants.SLING_STRENGTH);
    }

    /**
     * Retourne la position du lance-oiseau en m.
     *
     * @return Position du lance-oiseau en m.
     */
    public Vector2d getPosition() {
        return position;
    }

    /**
     * Change la position du lance oiseau par celle spécifiée.
     *
     * @param position Nouvelle position du lance-oiseau en m.
     */
    public void setPosition(Vector2d position) {
        this.position = position;
    }

    /**
     * Retourne la taille du lance-oiseau en m.
     *
     * @return Taille du lance-oiseau en m.
     */
    public Vector2d getSize() {
        return size;
    }

    /**
     * Change la taille du lance oiseau par celle spécifiée.
     *
     * @param size Nouvelle taille du lance-oiseau en m.
     */
    public void setSize(Vector2d size) {
        this.size = size;
    }

    /**
     * Retourne la position du holder du lance-oiseau par rapport à sa position au repos en m.
     *
     * @return Position du holder du lance-oiseau par rapport à sa position au repos en m.
     */
    public Vector2d getHolderPosition() {
        return holderPosition;
    }

    /**
     * Change la position du holder du lance oiseau par rapport à sa position au repos par celle spécifiée.
     *
     * @param holderPosition Nouvelle position du holder du lance-oiseau par rapport à sa position au repos en m.
     */
    public void setHolderPosition(Vector2d holderPosition) {
        this.holderPosition = holderPosition;
    }

    /**
     * Retourne la position du holder du lance-oiseau en m.
     *
     * @return Position du holder du lance-oiseau en m.
     */
    public Vector2d getAbsoluteHolderPosition() {
        return position.sum(holderPosition);
    }

    /**
     * Retourne la portée du lance-oiseau en m.
     *
     * @return Portée du lance-oiseau en m.
     */
    public int getRange() {
        return range;
    }

    /**
     * Change la portée du lance oiseau par celle spécifiée.
     *
     * @param range Nouvelle portée du lance-oiseau en m.
     */
    public void setRange(int range) {
        this.range = range;
    }

    /**
     * Retourne l'oiseau placé sur le lance-oiseau.
     *
     * @return Oiseau placé sur le lance-oiseau, null si il n'y a pas d'oiseau.
     */
    public BirdModel getBird() {
        return bird;
    }

    /**
     * Change l'oiseau placé sur le lance-oiseau par celui spécifié.
     *
     * @param bird Nouvel oiseau à placer sur le lance-oiseau.
     */
    public void setBird(BirdModel bird) {
        this.bird = bird;
    }

}
