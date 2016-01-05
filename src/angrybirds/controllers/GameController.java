package angrybirds.controllers;

import angrybirds.exceptions.AngryBirdsException;
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

    public GameController() throws AngryBirdsException {
        JsonParser parser = new JsonParser();
        try {
            JsonElement json = parser.parse(new BufferedReader(new FileReader("res/game.json")));

            JsonObject game = json.getAsJsonObject();
            JsonArray levels = game.get("levels").getAsJsonArray();

            levelController = new LevelController(levels);

            GameModel model = new GameModel(levelController.getModels());
            GameView view = new GameView();
            addModelViewPair(new ModelViewPair<>(model, view));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onInput(InputAction inputAction) {

    }

    @Override
    public void init() {
        levelController.init();
    }

    @Override
    public void update(int delta) {
        levelController.update(delta);
    }

    @Override
    public void display() {
        levelController.display();
    }

}
