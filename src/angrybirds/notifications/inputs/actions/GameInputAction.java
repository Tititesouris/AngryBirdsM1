package angrybirds.notifications.inputs.actions;

/**
 * Cette classe représente une action d'input envoyée par un jeu.
 *
 * @author Quentin Brault
 * @since 2016/01/10
 */
public abstract class GameInputAction implements InputAction {

    /**
     * L'id du modèle du jeu ayant envoyé l'input.
     */
    private int gameId;

    /**
     * Créé une action d'input de jeu.
     *
     * @param gameId Id du modèle du jeu ayant envoyé l'input.
     */
    public GameInputAction(int gameId) {
        this.gameId = gameId;
    }

    /**
     * Retourne l'id du modèle du jeu ayant envoyé l'input.
     *
     * @return Id du modèle du jeu ayant envoyé l'input.
     */
    public int getGameId() {
        return gameId;
    }

    /**
     * Cette classe interne définie un input de jeu lorsqu'il entre dans un niveau.
     */
    public static class EnterLevel extends GameInputAction {

        /**
         * L'id du modèle du niveau entré.
         */
        private int levelId;

        /**
         * Créé une action d'input de jeu d'entrée de niveau.
         *
         * @param gameId  Id du modèle du jeu ayant envoyé l'input.
         * @param levelId Id du modèle du niveau entré.
         */
        public EnterLevel(int gameId, int levelId) {
            super(gameId);
            this.levelId = levelId;
        }

        /**
         * Retourne l'id du modèle du niveau entré.
         *
         * @return Id du modèle du niveau entré.
         */
        public int getLevelId() {
            return levelId;
        }

    }

    /**
     * Cette classe interne définie un input de jeu lorsqu'il change entre le mode de jeu debug et non debug.
     */
    public static class SwitchDebug extends GameInputAction {

        /**
         * Créé une action d'input de jeu.
         *
         * @param gameId Id du modèle du jeu ayant envoyé l'input.
         */
        public SwitchDebug(int gameId) {
            super(gameId);
        }

    }

}
