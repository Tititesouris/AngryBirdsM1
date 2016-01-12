package angrybirds.views.objects;

import angrybirds.notifications.updates.actions.UpdateAction;
import angrybirds.utils.Constants;
import angrybirds.utils.Vector2d;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

/**
 * TODO: Description
 *
 * @author Tititesouris
 */
public class PigView extends ObjectView {

	
    public PigView(int id, Vector2d position, Vector2d size, float rotation) {
        super(id, position, size, rotation);
    }

    @Override
    public void init() {

    }

    @Override
    public void input(Input input) {

    }

    @Override
    public void display(Graphics graphics) {
    	if(Constants.DEBUG){
    		graphics.setColor(Color.green);
    		graphics.fillOval(position.x - size.x / 2, position.y - size.y / 2, size.x, size.y);
    	}
    }

    @Override
    public void onUpdate(UpdateAction updateAction) {
        super.onUpdate(updateAction);
    }

}
