package angrybirds.models.objects;

import angrybirds.utils.Vector2d;

/**
 * TODO: Description
 *
 * @author Tititesouris
 */
public class PigModel extends ObjectModel {

    public PigModel(Vector2d position, Vector2d velocity, Vector2d acceleration, float rotation, float angularSpeed) {
        super(position, velocity, acceleration, new Vector2d(50), 2, rotation, angularSpeed, true);
    }

}
