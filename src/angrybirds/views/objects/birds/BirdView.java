package angrybirds.views.objects.birds;

import angrybirds.notifications.inputs.actions.BirdInputAction;
import angrybirds.notifications.updates.actions.ObjectUpdateAction;
import angrybirds.utils.Constants;
import angrybirds.utils.Vector2d;
import angrybirds.notifications.updates.actions.BirdUpdateAction;
import angrybirds.notifications.updates.actions.UpdateAction;
import angrybirds.views.objects.ObjectView;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Ellipse;
import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.geom.Shape;

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

    protected boolean flying;
    
    public BirdView(int id, Vector2d position, Vector2d size, float rotation) {
        super(id, position, size, rotation);
        this.trail = new ArrayList<>();
    }

    @Override
    public void input(Input input) {
        if (flying && input.isKeyDown(Input.KEY_SPACE)) {
    		notifyObservers(new BirdInputAction.UseAbility(id));
    	}
    }

    @Override
    public void onUpdate(UpdateAction updateAction) {
        super.onUpdate(updateAction);
        if (updateAction instanceof BirdUpdateAction.Ready) {
            ready();
        } else if (updateAction instanceof BirdUpdateAction.Launch) {
            launch();
        } else if (updateAction instanceof BirdUpdateAction.UseAbility) {
            useAbility();
        } else if (updateAction instanceof BirdUpdateAction.Die) {
            die();
        }
    }

    private void ready() {
    }

    private void launch() {
        System.out.println("BIRD LAUNCHED");
        flying = true;
    }

    private void useAbility() {
        System.out.println("ABILITY TRIGGERED");
    }

    private void die() {
        System.out.println("BIRD DIED");
    }

    @Override
    public void display(Graphics graphics) {
        if (Constants.DEBUG) {
            Shape bird = new Ellipse(position.x, position.y, size.x / 2, size.y / 2);
            Shape beak = new Ellipse(position.x, position.y, 10, 5);

            bird = getRotated(bird, -rotation, 0, 0);
            beak = getRotated(beak, -rotation, 0, 0);

            graphics.setColor(color);
            graphics.fill(bird);
            graphics.setColor(Color.black);
            graphics.fill(beak);
        }
    }

}
