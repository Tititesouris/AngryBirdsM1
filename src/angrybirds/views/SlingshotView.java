package angrybirds.views;

import angrybirds.models.LevelModel;
import angrybirds.models.Model;
import angrybirds.models.SlingshotModel;
import angrybirds.utils.Vector2d;
import angrybirds.inputs.actions.SlingshotInputAction;
import angrybirds.updates.actions.SlingshotUpdateAction;
import angrybirds.updates.actions.UpdateAction;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

/**
 * TODO: Description
 *
 * @author Quentin Brault
 */
public class SlingshotView extends View {

    private Vector2d position;

    private Vector2d size;

    private Vector2d holderPosition;

    private boolean pulling;

    @Override
    public void init(Model model) {
        SlingshotModel slingshot = (SlingshotModel) model;
        this.position = slingshot.getPosition();
        this.size = slingshot.getSize();
        this.holderPosition = slingshot.getHolderPosition();
        this.pulling = false;
    }

    @Override
    public void input(Input input) {
        if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
            notifyObservers(new SlingshotInputAction.Pull(position.difference(new Vector2d(input.getMouseX(), input.getMouseY()))));
        }
        else if (pulling) {
            notifyObservers(new SlingshotInputAction.Release());
        }
    }

    @Override
    public void display(Graphics graphics) {
        graphics.drawRect(position.x - size.x / 2, position.y - size.y / 2, size.x, size.y);
        graphics.drawRect(position.x + holderPosition.x - size.x / 4, position.y + holderPosition.y - 10, size.x / 2, 20);
    }

    @Override
    public void onUpdate(UpdateAction updateAction) {
        if (updateAction instanceof SlingshotUpdateAction) {
            if (updateAction instanceof SlingshotUpdateAction.Pull) {
                pull(((SlingshotUpdateAction.Pull) updateAction).getHolderPosition());
            }
        }
    }

    private void pull(Vector2d holderPosition) {
        pulling = true;
        this.holderPosition = holderPosition;
    }

    private void release() {
        if (pulling) {
            pulling = false;
            notifyObservers(new SlingshotInputAction.Release());
        }
    }

}
