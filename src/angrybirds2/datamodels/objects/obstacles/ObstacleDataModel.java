package angrybirds2.datamodels.objects.obstacles;

import angrybirds2.datamodels.objects.ObjectDataModel;
import angrybirds2.utils.Vector2d;

/**
 * TODO: Description
 *
 * @author Quentin Brault
 */
public abstract class ObstacleDataModel extends ObjectDataModel {

    public ObstacleDataModel(Vector2d position, Vector2d size, float density) {
        super(position, Vector2d.ZERO, Vector2d.ZERO, size, density, 0, 0, true);
    }

}
