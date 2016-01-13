package angrybirds.controllers;

import angrybirds.controllers.objects.BirdController;
import angrybirds.controllers.objects.ObstacleController;
import angrybirds.controllers.objects.PigController;
import angrybirds.exceptions.AngryBirdsException;
import angrybirds.models.LevelModel;
import angrybirds.models.SlingshotModel;
import angrybirds.notifications.inputs.actions.LevelInputAction;
import angrybirds.utils.ModelViewPair;
import angrybirds.notifications.inputs.actions.InputAction;
import angrybirds.views.LevelView;
import angrybirds.views.SlingshotView;
import angrybirds.views.objects.PigView;
import angrybirds.views.objects.birds.BirdView;
import angrybirds.views.objects.obstacles.ObstacleView;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.SortedMap;

/**
 * Cette classe représente le controlleur pour les niveaux.
 *
 * @author Quentin Brault
 * @since  2013/10/01
 */
public class LevelController extends Controller {

    /**
     * Créé un nouveau controlleur de niveaux.
     *
     * @param levels Liste des descriptions de niveau.
     * @throws AngryBirdsException
     */
    public LevelController(JsonArray levels) throws AngryBirdsException {
        for (JsonElement element : levels) {
            JsonObject level = element.getAsJsonObject();
            String name = level.get("name").getAsString();
            float ground = level.get("ground").getAsFloat();
            JsonObject slingshot = level.get("slingshot").getAsJsonObject();
            JsonArray birds = level.get("birds").getAsJsonArray();
            JsonArray obstacles = level.get("obstacles").getAsJsonArray();
            JsonArray pigs = level.get("pigs").getAsJsonArray();

            LevelModel levelModel = new LevelModel(name, ground);

            SlingshotController slingshotController = new SlingshotController(slingshot, levelModel);
            BirdController birdController = new BirdController(birds, slingshot, levelModel);
            ObstacleController obstacleController = new ObstacleController(obstacles, levelModel);
            PigController pigController = new PigController(pigs, levelModel);

            SortedMap<Integer, SlingshotModel> slingshotModels = slingshotController.getModels();
            SortedMap<Integer, SlingshotView> slingshotViews = slingshotController.getViews();
            // Il n'y a qu'un seul slingshot par niveau.
            levelModel.setSlingshot(slingshotModels.get(slingshotModels.firstKey()));
            SlingshotView slingshotView = slingshotViews.get(slingshotViews.firstKey());

            levelModel.setBirds(birdController.getModels());
            SortedMap<Integer, BirdView> birdViews = birdController.getViews();

            levelModel.setObstacles(obstacleController.getModels());
            SortedMap<Integer, ObstacleView> obstacleViews = obstacleController.getViews();

            levelModel.setPigs(pigController.getModels());
            SortedMap<Integer, PigView> pigViews = pigController.getViews();

            LevelView levelView = new LevelView(levelModel.getId(), levelModel.getName(), slingshotView, birdViews, obstacleViews, pigViews);
            addModelViewPair(new ModelViewPair<>(levelModel, levelView));
        }
    }

    @Override
    public void onInput(InputAction inputAction) {
        SortedMap<Integer, LevelModel> models = getModels();
        if (inputAction instanceof LevelInputAction.Ready) {
            LevelModel model = models.get(((LevelInputAction.Ready) inputAction).getId());
            model.ready();
        }
    }

}
