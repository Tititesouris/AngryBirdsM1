package angrybirds.controllers;

import angrybirds.models.Model;
import angrybirds.models.SlingshotModel;
import angrybirds.utils.ModelViewPair;
import angrybirds.utils.Vector2d;
import angrybirds.utils.inputs.actions.InputAction;
import angrybirds.utils.inputs.actions.SlingshotInputAction;
import angrybirds.views.SlingshotView;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO: Description
 *
 * @author Tititesouris
 */
public class SlingshotController extends Controller {

    public SlingshotController(JsonObject slingshot) {
        JsonArray position = slingshot.get("position").getAsJsonArray();
        JsonArray size = slingshot.get("size").getAsJsonArray();
        SlingshotModel model = new SlingshotModel(
                new Vector2d(position.get(0).getAsFloat(), position.get(1).getAsFloat()),
                new Vector2d(size.get(0).getAsFloat(), size.get(1).getAsFloat()),
                slingshot.get("range").getAsInt());
        SlingshotView view = new SlingshotView();
        addModelViewPair(new ModelViewPair<>(model, view));

    }

    @Override
    public void onInput(InputAction inputAction) {
        for (Model model : getModels()) {
            SlingshotModel slingshot = (SlingshotModel) model;
            if (inputAction instanceof SlingshotInputAction) {
                if (inputAction instanceof SlingshotInputAction.Pull) {
                    slingshot.pull(((SlingshotInputAction.Pull) inputAction).getPosition());
                }
            }
        }
    }

    @Override
    public void init() {

    }

    @Override
    public void update(int delta) {

    }

    @Override
    public void display() {

    }
}
