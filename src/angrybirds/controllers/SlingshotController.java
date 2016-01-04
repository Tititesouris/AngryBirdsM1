package angrybirds.controllers;

import angrybirds.models.Model;
import angrybirds.models.SlingshotModel;
import angrybirds.utils.ModelViewPair;
import angrybirds.utils.Vector2d;
import angrybirds.utils.inputs.actions.InputAction;
import angrybirds.utils.inputs.actions.SlingshotInputAction;
import angrybirds.views.SlingshotView;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO: Description
 *
 * @author Tititesouris
 */
public class SlingshotController extends Controller {

    public SlingshotController(float[] position, float[] size, int range) {
        SlingshotModel model = new SlingshotModel(new Vector2d(position[0], position[1]), new Vector2d(size[0], size[1]), range);
        SlingshotView view = new SlingshotView();
        view.init(model);
        addModelViewPair(new ModelViewPair(model, view));
    }

    @Override
    public void onInput(InputAction inputAction) {
        SlingshotModel slingshot = getModels().get(0);
        if (inputAction instanceof SlingshotInputAction) {
            if (inputAction instanceof SlingshotInputAction.Pull) {
                slingshot.pull(((SlingshotInputAction.Pull) inputAction).getPosition());
            }
        }
    }

    @Override
    public List<SlingshotModel> getModels() {
        List<SlingshotModel> models = new ArrayList<>();
        for (Model model : getAbstractModels())
            models.add((SlingshotModel) model);
        return models;
    }

}
