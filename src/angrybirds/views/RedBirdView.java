package angrybirds.views;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

/**
 * TODO: Description
 *
 * @author Tititesouris
 */
public class RedBirdView extends BirdView {

    @Override
    public void input(Input input) {

    }

    @Override
    public void display(Graphics graphics) {
        graphics.fillOval(position.x, position.y, size.x, size.y);
    }

}
