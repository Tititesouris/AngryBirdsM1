package angrybirds.graphics.objects;

import angrybirds.graphics.VectorObject;
import angrybirds.structures.Vector2d;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Created by Quentin Brault on 25/09/2015.
 */
public class Obstacle extends VectorObject {

    private int radius;

    public Obstacle(Vector2d position, int radius) {
        super(position, new Vector2d(0, 0), new Vector2d(0, 0));
        this.radius = radius;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {

    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        graphics.drawOval((float)position.x - radius / 2, (float)position.y - radius / 2, radius / 2, radius / 2);
    }
}
