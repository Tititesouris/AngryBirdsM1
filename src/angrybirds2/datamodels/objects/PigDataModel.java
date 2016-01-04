package angrybirds2.datamodels.objects;

import angrybirds2.utils.Vector2d;

/**
 * TODO: Description
 *
 * @author Quentin Brault
 */
public class PigDataModel extends ObjectDataModel {

    public PigDataModel(Vector2d position) {
        super(position, Vector2d.ZERO, Vector2d.ZERO, new Vector2d(20), 1, 0, 0, true);
    }

}
