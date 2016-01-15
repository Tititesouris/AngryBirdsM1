package angrybirds.notifications.updates.actions;

/**
 * Cette classe représente une action d'update envoyée par un obstacle.
 *
 * @author Quentin Brault
 * @since 2016/01/10
 */
public abstract class ObstacleUpdateAction extends ObjectUpdateAction {

    /**
     * Cette classe interne définie un update d'obstacle lorsqu'il se casse.
     */
    public static class Break extends ObstacleUpdateAction {
    }

}
