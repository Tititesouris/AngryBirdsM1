package angrybirds.controllers.objects;

import angrybirds.controllers.Controller;
import angrybirds.exceptions.UnknownBirdException;
import angrybirds.models.LevelModel;
import angrybirds.models.objects.birds.BirdModel;
import angrybirds.models.objects.birds.RedBirdModel;
import angrybirds.models.objects.birds.YellowBirdModel;
import angrybirds.utils.Constants;
import angrybirds.utils.ModelViewPair;
import angrybirds.utils.Vector2d;
import angrybirds.notifications.inputs.actions.InputAction;
import angrybirds.views.objects.birds.BirdView;
import angrybirds.views.objects.birds.RedBirdView;
import angrybirds.views.objects.birds.YellowBirdView;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * TODO: Description
 *
 * @author Tititesouris
 */
public class BirdController extends Controller {

    public BirdController(JsonArray birds, JsonObject slingshot, LevelModel level) throws UnknownBirdException {
        for (int i = 0; i < birds.size(); i++) {
            String bird = birds.get(i).getAsString();
            BirdModel model;
            BirdView view;
            switch (bird) {
                case "RED":
                    model = new RedBirdModel(
                            level,
                            new Vector2d(
                                    slingshot.get("position").getAsJsonArray().get(0).getAsFloat() + i * 50,
                                    Constants.WINDOW_HEIGHT - level.getGround()
                            ),
                            Vector2d.ZERO, Vector2d.ZERO
                    );
                    view = new RedBirdView(model.getId(), model.getPosition(), model.getSize(), model.getRotation());
                    break;
                case "YELLOW":
                    model = new YellowBirdModel(
                            level,
                            new Vector2d(
                                    slingshot.get("position").getAsJsonArray().get(0).getAsFloat() + i * 50,
                                    Constants.WINDOW_HEIGHT - level.getGround()
                            ),
                            Vector2d.ZERO, Vector2d.ZERO
                    );
                    view = new YellowBirdView(model.getId(), model.getPosition(), model.getSize(), model.getRotation());
                    break;
                default:
                    throw new UnknownBirdException();
            }
            addModelViewPair(new ModelViewPair<>(model, view));

        }
    }

    @Override
    public void onInput(InputAction inputAction) {

    }

}
