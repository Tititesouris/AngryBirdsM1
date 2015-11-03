package angrybirds.graphics;

import angrybirds.structures.Vector2d;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Created by Quentin Brault on 02/10/2015.
 */
/**
 * Cette classe permet d'afficher les objects vectoriels, donc le traçage des
 * courbes à chaque fois que son vecteur est modifié
 * @author Maxime Catteau
 *
 */
public class VectorObject extends GraphicalObject {

    protected Vector2d velocity, acceleration;

    public VectorObject(Vector2d position, Vector2d velocity, Vector2d acceleration) {
        super(position);
        this.velocity = velocity;
        this.acceleration = acceleration;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {

    }

    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException {
        velocity.add(acceleration.product(delta));
        position.add(velocity.product(delta));
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {

    }
}
