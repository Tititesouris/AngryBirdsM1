package angrybirds.notifications.inputs.actions;

/**
 * TODO: Description
 *
 * @author Tititesouris
 */
public abstract class BirdInputAction implements InputAction {

    private int birdId;

    public BirdInputAction(int birdId) {
        this.birdId = birdId;
    }

    public int getBirdId() {
        return birdId;
    }

    public static class UseAbility extends BirdInputAction {
        public UseAbility(int birdId) {
            super(birdId);
        }
    }

}
