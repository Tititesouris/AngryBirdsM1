package angrybirds.notifications.updates.actions;

/**
 * Cette classe représente une action d'update envoyée par un oiseau.
 *
 * @author Quentin Brault
 * @since 2016/01/10
 */
public abstract class BirdUpdateAction extends ObjectUpdateAction {

    /**
     * Cette classe interne définie un update d'oiseau lorsqu'il est lancé.
     */
    public static class Launch extends BirdUpdateAction {}

    /**
     * Cette classe interne définie un update d'oiseau lorsqu'il utilise son pouvoir.
     */
    public static class UseAbility extends BirdUpdateAction {}

    /**
     * Cette classe interne définie un update d'oiseau lorsqu'il se heurte.
     */
    public static class Hit extends BirdUpdateAction {}

    /**
     * Cette classe interne définie un update d'oiseau lorsqu'il meurt.
     */
    public static class Die extends BirdUpdateAction {}

    /**
     * Cette classe interne définie un update d'oiseau lorsqu'il est prêt à être lancé.
     */
    public static class Ready extends BirdUpdateAction {}

}
