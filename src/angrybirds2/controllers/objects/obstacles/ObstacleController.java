package angrybirds2.controllers.objects.obstacles;

import angrybirds2.controllers.objects.ObjectController;
import angrybirds2.models.objects.obstacles.ObstacleModel;
import angrybirds2.views.abstracts.objects.obstacles.ObstacleView;

/**
 * TODO: Description
 *
 * @author Quentin Brault
 */
public abstract class ObstacleController extends ObjectController {

    public ObstacleController(ObstacleModel model, ObstacleView view) {
        super(model, view);
    }

    @Override
    public abstract ObstacleModel getModel();

    @Override
    public abstract ObstacleView getView();

}
