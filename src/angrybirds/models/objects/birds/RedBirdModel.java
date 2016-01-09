package angrybirds.models.objects.birds;

import angrybirds.utils.Vector2d;

/**
 * TODO: Description
 *
 * @author Tititesouris
 */
public class RedBirdModel extends BirdModel {

    public RedBirdModel(Vector2d position, Vector2d velocity, Vector2d acceleration) {
        super(position, velocity, acceleration, new Vector2d(30), 0.0001f);
    }

}
