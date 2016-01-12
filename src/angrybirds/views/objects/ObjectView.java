package angrybirds.views.objects;

import angrybirds.notifications.updates.actions.ObjectUpdateAction;
import angrybirds.notifications.updates.actions.UpdateAction;
import angrybirds.utils.Vector2d;
import angrybirds.views.View;

/**
 * TODO: Description
 *
 * @author Tititesouris
 */
public abstract class ObjectView extends View {

    protected Vector2d position;

    protected Vector2d size;

    protected float rotation;

    public ObjectView(int id, Vector2d position, Vector2d size, float rotation) {
        super(id);
        this.position = position;
        this.size = size;
        this.rotation = rotation;
    }

    @Override
    public void onUpdate(UpdateAction updateAction) {
        if (updateAction instanceof ObjectUpdateAction.MoveTo) {
            moveTo(((ObjectUpdateAction.MoveTo) updateAction).getPosition());
        }
        else if (updateAction instanceof ObjectUpdateAction.RotateTo) {
            rotateTo(((ObjectUpdateAction.RotateTo) updateAction).getRotation());
        }
    }

    protected void moveTo(Vector2d position) {
        this.position = position;
    }

    protected void rotateTo(float rotation) {
        this.rotation = rotation;
    }

}
