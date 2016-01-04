package angrybirds2.controllers.objects;

import angrybirds2.controllers.Controller;
import angrybirds2.models.objects.ObjectModel;
import angrybirds2.views.abstracts.objects.ObjectView;

/**
 * TODO: Description
 *
 * @author Quentin Brault
 */
public abstract class ObjectController extends Controller {

    public ObjectController(ObjectModel model, ObjectView view) {
        super(model, view);
    }

    @Override
    public abstract ObjectModel getModel();

    @Override
    public abstract ObjectView getView();

}
