package angrybirds;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Created by Quentin Brault on 25/09/2015.
 */
public class Bird extends GraphicalObject {

    public Bird(Vector2d position) {
        super(position, new Vector2d(0.1, 0), new Vector2d(0.0001, 0));
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {

    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        graphics.drawOval((float)position.x, (float)position.y, 10, 10);
    }

}
