package angrybirds.views;

import angrybirds.models.Model;
import angrybirds.models.objects.birds.BirdModel;
import angrybirds.utils.Vector2d;
import angrybirds.utils.updates.actions.BirdUpdateAction;
import angrybirds.utils.updates.actions.UpdateAction;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO: Description
 *
 * @author Tititesouris
 */
public abstract class BirdView extends View {

    protected Vector2d position;

    protected Vector2d size;

    protected float rotation;

    private List<Vector2d> trail;

    @Override
    public void init(Model model) {
        BirdModel bird = (BirdModel) model;
        this.position = bird.getPosition();
        this.size = bird.getSize();
        this.rotation = bird.getRotation();
        this.trail = new ArrayList<>();
    }

    @Override
    public void display() {
        for (Vector2d point : trail) {

        }
    }

    @Override
    public void onUpdate(UpdateAction updateAction) {
        if (updateAction instanceof BirdUpdateAction) {
            if (updateAction instanceof BirdUpdateAction.Move)
                position = ((BirdUpdateAction.Move) updateAction).getPosition();
        }
    }

}
