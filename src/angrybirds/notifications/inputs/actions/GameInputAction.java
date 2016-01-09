package angrybirds.notifications.inputs.actions;

/**
 * TODO: Description
 *
 * @author Tititesouris
 */
public abstract class GameInputAction implements InputAction {

    private int gameId;

    public GameInputAction(int gameId) {
        this.gameId = gameId;
    }

    public int getGameId() {
        return gameId;
    }

    public static class EnterLevel extends GameInputAction {

        private int levelId;

        public EnterLevel(int gameId, int levelId) {
            super(gameId);
            this.levelId = levelId;
        }

        public int getLevelId() {
            return levelId;
        }

    }

}
