package angrybirds2.controllers.objects.birds;

import angrybirds2.controllers.objects.ObjectController;
import angrybirds2.models.objects.birds.BirdModel;
import angrybirds2.utils.inputs.InputAction;
import angrybirds2.views.abstracts.objects.birds.BirdView;

/**
 * TODO: Description
 *
 * @author Quentin Brault
 */
public class BirdController extends ObjectController {

    public BirdController(BirdModel model, BirdView view) {
        super(model, view);
    }

    @Override
    public void onInput(InputAction inputAction) {

    }

    @Override
    public BirdModel getModel() {
        return (BirdModel) model;
    }

    @Override
    public BirdView getView() {
        return (BirdView) view;
    }

}
