package angrybirds2.controllers;

import angrybirds2.models.GameModel;
import angrybirds2.utils.inputs.InputAction;
import angrybirds2.views.abstracts.GameView;

/**
 * TODO: Description
 *
 * @author Quentin Brault
 */
public class GameController extends Controller {

    public GameController(GameModel model, GameView view) {
        super(model, view);
    }

    @Override
    public void onInput(InputAction inputAction) {

    }

    @Override
    protected GameModel getModel() {
        return (GameModel) model;
    }

    @Override
    protected GameView getView() {
        return (GameView) view;
    }

}
