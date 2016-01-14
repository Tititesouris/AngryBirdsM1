package angrybirds.notifications.updates.actions;

import angrybirds.utils.Vector2d;

/**
 * Cette classe représente une action d'update envoyée par un lance-oiseau.
 *
 * @author Quentin Brault
 * @since 2016/01/10
 */
public abstract class SlingshotUpdateAction implements UpdateAction {

    /**
     * Cette classe interne définie l'action d'update d'étirement du lance-oiseau.
     */
    public static class Pull extends SlingshotUpdateAction {

        /**
         * Position du holder par rapport à sa position au repos en m.
         */
        private Vector2d holderPosition;

        /**
         * Créé une action d'update d'étirement de lance-oiseau.
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
     * Cette classe interne définie l'action d'update de relâchement du lance-oiseau.
     */
    public static class Release extends SlingshotUpdateAction {}

}
