package angrybirds.controllers;

import angrybirds.models.GameModel;
import angrybirds.models.LevelModel;
import angrybirds.models.Model;
import angrybirds.utils.ModelViewPair;
import angrybirds.utils.inputs.actions.InputAction;
import angrybirds.views.GameView;
import angrybirds.views.LevelView;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO: Description
 *
 * @author Tititesouris
 */
public class GameController extends Controller {

    private LevelController levelController;

    public GameController() {
        JsonParser parser = new JsonParser();
        try {
            JsonElement json = parser.parse(new BufferedReader(new FileReader("res/game.json")));

            JsonObject game = json.getAsJsonObject();
            JsonArray levels = game.get("levels").getAsJsonArray();
            for (JsonElement element : levels) {
                JsonObject level = element.getAsJsonObject();
                String name = level.get("name").getAsString();
                JsonArray birds = level.get("birds").getAsJsonArray();
                JsonObject slingshot = level.get("slingshot").getAsJsonObject();
                JsonArray obstacles = level.get("obstacles").getAsJsonArray();
                JsonArray pigs = level.get("pigs").getAsJsonArray();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        levelController = new LevelController();

        GameModel gameModel = new GameModel(levelController.getModels());
        GameView gameView = new GameView();
        addModelViewPair(new ModelViewPair(gameModel, gameView));
    }

    @Override
    public List<GameModel> getModels() {
        List<GameModel> models = new ArrayList<>();
        for (Model model : getAbstractModels())
            models.add((GameModel) model);
        return models;
    }

    @Override
    public void onInput(InputAction inputAction) {

    }

}
