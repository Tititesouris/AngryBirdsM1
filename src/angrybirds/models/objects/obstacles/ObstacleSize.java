package angrybirds.models.objects.obstacles;

import angrybirds.utils.Vector2d;

/**
 * Cette énumération représente les différentes tailles des obstacles.
 *
 * @author Quentin Brault
 * @since  2013/10/01
 */
public enum ObstacleSize {

    /**
     * Petite taille
     */
    SMALL(new Vector2d(50, 50)),

    /**
     * Moyenne taille
     */
    MEDIUM(new Vector2d(150, 50)),

    /**
     * Grande taille.
     */
    LARGE(new Vector2d(250, 150));

    /**
     * Taille de l'obstacle.
     */
    private Vector2d size;

    /**
     * Créé une nouvelle taille d'obstacle.
     *
     * @param size Taille de l'obstacle.
     */
    ObstacleSize(Vector2d size) {
        this.size = size;
    }

    /**
     * Retourne la taille de l'obstacle.
     *
     * @return  Taille de l'obstacle.
     */
    public Vector2d getSize() {
        return size;
    }

}
