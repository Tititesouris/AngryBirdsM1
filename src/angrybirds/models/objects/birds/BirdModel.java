package angrybirds.models.objects.birds;

import angrybirds.models.SlingshotModel;
import angrybirds.models.objects.ObjectModel;
import angrybirds.updates.actions.BirdUpdateAction;
import angrybirds.utils.Vector2d;

/**
 * TODO: Description
 *
 * @author Tititesouris
 */
public abstract class BirdModel extends ObjectModel {

    public BirdModel(Vector2d position, Vector2d velocity, Vector2d acceleration, Vector2d size, float density) {
        super(position, velocity, acceleration, size, density, 0, 0, false);
    }

    public void ready(SlingshotModel slingshot) {
        setPosition(slingshot.getHolderPosition());
        setRotation(0);
    }

    public void launch(Vector2d velocity) {
        setGravity(true);
        setVelocity(velocity);
        notifyObservers(new BirdUpdateAction.Launch());
    }

    public void checkStop() {
        // If bird has stopped
        //notifyObservers(new BirdUpdateAction.Stop());
    }

}
