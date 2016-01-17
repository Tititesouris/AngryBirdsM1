package angrybirds.controllers;

import angrybirds.exceptions.AngryBirdsException;
import angrybirds.notifications.inputs.actions.GameInputAction;
import angrybirds.models.GameModel;
import angrybirds.utils.Constants;
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
 * Cette classe représente le controlleur pour le jeu.
 *
 * @author Quentin Brault
 * @since  2013/10/01
 */
public class GameController extends Controller {

    /**
     * Créé un controlleur pour le jeu.
     *
     * @param src Path vers le fichier de description du jeu.
     * @throws AngryBirdsException
     */
    public GameController(String src) throws AngryBirdsException {
        JsonParser parser = new JsonParser();
        try {
            JsonElement json = parser.parse(new BufferedReader(new FileReader(src)));

            JsonObject game = json.getAsJsonObject();
            JsonArray levels = game.get("levels").getAsJsonArray();
            System.out.println(levels);

            LevelController levelController = new LevelController(levels);

            GameModel model = new GameModel(levelController.getModels());
            GameView view = new GameView(model.getId(), levelController.getViews(), model.isDebug());
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
        else if (inputAction instanceof GameInputAction.SwitchDebug) {
            GameModel model = models.get(((GameInputAction.SwitchDebug) inputAction).getGameId());
            model.switchDebug();
        }
    }

}
