package angrybirds.graphics;

import angrybirds.parametrics.Parametric;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Created by Quentin Brault on 02/10/2015.
 */
public class ParametricObject extends GraphicalObject {

    private Parametric parametric;

    protected double t;

    public ParametricObject(Parametric parametric, double t) {
        super(parametric.getValue(t));
        this.parametric = parametric;
        this.t = t;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {

    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException {
        t += delta / 100f;
        position = parametric.getValue(t);
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {

    }
}
