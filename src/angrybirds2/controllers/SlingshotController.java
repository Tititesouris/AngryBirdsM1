package angrybirds2.controllers;

import angrybirds2.models.SlingshotModel;
import angrybirds2.utils.inputs.InputAction;
import angrybirds2.utils.inputs.SlingshotAction;
import angrybirds2.views.abstracts.SlingshotView;

/**
 * TODO: Description
 *
 * @author Quentin Brault
 */
public class SlingshotController extends Controller {

    public SlingshotController(SlingshotModel model, SlingshotView view) {
        super(model, view);
    }

    @Override
    public void onInput(InputAction inputAction) {
        if (inputAction instanceof SlingshotAction) {
            if (inputAction instanceof SlingshotAction.Pull)
                getModel().pull(((SlingshotAction.Pull) inputAction).getHolderPosition());
            else if (inputAction instanceof SlingshotAction.Release)
                getModel().realease();
        }
    }

    @Override
    protected SlingshotModel getModel() {
        return (SlingshotModel) model;
    }

    @Override
    protected SlingshotView getView() {
        return (SlingshotView) view;
    }

}
