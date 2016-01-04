package angrybirds.utils.updates.actions;

import angrybirds.utils.Vector2d;

/**
 * TODO: Description
 *
 * @author Tititesouris
 */
public abstract class BirdUpdateAction implements UpdateAction {

    public static class Move extends BirdUpdateAction {

        private Vector2d position;

        public Move(Vector2d position) {
            this.position = position;
        }

        public Vector2d getPosition() {
            return position;
        }

    }

    public static class Rotate extends BirdUpdateAction {

        private float angle;

        public Rotate(float angle) {
            this.angle = angle;
        }

        public float getAngle() {
            return angle;
        }

    }

    public static class Launch extends BirdUpdateAction {}

    public static class Hit extends BirdUpdateAction {}

    public static class Die extends BirdUpdateAction {}

}
