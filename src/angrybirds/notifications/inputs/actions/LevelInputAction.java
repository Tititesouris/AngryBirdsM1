package angrybirds.notifications.inputs.actions;

/**
 * Cette classe représente une action d'input envoyée par un niveau.
 *
 * @author Quentin Brault
 * @since 2016/01/10
 */
public abstract class LevelInputAction implements InputAction {

    /**
     * L'id du modèle du niveau ayant envoyé l'input.
     */
    private int levelId;

    /**
     * Créé une action d'input de niveau.
     *
     * @param levelId Id du modèle du niveau ayant envoyé l'input.
     */
    public LevelInputAction(int levelId) {
        this.levelId = levelId;
    }

    /**
     * Retourne l'id du modèle du niveau ayant envoyé l'input.
     *
     * @return Id du modèle du niveau ayant envoyé l'input.
     */
    public int getId() {
        return levelId;
    }

    /**
     * Cette classe interne définie un input de niveau lorsqu'il prépare à tirer.
     */
    public static class Ready extends LevelInputAction {

        /**
         * Créé une action d'input de préparation de niveau.
         *
         * @param levelId Id du niveau ayant envoyé l'input.
         */
        public Ready(int levelId) {
            super(levelId);
        }

    }

}
