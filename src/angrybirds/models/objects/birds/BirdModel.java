package angrybirds.models.objects.birds;

import angrybirds.models.LevelModel;
import angrybirds.models.SlingshotModel;
import angrybirds.models.objects.ObjectModel;
import angrybirds.notifications.updates.actions.BirdUpdateAction;
import angrybirds.utils.Vector2d;

/**
 * TODO: Description
 *
 * @author Tititesouris
 */
public abstract class BirdModel extends ObjectModel {

    private LevelModel level;

    private long dies;

    private boolean dying;

    public BirdModel(LevelModel level, Vector2d position, Vector2d velocity, Vector2d acceleration, Vector2d size, float density) {
        super(position, velocity, acceleration, size, density, 0, 0, false);
        this.level = level;
    }

    @Override
    public void update(int delta) {
        super.update(delta);
        if (dying && dies < System.currentTimeMillis()) {
            dying = false;
            notifyObservers(new BirdUpdateAction.Die());
        }
    }

    public void launch(Vector2d velocity) {
        setGravity(true);
        setVelocity(velocity);
        dying = true;
        dies = System.currentTimeMillis() + 5000;
        notifyObservers(new BirdUpdateAction.Launch());
    }

}
