package angrybirds.notifications.inputs.actions;

import angrybirds.utils.Vector2d;

/**
 * Cette classe représente une action d'input envoyée par un lance-oiseau.
 *
 * @author Quentin Brault
 * @since 2016/01/10
 */
public abstract class SlingshotInputAction implements InputAction {

    /**
     * Cette classe interne définie l'action d'input d'étirement du lance-oiseau.
     */
    public static class Pull extends SlingshotInputAction {

        /**
         * Position du holder par rapport à sa position au repos en m.
         */
        private Vector2d holderPosition;

        /**
         * Créé une action d'input d'étirement de lance-oiseau.
         *
         * @param holderPosition Position du holder par rapport à sa position au repos en m.
         */
        public Pull(Vector2d holderPosition) {
            this.holderPosition = holderPosition;
        }

        /**
         * Retourne la position en m du holder par rapport à sa position au repos.
         *
         * @return Position en m du holder par rapport à sa position au repos.
         */
        public Vector2d getHolderPosition() {
            return holderPosition;
        }

    }

    /**
     * Cette classe interne définie l'action d'input de relâchement du lance-oiseau.
     */
    public static class Release extends SlingshotInputAction {}

}
