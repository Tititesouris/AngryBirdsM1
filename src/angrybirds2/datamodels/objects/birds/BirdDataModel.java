package angrybirds2.datamodels.objects.birds;

import angrybirds2.datamodels.objects.ObjectDataModel;
import angrybirds2.utils.Vector2d;

/**
 * TODO: Description
 *
 * @author Quentin Brault
 */
public abstract class BirdDataModel extends ObjectDataModel {

    public BirdDataModel(Vector2d position, Vector2d size, float density) {
        super(position, Vector2d.ZERO, Vector2d.ZERO, size, density, 0, 0, false);
    }

}
