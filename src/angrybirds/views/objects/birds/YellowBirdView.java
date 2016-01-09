package angrybirds.views.objects.birds;

import angrybirds.utils.Constants;
import angrybirds.views.LevelView;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.geom.Triangulator;

/**
 * TODO: Description
 *
 * @author Tititesouris
 */
public class YellowBirdView extends BirdView {

    public YellowBirdView(LevelView level) {
        super(level);
    }

    @Override
    public void input(Input input) {

    }

    @Override
    public void display(Graphics graphics) {
        super.display(graphics);
        if (Constants.DEBUG) {
            graphics.setColor(Color.yellow);
            Polygon triangle = new Polygon(new float[] {
                    position.x - size.x / 2, position.y + size.y / 2,
                    position.x, position.y - size.y / 2,
                    position.x + size.x / 2, position.y + size.y /2
            });
            graphics.fill(triangle);
        }
    }

}
