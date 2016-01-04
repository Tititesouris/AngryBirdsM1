package angrybirds.views;

import angrybirds.models.Model;
import angrybirds.models.SlingshotModel;
import angrybirds.utils.Vector2d;
import angrybirds.utils.inputs.actions.SlingshotInputAction;
import angrybirds.utils.updates.actions.SlingshotUpdateAction;
import angrybirds.utils.updates.actions.UpdateAction;
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

    @Override
    public void init(Model model) {
        SlingshotModel slingshot = (SlingshotModel) model;
        this.position = slingshot.getPosition();
        this.size = slingshot.getSize();
        this.holderPosition = slingshot.getHolderPosition();
    }

    @Override
    public void display() {
        getGraphics().drawRect(position.x, position.y, size.x, size.y);
        getGraphics().drawRect(holderPosition.x, holderPosition.y, size.x, 20);
        if (getInput().isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
            Vector2d cursorPosition = new Vector2d(getInput().getMouseX(), getInput().getMouseY());
            notifyObservers(new SlingshotInputAction.Pull(cursorPosition));
        }
    }

    @Override
    public void onUpdate(UpdateAction updateAction) {
        if (updateAction instanceof SlingshotUpdateAction) {
            if (updateAction instanceof SlingshotUpdateAction.Stretch) {
                holderPosition = ((SlingshotUpdateAction.Stretch) updateAction).getPosition();
            }
        }
    }

}
