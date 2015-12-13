package angrybirds.models;


/**
 * TODO: Description
 *
 * @author Tititesouris
 */
public interface ObstacleModelInterface {

    /**
     * The constructor MUST have:
     * A vector2d 'start'
     * A vector2d 'target'
     * A double 'speed'
     */

    /**
     * Returns true if the object is within reasonable range of the target
     * @return
     */
    boolean hasReachedTarget();

    /**
     * Returns true if the object touches one of the border of the window
     * @return
     */
    boolean isOutOfBounds();

    /**
     * Sets the starting point as the target, sets the target as the starting point
     */
    void flipTarget();

}
