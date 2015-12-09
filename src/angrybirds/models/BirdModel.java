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

    private Vector2d startPosition;

    private List<Vector2d> dots;

    private boolean flying;

    private int hit;

    public BirdModel(double x, double y) {
        super(new Vector2d(x, y), new Vector2d(20, 20), new Vector2d(0, 0), new Vector2d(0, 0));
        startPosition = new Vector2d(x, y);
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        flying = false;
        hit = 0;
        dots = new ArrayList<>();
        position = startPosition;
        velocity = new Vector2d(0, 0);
        acceleration = new Vector2d(0, 0);
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException {
        if (isHit()) {
            hit -= delta;
            if (!isHit()) {
                init(gameContainer, stateBasedGame);
            }
        }
        else {
            super.update(gameContainer, stateBasedGame, delta);
            if (flying) {
                if (dots.size() == 0 || dots.get(dots.size() - 1).diff(position).getHypotenuse() > 40) {
                    dots.add(new Vector2d(position.x, position.y));
                }
            }
        }
    }

    public void hit() {
        hit = 2000;
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
