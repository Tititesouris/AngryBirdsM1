package angrybirds.controllers;

import angrybirds.exceptions.UnknownBirdException;
import angrybirds.models.LevelModel;
import angrybirds.models.Model;
import angrybirds.utils.ModelViewPair;
import angrybirds.utils.inputs.actions.InputAction;
import angrybirds.utils.inputs.actions.LevelInputAction;
import angrybirds.views.LevelView;

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

    public LevelController() {
        //TODO: Read game.json to find 'birds' and 'slingshotX'
        String[] birds = new String[] {"RED", "RED", "YELLOW"};
        float[] slingshotPosition = new float[] {50, 250};
        float[] slingshotSize = new float[] {100, 200};
        int slingshotRange = 50;
        try {
            this.birdController = new BirdController(birds);
        } catch (UnknownBirdException e) {
            e.printStackTrace();
        }
        this.slingshotController = new SlingshotController(slingshotPosition, slingshotSize, slingshotRange);

        //TODO read game.json and create levels.
        LevelModel levelModel = new LevelModel("Level 1", birdController.getModels(), slingshotController.getModels().get(0));
        LevelView levelView = new LevelView();
        addModelViewPair(new ModelViewPair(levelModel, levelView));
    }

    @Override
    public void onInput(InputAction inputAction) {
        LevelModel level = getModels().get(0);
        if (inputAction instanceof LevelInputAction) {
            if (inputAction instanceof LevelInputAction.Start)
                level.start();
        }
    }

    @Override
    public List<LevelModel> getModels() {
        List<LevelModel> models = new ArrayList<>();
        for (Model model : getAbstractModels())
        models.add((LevelModel) model);
        return models;
    }

}
