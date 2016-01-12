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

    private Vector2d holderPositionOffset = new Vector2d(0, -50);

    private boolean onSlingshot;

    protected Color color;

    private List<Vector2d> trail;

    public BirdView(int id, Vector2d position, Vector2d size, float rotation) {
        super(id, position, size, rotation);
        this.trail = new ArrayList<>();
    }

    @Override
    public void input(Input input) {
        // Si l'oiseau vol et on appuis sur espace, notifie observers avec un useAbility;
        // il faut donc un champ dans la vue pour savoir si l'oiseau vole
        // Aussi implémenter une méthode useAbility() dans cette vue qui est appelée par le onUpdate de cette vue lorsqu'on recoit un BirdUpdateAction.UseAbility()
        // Dans cette méthode faire quelquechose pour que l'on remarque visuellement que l'oiseau a utilisé son abilité.
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
        else if (updateAction instanceof BirdUpdateAction.Ready) {
            ready();
        }
    }

    private void ready() {
        onSlingshot = true;
    }

    @Override
    public void display(Graphics graphics) {
        if (Constants.DEBUG) {
            Shape bird;
            Shape beak;
            if (onSlingshot) {
                bird = new Ellipse(position.x + holderPositionOffset.x, position.y + holderPositionOffset.y, size.x / 2, size.y / 2);
                beak = new Ellipse(position.x + holderPositionOffset.x, position.y + holderPositionOffset.y, 10, 5);
            }
            else {
                bird = new Ellipse(position.x, position.y, size.x / 2, size.y / 2);
                beak = new Ellipse(position.x, position.y, 10, 5);
            }
            bird = getRotated(bird, -rotation, 0, 0);
            beak = getRotated(beak, -rotation, 0, 0);

            graphics.setColor(color);
            graphics.fill(bird);
            graphics.setColor(Color.black);
            graphics.fill(beak);
        }
    }

}
