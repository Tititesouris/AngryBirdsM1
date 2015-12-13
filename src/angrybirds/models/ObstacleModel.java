package angrybirds.models;

import angrybirds.structures.Constants;
import angrybirds.structures.Vector2d;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 * TODO: Description
 *
 * @author Tititesouris
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
     * Créé un nouvel objet vectoriel
     *
     * @param position     Position de départ de l'objet
     * @param size
     * @param velocity     Vélocité de départ de l'objet
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

    public boolean isOutOfBounds() {
        return position.x < 0
                || position.y < 0
                || position.x + size.x > Constants.SCREEN_WIDTH
                || position.y + size.y > Constants.SCREEN_HEIGHT - Constants.GROUND_HEIGHT;
    }

    public abstract boolean touchesBird(BirdModel bird);

    public boolean isHit() {
        return hit;
    }

    public void setHit(boolean hit) {
        this.hit = hit;
    }

}
