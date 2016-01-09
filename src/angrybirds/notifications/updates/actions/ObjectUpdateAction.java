package angrybirds.notifications.updates.actions;

import angrybirds.utils.Vector2d;

/**
 * TODO: Description
 *
 * @author Tititesouris
 */
public abstract class ObjectUpdateAction implements UpdateAction {

    public static class MoveTo extends ObjectUpdateAction {

        private Vector2d position;

        public MoveTo(Vector2d position) {
            this.position = position;
        }

        public Vector2d getPosition() {
            return position;
        }

    }

    public static class AccelerateTo extends ObjectUpdateAction {

        private Vector2d velocity;

        public AccelerateTo(Vector2d velocity) {
            this.velocity = velocity;
        }

        public Vector2d getVelocity() {
            return velocity;
        }

    }

    public static class RotateTo extends ObjectUpdateAction {

        private float rotation;

        public RotateTo(float rotation) {
            this.rotation = rotation;
        }

        public float getRotation() {
            return rotation;
        }

    }

}
