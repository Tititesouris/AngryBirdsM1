package angrybirds.models.objects.birds;

import angrybirds.models.LevelModel;
import angrybirds.models.objects.ObjectModel;
import angrybirds.utils.Vector2d;

/**
 * TODO: Description
 *
 * @author Tititesouris
 */
public class YellowBirdModel extends BirdModel {

    public YellowBirdModel(LevelModel level, Vector2d position, Vector2d velocity, Vector2d acceleration) {
        super(level, position, velocity, acceleration, new Vector2d(30), 0.0005f);
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
