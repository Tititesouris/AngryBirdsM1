package angrybirds.controllers;

import angrybirds.controllers.objects.BirdController;
import angrybirds.controllers.objects.ObstacleController;
import angrybirds.controllers.objects.PigController;
import angrybirds.exceptions.AngryBirdsException;
import angrybirds.models.LevelModel;
import angrybirds.models.Model;
import angrybirds.models.SlingshotModel;
import angrybirds.models.objects.PigModel;
import angrybirds.models.objects.birds.BirdModel;
import angrybirds.models.objects.obstacles.ObstacleModel;
import angrybirds.utils.ModelViewPair;
import angrybirds.inputs.actions.InputAction;
import angrybirds.inputs.actions.LevelInputAction;
import angrybirds.views.LevelView;
import angrybirds.views.SlingshotView;
import angrybirds.views.objects.PigView;
import angrybirds.views.objects.birds.BirdView;
import angrybirds.views.objects.obstacles.ObstacleView;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.List;

/**
 * TODO: Description
 *
 * @author Tititesouris
 */
public class LevelController extends Controller {

    private SlingshotController slingshotController;

    private BirdController birdController;

    private ObstacleController obstacleController;

    private PigController pigController;

    public LevelController(JsonArray levels) throws AngryBirdsException {
        for (JsonElement element : levels) {
            JsonObject level = element.getAsJsonObject();
            String name = level.get("name").getAsString();
            float ground = level.get("ground").getAsFloat();
            JsonObject slingshot = level.get("slingshot").getAsJsonObject();
            JsonArray birds = level.get("birds").getAsJsonArray();
            JsonArray obstacles = level.get("obstacles").getAsJsonArray();
            JsonArray pigs = level.get("pigs").getAsJsonArray();

            LevelModel levelModel = null;
            LevelView levelView = null;

            slingshotController = new SlingshotController(slingshot);
            birdController = new BirdController(birds, levelView);
            obstacleController = new ObstacleController(obstacles);
            pigController = new PigController(pigs);

            List<SlingshotModel> slingshotModels = slingshotController.getModels();
            List<SlingshotView> slingshotViews = slingshotController.getViews();
            List<BirdModel> birdModels = birdController.getModels();
            List<BirdView> birdViews = birdController.getViews();
            List<ObstacleModel> obstacleModels = obstacleController.getModels();
            List<ObstacleView> obstacleViews = obstacleController.getViews();
            List<PigModel> pigModels = pigController.getModels();
            List<PigView> pigViews = pigController.getViews();

            levelModel = new LevelModel(name, ground, slingshotModels.get(0), birdModels, obstacleModels, pigModels);
            levelView = new LevelView(slingshotViews.get(0), birdViews, obstacleViews, pigViews);
            addModelViewPair(new ModelViewPair<>(levelModel, levelView));
        }
    }

    @Override
    public void onInput(InputAction inputAction) {
        List<LevelModel> models = getModels();
        List<LevelView> views = getViews();
        if (inputAction instanceof LevelInputAction) {
            LevelModel model = models.get(((LevelInputAction) inputAction).getId());
            LevelView view = views.get(((LevelInputAction) inputAction).getId());

            if (inputAction instanceof LevelInputAction.Ready) {
                model.ready();
                view.init(model);
            }
        }
    }

}
