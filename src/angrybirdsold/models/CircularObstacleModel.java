package angrybirdsold.models;

import angrybirdsold.structures.Vector2d;

/**
 * Cette classe représente un obstacle circulaire.
 *
 * @author Quentin Brault
 */
public class CircularObstacleModel extends ObstacleModel {

    /**
     * Créé un nouvel obstacle
     *
     * @param position Position de départ de l'obstacle
     * @param size     Taille de l'obstacle
     * @param velocity Vélocité de l'obstacle
     * @param flip     Temps en millisecondes avant de faire demi-tour
     */
    public CircularObstacleModel(Vector2d position, Vector2d size, Vector2d velocity, int flip) {
        super(position, size, velocity, flip);
    }

    @Override
    public boolean touchesBird(BirdModel bird) {
        return position.diff(bird.position).getHypotenuse() <= size.x + bird.getSize().x;
    }

}
