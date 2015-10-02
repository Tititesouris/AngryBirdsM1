package angrybirds.graphics.objects;

import angrybirds.graphics.ParametricObject;
import angrybirds.parametrics.Parametric;
import angrybirds.parametrics.Sinusoid;
import angrybirds.parametrics.Spiral;
import angrybirds.structures.Vector2d;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Created by Quentin Brault on 25/09/2015.
 */
public class Bird extends ParametricObject {

    public Bird(Vector2d position) {
        super(new Sinusoid(position, 50, 50), 0);
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {

    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        super.render(gameContainer, stateBasedGame, graphics);
        graphics.drawOval((float)position.x - 25, (float)position.y - 25, 50, 50);
    }

}
