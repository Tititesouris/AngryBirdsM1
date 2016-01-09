package angrybirds.updates.actions;

import angrybirds.utils.Vector2d;

/**
 * TODO: Description
 *
 * @author Tititesouris
 */
public abstract class ObjectUpdateAction implements UpdateAction {

    public static class Move extends ObjectUpdateAction {

        private Vector2d position;

        public Move(Vector2d position) {
            this.position = position;
        }

        public Vector2d getPosition() {
            return position;
        }

    }

    public static class Accelerate extends ObjectUpdateAction {

        private Vector2d velocity;

        public Accelerate(Vector2d velocity) {
            this.velocity = velocity;
        }

        public Vector2d getVelocity() {
            return velocity;
        }

    }

    public static class Jerk extends ObjectUpdateAction {

        private Vector2d acceleration;

        public Jerk(Vector2d acceleration) {
            this.acceleration = acceleration;
        }

        public Vector2d getAcceleration() {
            return acceleration;
        }

    }

    public static class Rotate extends ObjectUpdateAction {

        private float rotation;

        public Rotate(float rotation) {
            this.rotation = rotation;
        }

        public float getRotation() {
            return rotation;
        }

    }

    public static class Surge extends ObjectUpdateAction {

        private float angularSpeed;

        public Surge(float angularSpeed) {
            this.angularSpeed = angularSpeed;
        }

        public float getAngularSpeed() {
            return angularSpeed;
        }

    }

}
