package angrybirds.views.objects.birds;

import angrybirds.models.Model;
import angrybirds.models.objects.birds.BirdModel;
import angrybirds.updates.actions.ObjectUpdateAction;
import angrybirds.utils.Constants;
import angrybirds.utils.Vector2d;
import angrybirds.updates.actions.BirdUpdateAction;
import angrybirds.updates.actions.UpdateAction;
import angrybirds.views.LevelView;
import angrybirds.views.objects.ObjectView;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO: Description
 *
 * @author Tititesouris
 */
public abstract class BirdView extends ObjectView {

    private LevelView level;

    private List<Vector2d> trail;

    public BirdView(LevelView level) {
        this.level = level;
    }

    @Override
    public void init(Model model) {
        super.init(model);
        BirdModel bird = (BirdModel) model;
        rotation = bird.getRotation();
        trail = new ArrayList<>();
    }

    @Override
    public void onUpdate(UpdateAction updateAction) {
        if (updateAction instanceof ObjectUpdateAction) {
            if (updateAction instanceof BirdUpdateAction.Move) {
                position = ((BirdUpdateAction.Move) updateAction).getPosition();
            }
            else if (updateAction instanceof BirdUpdateAction.Rotate) {
                rotation = ((ObjectUpdateAction.Rotate) updateAction).getRotation();
            }
            else if (updateAction instanceof BirdUpdateAction.Launch) {
                // jouer un son
                // animation
            }
            else if (updateAction instanceof BirdUpdateAction.Stop) {
                level.ready();
            }
        }
    }

    @Override
    public void display(Graphics graphics) {
        if (Constants.DEBUG) {
            graphics.setColor(Color.white);
            graphics.drawOval(position.x - size.x / 2, position.y - size.y / 2, size.x, size.y);
        }
    }

}
