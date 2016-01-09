package angrybirds.models.objects.birds;

import angrybirds.models.LevelModel;
import angrybirds.utils.Vector2d;

/**
 * TODO: Description
 *
 * @author Tititesouris
 */
public class YellowBirdModel extends BirdModel {

    public YellowBirdModel(LevelModel level, Vector2d position, Vector2d velocity, Vector2d acceleration) {
        super(level, position, velocity, acceleration, new Vector2d(20), 0.0000005f);
    }

}
