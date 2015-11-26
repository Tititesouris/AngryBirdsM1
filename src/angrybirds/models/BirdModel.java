package angrybirds.models;

import angrybirds.structures.Vector2d;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 * TODO: Description
 *
 * @author User
 */
public class BirdModel extends VectorObjectModel {

    private int hit;

    public BirdModel(double x, double y) {
        super(new Vector2d(x, y), new Vector2d(10, 10), new Vector2d(1, -1), new Vector2d(0, 0));
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {

    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException {
        if (isHit()) {
            hit -= delta;
        }
        else {
            super.update(gameContainer, stateBasedGame, delta);
        }
    }

    public boolean isHit() {
        return hit > 0;
    }

}
