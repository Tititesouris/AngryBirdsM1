package angrybirds.views;

import angrybirds.inputs.actions.GameInputAction;
import angrybirds.models.GameModel;
import angrybirds.models.LevelModel;
import angrybirds.models.Model;
import angrybirds.updates.actions.GameUpdateAction;
import angrybirds.updates.actions.UpdateAction;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

import java.util.List;

/**
 * TODO: Description
 *
 * @author Tititesouris
 */
public class GameView extends View {

    private List<LevelView> levels;

    private LevelView level;

    public GameView(List<LevelView> levels) {
        this.levels = levels;
    }

    @Override
    public void init(Model model) {
        GameModel game = (GameModel)model;
        List<LevelModel> levels = game.getLevels();
        LevelModel level = game.getLevel();
        if (level != null) {
            this.level = this.levels.get(levels.indexOf(level));
            this.level.init(level);
        }
    }

    @Override
    public void input(Input input) {
        if (level == null) {
            if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON))
                notifyObservers(new GameInputAction.EnterLevel(0));
        } else
            level.input(input);
    }

    @Override
    public void display(Graphics graphics) {
        if (level == null) {
            graphics.drawString("Angry Bird. PRESS SPACE", 200, 200);
        }
        else
            level.display(graphics);
    }

    @Override
    public void onUpdate(UpdateAction updateAction) {
        if (updateAction instanceof GameUpdateAction) {
            if (updateAction instanceof GameUpdateAction.EnterLevel)
                enterLevel(((GameUpdateAction.EnterLevel) updateAction).getId());
        }
    }

    private void enterLevel(int id) {
        this.level = levels.get(id);
        level.ready();
    }

}
