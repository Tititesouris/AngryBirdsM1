package angrybirds.controllers;

import angrybirds.exceptions.UnknownBirdException;
import angrybirds.models.LevelModel;
import angrybirds.models.Model;
import angrybirds.models.objects.birds.BirdModel;
import angrybirds.models.objects.birds.RedBirdModel;
import angrybirds.utils.ModelViewPair;
import angrybirds.utils.Vector2d;
import angrybirds.utils.inputs.actions.InputAction;
import angrybirds.views.BirdView;
import angrybirds.views.RedBirdView;
import com.google.gson.JsonArray;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO: Description
 *
 * @author Tititesouris
 */
public class BirdController extends Controller {

    public BirdController(JsonArray birds) throws UnknownBirdException {
        for (int i = 0; i < birds.size(); i++) {
            BirdModel model = null;
            BirdView view = null;
            switch (birds.get(i).getAsString()) {
                case "RED":
                    model = new RedBirdModel(Vector2d.ZERO, Vector2d.ZERO, Vector2d.ZERO);
                    view = new RedBirdView();
                    break;
                case "YELLOW":
                    //TODO: yellow
                    model = new RedBirdModel(Vector2d.ZERO, Vector2d.ZERO, Vector2d.ZERO);
                    view = new RedBirdView();
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
