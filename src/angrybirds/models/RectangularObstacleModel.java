package angrybirds.models;

import angrybirds.structures.Vector2d;

/**
 * Cette classe représente un obstacle rectangulaire.
 *
 * @author Tititesouris
 */
public class RectangularObstacleModel extends ObstacleModel {

    /**
     * Créé un nouvel obstacle
     *
     * @param position Position de départ de l'obstacle
     * @param size     Taille de l'obstacle
     * @param velocity Vélocité de l'obstacle
     * @param flip     Temps en millisecondes avant de faire demi-tour
     */
    public RectangularObstacleModel(Vector2d position, Vector2d size, Vector2d velocity, int flip) {
        super(position, size, velocity, flip);
    }

    @Override
    public boolean touchesBird(BirdModel bird) {
        return position.x <= bird.position.x + bird.size.x
                && position.y <= bird.position.y + bird.size.y
                && position.x + size.x >= bird.position.x
                && position.y + size.y >= bird.position.y;
    }

}
