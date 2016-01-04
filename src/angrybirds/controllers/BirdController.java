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

import java.util.ArrayList;
import java.util.List;

/**
 * TODO: Description
 *
 * @author Tititesouris
 */
public class BirdController extends Controller {

    public BirdController(String[] birds) throws UnknownBirdException {
        for (String bird : birds) {
            BirdModel birdModel = null;
            BirdView birdView = null;
            switch (bird) {
                case "RED":
                    birdModel = new RedBirdModel(Vector2d.ZERO, Vector2d.ZERO, Vector2d.ZERO);
                    birdView = new RedBirdView();
                    break;
                case "YELLOW":
                    birdModel = new RedBirdModel(Vector2d.ZERO, Vector2d.ZERO, Vector2d.ZERO);
                    birdView = new RedBirdView();
                    //TODO: same for yellow
                    break;
                default:
                    throw new UnknownBirdException();
            }
            addModelViewPair(new ModelViewPair(birdModel, birdView));
        }
    }

    @Override
    public void onInput(InputAction inputAction) {

    }

    @Override
    public List<BirdModel> getModels() {
        List<BirdModel> models = new ArrayList<>();
        for (Model model : getAbstractModels())
            models.add((BirdModel) model);
        return models;
    }
}
