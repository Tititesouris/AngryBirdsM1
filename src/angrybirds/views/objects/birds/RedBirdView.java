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
        color = Color.red;
    }

    @Override
    public void input(Input input) {
        super.input(input);
    }

    @Override
    public void display(Graphics graphics) {
        super.display(graphics);
    }

}
