package angrybirds.utils.inputs.actions;

import angrybirds.utils.Vector2d;

/**
 * TODO: Description
 *
 * @author Quentin Brault
 */
public abstract class SlingshotInputAction implements InputAction {

    public static class Pull extends SlingshotInputAction {

        private Vector2d position;

        public Pull(Vector2d position) {
            this.position = position;
        }

        public Vector2d getPosition() {
            return position;
        }

    }

    public static class Release extends SlingshotInputAction {

    }

}
