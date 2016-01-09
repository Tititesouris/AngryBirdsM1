package angrybirds.models;

import angrybirds.models.objects.birds.BirdModel;
import angrybirds.utils.Constants;
import angrybirds.utils.Vector2d;
import angrybirds.notifications.updates.actions.SlingshotUpdateAction;

/**
 * TODO: Description
 *
 * @author Tititesouris
 */
public class SlingshotModel extends Model {

    private LevelModel level;

    /**
     * Oiseau sur le lance-oiseau.
     * Le champ est null si il n'y a pas d'oiseau sur le lance-oiseau.
     */
    private BirdModel bird;

    /**
     * Position du lance-oiseau dans le niveau.
     */
    private Vector2d position;

    /**
     * Taille du lance-oiseau.
     */
    private Vector2d size;

    /**
     * Position de la partie du lance-oiseau tenant l'oiseau par rapport à sa position au repos.
     */
    private Vector2d holderPosition;

    /**
     * Portée du lance-oiseau.
     * Distance maximale entre la position de la partie du lance-oiseau tenant l'oiseau lorsque
     * l'élastique est tendu et sa position par default lorsque l'élastique est détendu.
     * Cette distance permet de limiter la puissance de tir.
     */
    private int range;

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
     * Cette méthode est appellée quand le lance-oiseau est étiré.
     * @param holderPosition  Nouvelle holderPosition du holder par rapport à sa holderPosition au repos.
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
     * Cette méthode est appellée quand le lance-oiseau est relaché.
     */
    public void release() {
        bird.launch(getInitialVelocity(holderPosition));
        bird = null;
        notifyObservers(new SlingshotUpdateAction.Release());
    }

    /**
     * Cette méthode calcule la holderPosition du holder en respectant la portée du lance-oiseau.
     * @param holderPosition  Position du holder avant vérification.
     * @return          Position du holder après vérification.
     */
    private Vector2d getInRange(Vector2d holderPosition) {
        return holderPosition.normalized().product(Math.min(range, holderPosition.hypotenuse()));
    }

    private Vector2d getInitialVelocity(Vector2d holderPosition) {
        return holderPosition.normalized().product(-holderPosition.hypotenuse() / Constants.SLING_STRENGTH);
    }

    public Vector2d getPosition() {
        return position;
    }

    public void setPosition(Vector2d position) {
        this.position = position;
    }

    public Vector2d getSize() {
        return size;
    }

    public void setSize(Vector2d size) {
        this.size = size;
    }

    public Vector2d getHolderPosition() {
        return holderPosition;
    }

    public void setHolderPosition(Vector2d holderPosition) {
        this.holderPosition = holderPosition;
    }

    public Vector2d getAbsoluteHolderPosition() {
        return position.sum(holderPosition);
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public BirdModel getBird() {
        return bird;
    }

    public void setBird(BirdModel bird) {
        this.bird = bird;
    }

}
