package angrybirds.models;

import angrybirds.structures.Vector2d;

/**
 * TODO: Description
 *
 * @author Tititesouris
 */
public class RectangularObstacleModel extends ObstacleModel {

    /**
     * Créé un nouvel objet vectoriel
     *
     * @param position Position de départ de l'objet
     * @param size
     * @param velocity Vélocité de départ de l'objet
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
