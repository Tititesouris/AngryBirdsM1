package angrybirds.models.objects.obstacles;

/**
 * Cette énumération représente les différents matériaux des obstacles.
 *
 * @author Quentin Brault
 * @since  2013/10/01
 */
public enum ObstacleMaterial {

    /**
     * Verre, fragile.
     */
    GLASS(0.25f),

    /**
     * Bois, normal.
     */
    WOOD(0.5f),

    /**
     * Pierre, robuste.
     */
    STONE(1);

    /**
     * Densité (ou masse surfacique) du matériau.
     */
    private float density;

    /**
     * Créé un nouveau matériau.
     *
     * @param density Densité (ou masse surfacique) du matériau.
     */
    ObstacleMaterial(float density) {
        this.density = density;
    }

    /**
     * Retourne la densité (ou masse surfacique) du matériau.
     *
     * @return Densité (ou masse surfacique) du matériau.
     */
    public float getDensity() {
        return density;
    }

}
