package angrybirds.notifications.updates.actions;

/**
 * TODO: Description
 *
 * @author Tititesouris
 */
public abstract class BirdUpdateAction extends ObjectUpdateAction {

    public static class Launch extends BirdUpdateAction {}

    public static class Hit extends BirdUpdateAction {}

    public static class Die extends BirdUpdateAction {}

}
