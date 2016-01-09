package angrybirds.views;

import angrybirds.utils.Vector2d;
import angrybirds.notifications.inputs.actions.SlingshotInputAction;
import angrybirds.notifications.updates.actions.SlingshotUpdateAction;
import angrybirds.notifications.updates.actions.UpdateAction;
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

    public SlingshotView(int id, Vector2d position, Vector2d size, Vector2d holderPosition) {
        super(id);
        this.position = position;
        this.size = size;
        this.holderPosition = holderPosition;
    }

    @Override
    public void init() {

    }

    @Override
    public void input(Input input) {
        if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
            Vector2d mousePosition = new Vector2d(input.getMouseX(), input.getMouseY());
            if (pulling || mousePosition.difference(position.sum(holderPosition)).hypotenuse() <= 50) {
                notifyObservers(new SlingshotInputAction.Pull(mousePosition.difference(position)));
            }
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
        if (updateAction instanceof SlingshotUpdateAction.Pull) {
            pull(((SlingshotUpdateAction.Pull) updateAction).getHolderPosition());
        } else if (updateAction instanceof SlingshotUpdateAction.Release) {
            release();
        }
    }

    private void pull(Vector2d holderPosition) {
        pulling = true;
        this.holderPosition = holderPosition;
    }

    private void release() {
        pulling = false;
        holderPosition = Vector2d.ZERO;
    }

}
