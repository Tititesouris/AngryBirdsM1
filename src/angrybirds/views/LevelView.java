package angrybirds.views;

import angrybirds.models.Model;
import angrybirds.utils.inputs.actions.LevelInputAction;
import angrybirds.utils.updates.actions.UpdateAction;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.util.pathfinding.navmesh.Space;

/**
 * TODO: Description
 *
 * @author Tititesouris
 */
public class LevelView extends View {

    @Override
    public void init(Model model) {

    }

    @Override
    public void input(Input input) {
        if (input.isKeyDown(Input.KEY_SPACE)) {
            notifyObservers(new LevelInputAction.Start());
        }
    }

    @Override
    public void display(Graphics graphics) {

    }

    @Override
    public void onUpdate(UpdateAction updateAction) {

    }

}
