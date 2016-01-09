package angrybirds.models.objects.obstacles;

import angrybirds.utils.Vector2d;

/**
 * TODO: Description
 *
 * @author Tititesouris
 */
public enum ObstacleSize {

    SMALL(new Vector2d(50, 50)), MEDIUM(new Vector2d(150, 50)), LARGE(new Vector2d(250, 150));

    private Vector2d size;

    ObstacleSize(Vector2d size) {
        this.size = size;
    }

    public Vector2d getSize() {
        return size;
    }

}
