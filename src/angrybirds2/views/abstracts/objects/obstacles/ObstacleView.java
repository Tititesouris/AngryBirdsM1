package angrybirds2.views.abstracts.objects.obstacles;

import angrybirds2.datamodels.objects.obstacles.ObstacleDataModel;
import angrybirds2.views.abstracts.objects.ObjectView;

/**
 * TODO: Description
 *
 * @author Quentin Brault
 */
public abstract class ObstacleView extends ObjectView {

    public ObstacleView(ObstacleDataModel dataModel) {
        super(dataModel);
    }

    @Override
    public abstract ObstacleDataModel getDataModel();

}
