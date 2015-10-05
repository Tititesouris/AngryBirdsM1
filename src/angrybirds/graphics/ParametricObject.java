package angrybirds.graphics;

import angrybirds.parametrics.Parametric;
import angrybirds.structures.Vector2d;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Created by Quentin Brault on 02/10/2015.
 */
public class ParametricObject extends GraphicalObject {

    protected Parametric parametric;

    private double start;

    protected double t;

    public ParametricObject(Parametric parametric, double t) {
        super(parametric.getValue(t));
        this.parametric = parametric;
        this.start = t;
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
        double i = start;
        while (i <= t) {
            Vector2d point = parametric.getValue(i);
            graphics.fillOval((float)point.x, (float)point.y, 1, 1);
            i += 0.1;
        }
    }
}
