package angrybirds.inputs.actions;

/**
 * TODO: Description
 *
 * @author Quentin Brault
 */
public abstract class LevelInputAction implements InputAction {

    private int id;

    public LevelInputAction(int id) {
        this.id = id;
    }

    public static class Ready extends LevelInputAction {

        public Ready(int id) {
            super(id);
        }

    }

    public static class Pause extends LevelInputAction {

        public Pause(int id) {
            super(id);
        }

    }

    public static class Play extends LevelInputAction {

        public Play(int id) {
            super(id);
        }

    }

    public int getId() {
        return id;
    }

}
