package angrybirds.notifications.inputs.actions;

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

    public int getId() {
        return id;
    }

}
