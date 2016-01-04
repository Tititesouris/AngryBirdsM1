package angrybirds2.utils.inputs;

import angrybirds2.utils.Vector2d;

/**
 * TODO: Description
 *
 * @author Quentin Brault
 */
public class SlingshotAction extends InputAction {

    public static class Pull extends SlingshotAction {

        private Vector2d holderPosition;

        public Pull(Vector2d holderPosition) {
            this.holderPosition = holderPosition;
        }

        public Vector2d getHolderPosition() {
            return holderPosition;
        }

    }

    public static class Release extends SlingshotAction {

    }

}
