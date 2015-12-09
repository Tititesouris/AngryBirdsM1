package angrybirds.models;

import angrybirds.structures.Vector2d;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO: Description
 *
 * @author User
 */
public class BirdModel extends VectorObjectModel {

    private List<Vector2d> dots;

    private boolean flying;

    private int hit;

    public BirdModel(double x, double y) {
        super(new Vector2d(x, y), new Vector2d(30, 30), new Vector2d(0, 0), new Vector2d(0, 0));
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        flying = false;
        dots = new ArrayList<>();
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException {
        if (isHit()) {
            hit -= delta;
        }
        else {
            super.update(gameContainer, stateBasedGame, delta);
            if (flying) {
                if (dots.size() == 0 || dots.get(dots.size() - 1).diff(position).getHypotenuse() > 25) {
                    dots.add(new Vector2d(position.x, position.y));
                }
            }
        }
    }

    public boolean isFlying() {
        return flying;
    }

    public void setFlying(boolean flying) {
        this.flying = flying;
    }

    public boolean isHit() {
        return hit > 0;
    }

    public List<Vector2d> getDots() {
        return dots;
    }

}
