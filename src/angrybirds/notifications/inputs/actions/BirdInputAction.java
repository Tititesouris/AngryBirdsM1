package angrybirds.notifications.inputs.actions;

/**
 * Cette classe représente une action d'input envoyée par un oiseau.
 *
 * @author Quentin Brault
 * @since 2016/01/10
 */
public abstract class BirdInputAction implements InputAction {

    /**
     * L'id du modèle de l'oiseau ayant envoyé l'input.
     */
    private int birdId;

    /**
     * Créé une action d'input d'oiseau.
     *
     * @param birdId Id du modèle de l'oiseau ayant envoyé l'input.
     */
    public BirdInputAction(int birdId) {
        this.birdId = birdId;
    }

    /**
     * Retourne l'id du modèle l'oiseau ayant envoyé l'input.
     *
     * @return Id du modèle l'oiseau ayant envoyé l'input.
     */
    public int getBirdId() {
        return birdId;
    }

    /**
     * Cette classe interne définie un input d'oiseau lorsqu'il utilise son pouvoir.
     */
    public static class UseAbility extends BirdInputAction {
        public UseAbility(int birdId) {
            super(birdId);
        }
    }

}
