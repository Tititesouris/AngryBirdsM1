package angrybirds.views.objects.birds;

import angrybirds.utils.Constants;
import angrybirds.utils.Vector2d;
import angrybirds.views.LevelView;
import angrybirds.views.objects.birds.BirdView;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

/**
 * TODO: Description
 *
 * @author Tititesouris
 */
public class RedBirdView extends BirdView {

    public RedBirdView(int id, Vector2d position, Vector2d size, float rotation) {
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
        if (Constants.DEBUG) {
            graphics.setColor(Color.red);
            graphics.fillOval(position.x - size.x / 2, position.y - size.y / 2, size.x / 2, size.y / 2);
        }
    }

}
