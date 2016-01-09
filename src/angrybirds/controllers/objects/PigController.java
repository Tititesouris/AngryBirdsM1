package angrybirds.controllers.objects;

import angrybirds.controllers.Controller;
import angrybirds.models.LevelModel;
import angrybirds.models.objects.PigModel;
import angrybirds.utils.ModelViewPair;
import angrybirds.utils.Vector2d;
import angrybirds.notifications.inputs.actions.InputAction;
import angrybirds.views.objects.PigView;
import com.google.gson.JsonArray;

/**
 * TODO: Description
 *
 * @author Tititesouris
 */
public class PigController extends Controller {

    public PigController(JsonArray pigs, LevelModel level) {
        for (int i = 0; i < pigs.size(); i++) {
            JsonArray position = pigs.get(i).getAsJsonArray();
            PigModel model = new PigModel(
                    level,
                    new Vector2d(position.get(0).getAsFloat(), position.get(1).getAsFloat()),
                    Vector2d.ZERO,
                    Vector2d.ZERO,
                    0,
                    0
            );
            PigView view = new PigView(model.getId(), model.getPosition(), model.getSize(), model.getRotation());
            addModelViewPair(new ModelViewPair<>(model, view));

        }
    }

    @Override
    public void onInput(InputAction inputAction) {

    }

}
