package angrybirds.views;

import angrybirds.models.GameModel;
import angrybirds.models.LevelModel;
import angrybirds.models.Model;
import angrybirds.utils.updates.actions.UpdateAction;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO: Description
 *
 * @author Tititesouris
 */
public class GameView extends View {

    private List<String> levels;

    private boolean inLevel;

    @Override
    public void init(Model model) {
        GameModel game = (GameModel)model;
        this.levels = new ArrayList<>();
        for (LevelModel level : game.getLevels()) {
            this.levels.add(level.getName());
        }
        this.inLevel = game.getLevel() != null;
    }

    @Override
    public void input(Input input) {

    }

    @Override
    public void display(Graphics graphics) {
        if (inLevel) {

        }
        else {
            int x = 50;
            for (String levelName : levels) {
                graphics.drawString(levelName, x+=100, 200);
            }
        }
    }

    @Override
    public void onUpdate(UpdateAction updateAction) {

    }

}
