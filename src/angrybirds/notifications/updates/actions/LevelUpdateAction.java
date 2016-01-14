package angrybirds.notifications.updates.actions;

/**
 * Cette classe représente une action d'update envoyée par un niveau.
 *
 * @author Quentin Brault
 * @since 2016/01/10
 */
public abstract class LevelUpdateAction implements UpdateAction {

    /**
     * Cette classe interne définie un update de niveau lorsqu'un oiseau meurt.
     */
    public static class BirdDied extends LevelUpdateAction {

        /**
         * Id du modèle de l'oiseau qui est mort.
         */
        private int birdId;

        /**
         * Créé une action d'update de niveau d'oiseau mort.
         *
         * @param birdId Id du modèle de l'oiseau qui est mort.
         */
        public BirdDied(int birdId) {
            this.birdId = birdId;
        }

        /**
         * Retourne l'id du modèle de l'oiseau qui est mort.
         *
         * @return Id du modèle de l'oiseau qui est mort.
         */
        public int getBirdId() {
            return birdId;
        }

    }

    /**
     * Cette classe interne définie un update de niveau lorsqu'il est prêt à tirer.
     */
    public static class Ready extends LevelUpdateAction {
    }

    /**
     * Cette classe interne définie un update de niveau lorsqu'il est fini.
     */
    public static class End extends LevelUpdateAction {
    }

}
