package angrybirds2.views.slick2d;

import angrybirds2.datamodels.SlingshotDataModel;
import angrybirds2.utils.Vector2d;
import angrybirds2.utils.inputs.SlingshotAction;
import angrybirds2.views.abstracts.SlingshotView;
import org.newdawn.slick.Color;
import org.newdawn.slick.Input;

/**
 * TODO: Description
 *
 * @author Quentin Brault
 */
public class Slick2dSlingshotView extends SlingshotView implements Slick2dView {

    public Slick2dSlingshotView(SlingshotDataModel dataModel) {
        super(dataModel);
    }

    @Override
    public void display() {
        SlingshotDataModel me = getDataModel();
        if (container.getInput().isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
            notifyObservers(new SlingshotAction.Pull(new Vector2d(container.getInput().getMouseX(), container.getInput().getMouseY())));
        }

        graphics.setColor(new Color(146,98,57));
        graphics.drawRect(me.getPosition().x, me.getPosition().y, me.getSize().x, me
        .getSize().y);
        graphics.drawRect(me.getPosition().x + me.getHolderPosition().x, me.getPosition().y + me.getHolderPosition().y, 50, 10);
        //TODO: hmhmhmm, I cna access setters from view, not good.
    }

}
