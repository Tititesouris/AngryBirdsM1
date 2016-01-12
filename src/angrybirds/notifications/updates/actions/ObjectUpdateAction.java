package angrybirds.notifications.updates.actions;

import angrybirds.utils.Vector2d;

/**
 * Cette classe représente une action d'update envoyée par un objet.
 *
 * @author Quentin Brault
 * @since 2016/01/10
 */
public abstract class ObjectUpdateAction implements UpdateAction {

    /**
     * Cette classe interne définie un update d'objet lorsqu'il se déplace.
     */
    public static class MoveTo extends ObjectUpdateAction {

        /**
         * Position du centre de l'objet en m.
         */
        private Vector2d position;

        /**
         * Créé une action d'update de déplacement d'objet.
         *
         * @param position Position du centre de l'objet en m.
         */
        public MoveTo(Vector2d position) {
            this.position = position;
        }

        /**
         * Retourne la position du centre de l'objet en m.
         *
         * @return Position du centre de l'objet en m.
         */
        public Vector2d getPosition() {
            return position;
        }

    }

    /**
     * Cette classe interne définie un update d'objet lorsqu'il accélère.
     */
    public static class AccelerateTo extends ObjectUpdateAction {

        /**
         * Vélocité de l'objet en m/s.
         */
        private Vector2d velocity;

        /**
         * Créé une action d'update d'accélération d'objet
         * @param velocity Vélocité de l'objet en m/s.
         */
        public AccelerateTo(Vector2d velocity) {
            this.velocity = velocity;
        }

        /**
         * Retourne la vélocité de l'objet en m/s.
         *
         * @return Vélocité de l'objet en m/s.
         */
        public Vector2d getVelocity() {
            return velocity;
        }

    }

    /**
     * Cette classe interne définie un update d'objet lorsqu'il tourne.
     */
    public static class RotateTo extends ObjectUpdateAction {

        /**
         * Angle de rotation de l'objet dans le cercle trigonométrique.
         */
        private float rotation;

        /**
         * Créé une action d'update de rotation d'objet.
         *
         * @param rotation Angle de rotation de l'objet dans le cercle trigonométrique.
         */
        public RotateTo(float rotation) {
            this.rotation = rotation;
        }

        /**
         * Retourne l'angle de rotation de l'objet dans le cercle trigonométrique.
         *
         * @return Angle de rotation de l'objet dans le cercle trigonométrique.
         */
        public float getRotation() {
            return rotation;
        }

    }

}
