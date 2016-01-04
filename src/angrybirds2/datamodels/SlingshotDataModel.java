package angrybirds2.datamodels;

import angrybirds2.datamodels.objects.birds.BirdDataModel;
import angrybirds2.utils.Vector2d;

/**
 * TODO: Description
 *
 * @author Quentin Brault
 */
public class SlingshotDataModel extends DataModel {

    /**
     * Position du lance-oiseau dans le niveau.
     */
    private Vector2d position;

    /**
     * Taille du lance-oiseau.
     */
    private Vector2d size;

    /**
     * Position par défaut de la partie du lance-oiseau tenant l'oiseau pqr rapport à la position du lance-oiseau.
     * C'est à dire lorsque l'élastique est détendu.
     */
    private Vector2d defaultHolderPosition;

    /**
     * Position de la partie du lance-oiseau tenant l'oiseau par rapport à la position par défaut.
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
    private BirdDataModel bird;

    public SlingshotDataModel(Vector2d position, Vector2d size, Vector2d defaultHolderPosition, int range) {
        this.position = position;
        this.size = size;
        this.defaultHolderPosition = defaultHolderPosition;
        this.holderPosition = defaultHolderPosition;
        this.range = range;
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

    public Vector2d getDefaultHolderPosition() {
        return defaultHolderPosition;
    }

    public void setDefaultHolderPosition(Vector2d defaultHolderPosition) {
        this.defaultHolderPosition = defaultHolderPosition;
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

    public BirdDataModel getBird() {
        return bird;
    }

    public void setBird(BirdDataModel bird) {
        this.bird = bird;
    }

}
