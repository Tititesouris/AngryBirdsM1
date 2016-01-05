package angrybirds.controllers;

import angrybirds.exceptions.AngryBirdsException;
import angrybirds.exceptions.UnknownBirdException;
import angrybirds.models.LevelModel;
import angrybirds.models.Model;
import angrybirds.models.SlingshotModel;
import angrybirds.models.objects.birds.BirdModel;
import angrybirds.utils.ModelViewPair;
import angrybirds.utils.inputs.actions.InputAction;
import angrybirds.utils.inputs.actions.LevelInputAction;
import angrybirds.views.LevelView;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO: Description
 *
 * @author Tititesouris
 */
public class LevelController extends Controller {

    private BirdController birdController;

    private SlingshotController slingshotController;

    public LevelController(JsonArray levels) throws AngryBirdsException {
        for (JsonElement element : levels) {
            JsonObject level = element.getAsJsonObject();
            String name = level.get("name").getAsString();
            JsonArray birds = level.get("birds").getAsJsonArray();
            JsonObject slingshot = level.get("slingshot").getAsJsonObject();
            JsonArray obstacles = level.get("obstacles").getAsJsonArray();
            JsonArray pigs = level.get("pigs").getAsJsonArray();
            birdController = new BirdController(birds);
            slingshotController = new SlingshotController(slingshot);
            // TODO: obstacles and pigs
            List<BirdModel> birdModels = birdController.getModels();
            List<SlingshotModel> slingshotModel = slingshotController.getModels();
            LevelModel levelModel = new LevelModel(name, birdModels, slingshotModel.get(0));
            LevelView levelView = new LevelView();
            addModelViewPair(new ModelViewPair<>(levelModel, levelView));

        }
    }

    @Override
    public void onInput(InputAction inputAction) {
        for (Model model : getModels()) {
            LevelModel level = (LevelModel) model;

            if (inputAction instanceof LevelInputAction) {
                if (inputAction instanceof LevelInputAction.Start)
                    level.start();
            }

        }
    }

    @Override
    public void init() {
        birdController.init();
        slingshotController.init();
    }

    @Override
    public void update(int delta) {
        birdController.update(delta);
        slingshotController.update(delta);
    }

    @Override
    public void display() {
        birdController.display();
        slingshotController.display();
    }

}
