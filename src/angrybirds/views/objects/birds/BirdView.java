package angrybirds.views.objects.birds;

import angrybirds.notifications.updates.actions.ObjectUpdateAction;
import angrybirds.utils.Constants;
import angrybirds.utils.Vector2d;
import angrybirds.notifications.updates.actions.BirdUpdateAction;
import angrybirds.notifications.updates.actions.UpdateAction;
import angrybirds.views.objects.ObjectView;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO: Description
 *
 * @author Tititesouris
 */
public abstract class BirdView extends ObjectView {

    protected Color color;

    private List<Vector2d> trail;

    public BirdView(int id, Vector2d position, Vector2d size, float rotation) {
        super(id, position, size, rotation);
        this.trail = new ArrayList<>();
    }

    @Override
    public void input(Input input) {

    }

    @Override
    public void onUpdate(UpdateAction updateAction) {
        super.onUpdate(updateAction);
        if (updateAction instanceof BirdUpdateAction.Launch) {
            System.out.println("BIRD LAUNCHED");
            // jouer un son
            // animation
        } else if (updateAction instanceof BirdUpdateAction.Die) {
            System.out.println("BIRD DIED");
            // animation de mort
        }
    }

    @Override
    public void display(Graphics graphics) {
        if (Constants.DEBUG) {
            graphics.setColor(color);
            graphics.fillOval(position.x - size.x / 2, position.y - size.y / 2, size.x, size.y);
        }
    }

}
