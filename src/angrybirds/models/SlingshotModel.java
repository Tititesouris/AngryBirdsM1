package angrybirds.models;

import angrybirds.structures.Vector2d;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tests.PackedSheetTest;

/**
 * TODO: Description
 *
 * @author Quentin Brault
 */
public class SlingshotModel extends GraphicalObjectModel {

    BirdModel bird;

    boolean active;

    public SlingshotModel(BirdModel bird) {
        super(new Vector2d(bird.getPosition().x, bird.getPosition().y), new Vector2d(bird.getSize().x * 2, 200));
        this.bird = bird;
        this.active = false;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {

    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException {
        if (!bird.isFlying()) {
            Input input = gameContainer.getInput();
            if (!active) {
                if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
                    active = true;
                }
            } else {
                if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
                    bird.setPosition(input.getMouseX(), input.getMouseY());
                } else {
                    Vector2d dir = new Vector2d(position.x - bird.getPosition().x, position.y - bird.getPosition().y);
                    dir = dir.normalize().product(Math.min(10, dir.getHypotenuse() / 80));
                    bird.setVelocity(dir.x, dir.y); // Impulsion
                    bird.setAcceleration(0, 0.004); // Gravité
                    bird.setFlying(true);
                    active = false;
                }
            }
        }
    }

    public boolean isActive() {
        return active;
    }

    public Vector2d getBirdPosition() {
        return bird.getPosition();
    }
}
