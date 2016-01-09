package angrybirds.inputs.actions;

import angrybirds.utils.Vector2d;

/**
 * TODO: Description
 *
 * @author Quentin Brault
 */
public abstract class SlingshotInputAction implements InputAction {

    public static class Pull extends SlingshotInputAction {

        private Vector2d holderPosition;

        public Pull(Vector2d holderPosition) {
            this.holderPosition = holderPosition;
        }

        public Vector2d getHolderPosition() {
            return holderPosition;
        }

    }

    public static class Release extends SlingshotInputAction {

    }

}
