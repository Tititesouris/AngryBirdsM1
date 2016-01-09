package angrybirds.notifications.updates.actions;

/**
 * TODO: Description
 *
 * @author Tititesouris
 */
public abstract class GameUpdateAction implements UpdateAction {

    public static class EnterLevel extends GameUpdateAction {

        private int levelId;

        public EnterLevel(int levelId) {
            this.levelId = levelId;
        }

        public int getLevel() {
            return levelId;
        }

    }

}
