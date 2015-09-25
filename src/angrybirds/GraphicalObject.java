package angrybirds;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Created by Quentin Brault on 25/09/2015.
 */
public abstract class GraphicalObject {

    protected Vector2d position, velocity, acceleration;

    public GraphicalObject(Vector2d position, Vector2d velocity, Vector2d acceleration) {
        this.position = position;
        this.velocity = velocity;
        this.acceleration = acceleration;
    }

    public abstract void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException;

    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException {
        velocity.add(acceleration.product(delta));
        position.add(velocity.product(delta));
    }

    public abstract void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException;

}
