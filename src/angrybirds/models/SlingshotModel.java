package angrybirds.models;

import angrybirds.models.objects.birds.BirdModel;
import angrybirds.utils.Vector2d;
import angrybirds.utils.updates.actions.BirdUpdateAction;
import angrybirds.utils.updates.actions.SlingshotUpdateAction;

/**
 * TODO: Description
 *
 * @author Tititesouris
 */
public class SlingshotModel extends Model {

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
     * Distance maximale entre la position de la partie du lance-oiseau tenant l'oiseau lorsque
     * l'élastique est tendu et sa position par default lorsque l'élastique est détendu.
     * Cette distance permet de limiter la puissance de tir.
     */
    private int range;

    /**
     * Oiseau sur le lance-oiseau.
     * Le champ est null si il n'y a pas d'oiseau sur le lance-oiseau.
     */
    private BirdModel bird;

    public SlingshotModel(Vector2d position, Vector2d size, int range) {
        this.position = position;
        this.size = size;
        this.holderPosition = position.sum(size.product(0.5f));
        this.range = range;
    }

    @Override
    public void init() {

    }

    @Override
    public void update(int delta) {

    }

    public void pull(Vector2d position) {
        if (bird != null) {
            holderPosition = position;
            bird.setPosition(position);
            bird.notifyObservers(new BirdUpdateAction.Move(position));
            notifyObservers(new SlingshotUpdateAction.Stretch(position));
        }
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
