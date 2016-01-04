package angrybirds2.models.objects.obstacles;

import angrybirds2.datamodels.objects.obstacles.ObstacleDataModel;
import angrybirds2.models.objects.ObjectModel;

/**
 * TODO: Description
 *
 * @author Quentin Brault
 */
public class ObstacleModel extends ObjectModel {

    public ObstacleModel(ObstacleDataModel dataModel) {
        super(dataModel);
    }

    @Override
    protected ObstacleDataModel getDataModel() {
        return (ObstacleDataModel) dataModel;
    }

}
