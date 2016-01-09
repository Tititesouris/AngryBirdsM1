package angrybirds.updates.actions;

/**
 * TODO: Description
 *
 * @author Tititesouris
 */
public abstract class GameUpdateAction implements UpdateAction {

    public static class EnterLevel extends GameUpdateAction {

        private int id;

        public EnterLevel(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }

    }

}
