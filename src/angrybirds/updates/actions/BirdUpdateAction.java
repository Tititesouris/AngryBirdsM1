package angrybirds.updates.actions;

import angrybirds.updates.actions.ObjectUpdateAction.Accelerate;
import angrybirds.utils.Vector2d;

/**
 * TODO: Description
 *
 * @author Tititesouris
 */
public abstract class BirdUpdateAction extends ObjectUpdateAction {

    public static class Launch extends BirdUpdateAction {}

    public static class Hit extends BirdUpdateAction {}

    public static class Die extends BirdUpdateAction {}

    public static class Stop extends BirdUpdateAction {
    }

}
