package angrybirds.models;

import angrybirds.structures.Vector2d;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Cette classe représente le lanceur
 *
 * @author Quentin Brault
 */
public class SlingshotModel extends GraphicalObjectModel {

    /**
     * L'oiseau
     */
    private BirdModel bird;

    /**
     * Portée d'étirement du lanceur
     */
    private double range;

    /**
     * True si le lanceur est étiré
     */
    private boolean active;


    /**
     * Crée un lanceur contenant l'oiseau.
     * @param bird  Oiseau sur le lanceur
     * @param range Portée d'étirement du lanceur
     */
    public SlingshotModel(BirdModel bird, double range) {
        super(new Vector2d(bird.getPosition().x, bird.getPosition().y), new Vector2d(bird.getSize().x * 2, 200));
        this.bird = bird;
        this.range = range;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        this.active = false;
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
                    Vector2d newPos = new Vector2d(input.getMouseX(), input.getMouseY()).diff(position);
                    newPos = position.add(newPos.normalize().product(Math.min(range, newPos.getHypotenuse())));
                    bird.setPosition(newPos.x, newPos.y);
                } else {
                    Vector2d dir = new Vector2d(position.x - bird.getPosition().x, position.y - bird.getPosition().y);
                    dir = dir.normalize().product(Math.min(10, dir.getHypotenuse() / 100));
                    bird.setVelocity(dir.x, dir.y); // Impulsion
                    bird.setAcceleration(0, 0.002); // Gravité
                    bird.setFlying(true);
                    active = false;
                }
            }
        }
    }

    /**
     * retourne true si le lanceur est étiré
     * @return True si le lanceur est étiré
     */
    public boolean isActive() {
        return active;
    }

    /**
     * Retourne la position de l'oiseau
     * @return la position de l'oiseau
     */
    public Vector2d getBirdPosition() {
        return bird.getPosition();
    }
}
