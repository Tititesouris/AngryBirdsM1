package angrybirds.graphics;

import angrybirds.structures.Vector2d;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Cette classe représente un objet graphique vectoriel.
 *
 * @author Quentin Brault
 *
 */
public class VectorObject extends GraphicalObject {

    /**
     * Vecteurs vélocité et accélération
     */
    protected Vector2d velocity, acceleration;

    /**
     * Créé un nouvel objet vectoriel
     *
     * @param position      Position de départ de l'objet
     * @param velocity      Vélocité de départ de l'objet
     * @param acceleration  Accélération de départ de l'objet
     */
    public VectorObject(Vector2d position, Vector2d velocity, Vector2d acceleration) {
        super(position);
        this.velocity = velocity;
        this.acceleration = acceleration;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {

    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException {
        velocity = velocity.add(acceleration.product(delta));
        position = position.add(velocity.product(delta));
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {

    }

}
