package angrybirds.inputs.actions;

/**
 * TODO: Description
 *
 * @author Tititesouris
 */
public abstract class GameInputAction implements InputAction {

    public static class EnterLevel extends GameInputAction {

        private int id;

        public EnterLevel(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }

    }

}
