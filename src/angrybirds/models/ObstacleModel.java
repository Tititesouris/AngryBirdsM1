package angrybirds.models;

import angrybirds.structures.Constants;
import angrybirds.structures.Vector2d;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Cette classe représente un obstacle.
 *
 * @author Quentin Brault
 * @author Florent Marcaille
 */
public abstract class ObstacleModel extends VectorObjectModel {

    /**
     * True si l'obstacle a été touché
     */
    private boolean hit;

    /**
     * Temps en millisecondes entre chaque demi tour
     */
    private int flip;

    /**
     * Temps en millisecondes avant de faire demi-tour
     */
    private int tempFlip;

    /**
     * Créé un nouvel obstacle
     *
     * @param position  Position de départ de l'obstacle
     * @param size      Taille de l'obstacle
     * @param velocity  Vélocité de l'obstacle
     * @param flip      Temps en millisecondes avant de faire demi-tour
     */
    public ObstacleModel(Vector2d position, Vector2d size, Vector2d velocity, int flip) {
        super(position, size, velocity, new Vector2d(0, 0));
        this.flip = flip;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        hit = false;
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException {
        super.update(gameContainer, stateBasedGame, delta);
        if (isOutOfBounds() || tempFlip < 0) {
            tempFlip = flip;
            velocity = velocity.product(-1);
        }
        else {
            tempFlip -= delta;
        }
    }

    /**
     * Retourne true si l'obstacle sort de l'écran.
     * @return  True si l'obstacle sort de l'écran.
     */
    public boolean isOutOfBounds() {
        return position.x < 0
                || position.y < 0
                || position.x + size.x > Constants.SCREEN_WIDTH
                || position.y + size.y > Constants.SCREEN_HEIGHT - Constants.GROUND_HEIGHT;
    }

    /**
     * Retourne true si l'obstacle touche l'oiseau.
     *
     * @param bird  Oiseau à vérifier
     * @return  True si l'obstacle touche l'oiseau.
     */
    public abstract boolean touchesBird(BirdModel bird);

    /**
     * Retourne true si l'obstacle a été touché par l'oiseau
     *
     * @return  True si l'obstacle a été touche par l'oiseau.
     */
    public boolean isHit() {
        return hit;
    }

    /**
     * Indique si l'obstacle a été touché par l'oiseau.
     * @param hit   True si l'obstacle a été touché par l'oiseau. False sinon.
     */
    public void setHit(boolean hit) {
        this.hit = hit;
    }
}
