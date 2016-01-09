package angrybirds.controllers;

import angrybirds.models.LevelModel;
import angrybirds.models.SlingshotModel;
import angrybirds.utils.ModelViewPair;
import angrybirds.utils.Vector2d;
import angrybirds.notifications.inputs.actions.InputAction;
import angrybirds.notifications.inputs.actions.SlingshotInputAction;
import angrybirds.views.SlingshotView;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.SortedMap;

/**
 * TODO: Description
 *
 * @author Tititesouris
 */
public class SlingshotController extends Controller {

    public SlingshotController(JsonObject slingshot, LevelModel level) {
        JsonArray position = slingshot.get("position").getAsJsonArray();
        int range = slingshot.get("range").getAsInt();
        SlingshotModel model = new SlingshotModel(
                level,
                new Vector2d(position.get(0).getAsFloat(), position.get(1).getAsFloat()),
                range
        );
        SlingshotView view = new SlingshotView(model.getId(), model.getPosition(), model.getSize(), model.getHolderPosition());
        addModelViewPair(new ModelViewPair<>(model, view));

    }

    @Override
    public void onInput(InputAction inputAction) {
        SortedMap<Integer, SlingshotModel> models = getModels();
        // Un seul lance-oiseau par niveau
        SlingshotModel model = models.get(models.firstKey());
        if (inputAction instanceof SlingshotInputAction.Pull) {
            model.pull(((SlingshotInputAction.Pull) inputAction).getHolderPosition());
        }
        else if (inputAction instanceof SlingshotInputAction.Release) {
            model.release();
        }
    }

}
