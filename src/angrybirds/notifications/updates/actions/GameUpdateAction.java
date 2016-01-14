package angrybirds.notifications.updates.actions;

/**
 * Cette classe représente une action d'update envoyée par un jeu.
 *
 * @author Quentin Brault
 * @since 2016/01/10
 */
public abstract class GameUpdateAction implements UpdateAction {

    /**
     * Cette classe interne définie un update de jeu lorsqu'il entre dans un niveau.
     */
    public static class EnterLevel extends GameUpdateAction {

        /**
         * Id du modèle du niveau entré.
         */
        private int levelId;

        /**
         * Créé une action d'update de jeu d'entrée de niveau.
         *
         * @param levelId Id du modèle du niveau entré.
         */
        public EnterLevel(int levelId) {
            this.levelId = levelId;
        }

        /**
         * Retourne l'id du modèle du niveau entré.
         *
         * @return Id du modèle du niveau entré.
         */
        public int getLevel() {
            return levelId;
        }

    }

}
