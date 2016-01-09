package angrybirds.notifications.updates.actions;

/**
 * TODO: Description
 *
 * @author Tititesouris
 */
public abstract class LevelUpdateAction implements UpdateAction {

    public static class BirdDied extends LevelUpdateAction {

        private int birdId;

        public BirdDied(int birdId) {
            this.birdId = birdId;
        }

        public int getBirdId() {
            return birdId;
        }

    }

}
