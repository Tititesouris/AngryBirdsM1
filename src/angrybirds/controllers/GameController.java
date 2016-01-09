package angrybirds.controllers;

import angrybirds.exceptions.AngryBirdsException;
import angrybirds.notifications.inputs.actions.GameInputAction;
import angrybirds.models.GameModel;
import angrybirds.utils.ModelViewPair;
import angrybirds.notifications.inputs.actions.InputAction;
import angrybirds.views.GameView;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.SortedMap;

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
            GameView view = new GameView(model.getId(), levelController.getViews());
            addModelViewPair(new ModelViewPair<>(model, view));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onInput(InputAction inputAction) {
        SortedMap<Integer, GameModel> models = getModels();
        if (inputAction instanceof GameInputAction.EnterLevel) {
            GameModel model = models.get(((GameInputAction.EnterLevel) inputAction).getGameId());
            model.enterLevel(((GameInputAction.EnterLevel) inputAction).getLevelId());
        }
    }

}
