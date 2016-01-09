package angrybirds.views;

import angrybirds.notifications.inputs.actions.GameInputAction;
import angrybirds.notifications.updates.actions.GameUpdateAction;
import angrybirds.notifications.updates.actions.UpdateAction;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

import java.util.SortedMap;

/**
 * TODO: Description
 *
 * @author Tititesouris
 */
public class GameView extends View {

    private SortedMap<Integer, LevelView> levels;

    private LevelView level;

    public GameView(int id, SortedMap<Integer, LevelView> levels) {
        super(id);
        this.levels = levels;
    }

    @Override
    public void init() {
        for (LevelView level : levels.values())
            level.init();
    }

    @Override
    public void input(Input input) {
        if (level == null) {
            if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
                LevelView levelSelected = levels.get(levels.firstKey());
                notifyObservers(new GameInputAction.EnterLevel(id, levelSelected.id));
            }
        } else
            level.input(input);
    }

    @Override
    public void display(Graphics graphics) {
        if (level == null) {
            graphics.drawString("Angry Birds. Click to start", 200, 200);
        }
        else
            level.display(graphics);
    }

    @Override
    public void onUpdate(UpdateAction updateAction) {
        if (updateAction instanceof GameUpdateAction) {
            if (updateAction instanceof GameUpdateAction.EnterLevel)
                enterLevel(((GameUpdateAction.EnterLevel) updateAction).getLevel());
        }
    }

    private void enterLevel(int levelId) {
        this.level = levels.get(levelId);
    }

}
