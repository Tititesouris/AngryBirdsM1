package angrybirds.controllers;

import angrybirds.exceptions.AngryBirdsException;
import angrybirds.inputs.actions.GameInputAction;
import angrybirds.models.GameModel;
import angrybirds.models.LevelModel;
import angrybirds.utils.ModelViewPair;
import angrybirds.inputs.actions.InputAction;
import angrybirds.views.GameView;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

/**
 * TODO: Description
 *
 * @author Tititesouris
 */
public class GameController extends Controller {

    private LevelController levelController;

    public GameController() throws AngryBirdsException {
        JsonParser parser = new JsonParser();
        try {
            JsonElement json = parser.parse(new BufferedReader(new FileReader("res/game.json")));

            JsonObject game = json.getAsJsonObject();
            JsonArray levels = game.get("levels").getAsJsonArray();

            levelController = new LevelController(levels);

            GameModel model = new GameModel(levelController.getModels());
            GameView view = new GameView(levelController.getViews());
            addModelViewPair(new ModelViewPair<>(model, view));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onInput(InputAction inputAction) {
        List<GameModel> models = getModels();
        List<GameView> views = getViews();
        for (int i = 0; i < models.size(); i++) {
            GameModel model = models.get(i);
            GameView view = views.get(i);

            if (inputAction instanceof GameInputAction) {
                if (inputAction instanceof GameInputAction.EnterLevel) {
                    model.enterLevel(((GameInputAction.EnterLevel) inputAction).getId());
                    view.init(model);
                }
            }

        }
    }

}
