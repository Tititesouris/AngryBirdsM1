package angrybirds.updates.actions;

import angrybirds.utils.Vector2d;

/**
 * TODO: Description
 *
 * @author Quentin Brault
 */
public abstract class SlingshotUpdateAction implements UpdateAction {

    public static class Pull extends SlingshotUpdateAction {

        private Vector2d holderPosition;

        public Pull(Vector2d holderPosition) {
            this.holderPosition = holderPosition;
        }

        public Vector2d getHolderPosition() {
            return holderPosition;
        }

    }

}
