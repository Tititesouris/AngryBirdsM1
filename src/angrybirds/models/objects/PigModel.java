package angrybirds.models.objects;

import angrybirds.models.LevelModel;
import angrybirds.utils.Vector2d;

/**
 * TODO: Description
 *
 * @author Tititesouris
 */
public class PigModel extends ObjectModel {

    private LevelModel level;

    public PigModel(LevelModel level, Vector2d position, Vector2d velocity, Vector2d acceleration, float rotation, float angularSpeed) {
        super(position, velocity, acceleration, new Vector2d(50), 2, rotation, angularSpeed, true);
        this.level = level;
    }

    @Override
    public boolean collidesWith(ObjectModel object) {
        return false;
    }

    @Override
    public float getSurface() {
        return (float) (Math.PI * (size.x / 2) * (size.y / 2));
    }

}
