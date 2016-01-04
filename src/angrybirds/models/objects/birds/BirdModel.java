package angrybirds.models.objects.birds;

import angrybirds.models.Model;
import angrybirds.models.objects.ObjectModel;
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

    @Override
    public void init() {
        rotation = 0;
        spin = 0;
        gravity = false;
    }

}
