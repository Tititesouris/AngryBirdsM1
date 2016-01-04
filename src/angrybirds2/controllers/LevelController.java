package angrybirds2.controllers;

import angrybirds2.models.LevelModel;
import angrybirds2.utils.inputs.InputAction;
import angrybirds2.views.abstracts.LevelView;

/**
 * TODO: Description
 *
 * @author Quentin Brault
 */
public class LevelController extends Controller {

    public LevelController(LevelModel model, LevelView view) {
        super(model, view);
    }

    @Override
    public void onInput(InputAction inputAction) {

    }

    @Override
    protected LevelModel getModel() {
        return (LevelModel) model;
    }

    @Override
    protected LevelView getView() {
        return (LevelView) view;
    }

}
