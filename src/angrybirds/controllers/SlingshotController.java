package angrybirds.controllers;

import angrybirds.models.Model;
import angrybirds.models.SlingshotModel;
import angrybirds.utils.ModelViewPair;
import angrybirds.utils.Vector2d;
import angrybirds.inputs.actions.InputAction;
import angrybirds.inputs.actions.SlingshotInputAction;
import angrybirds.views.SlingshotView;
import angrybirds.views.View;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.List;

/**
 * TODO: Description
 *
 * @author Tititesouris
 */
public class SlingshotController extends Controller {

    public SlingshotController(JsonObject slingshot) {
        JsonArray position = slingshot.get("position").getAsJsonArray();
        SlingshotModel model = new SlingshotModel(
                new Vector2d(position.get(0).getAsFloat(), position.get(1).getAsFloat()),
                slingshot.get("range").getAsInt());
        SlingshotView view = new SlingshotView();
        addModelViewPair(new ModelViewPair<>(model, view));

    }

    @Override
    public void onInput(InputAction inputAction) {
        List<Model> models = getModels();
        List<View> views = getViews();
        for (int i = 0; i < models.size(); i++) {
            SlingshotModel model = (SlingshotModel) models.get(i);
            SlingshotView view = (SlingshotView) views.get(i);

            if (inputAction instanceof SlingshotInputAction) {
                if (inputAction instanceof SlingshotInputAction.Pull)
                    model.pull(((SlingshotInputAction.Pull) inputAction).getHolderPosition());
                else if (inputAction instanceof SlingshotInputAction.Release)
                    model.release();
            }

        }
    }

}
