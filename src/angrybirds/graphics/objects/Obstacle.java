package angrybirds.graphics.objects;

import angrybirds.Tool;
import angrybirds.graphics.VectorObject;
import angrybirds.structures.Vector2d;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Cette classe représente un obstacle.
 *
 * @author Maxime Catteau
 * @author Noémie Clay
 * @see VectorObject
 */
public class Obstacle extends VectorObject {

    /**
     *  Rayon de l'obstacle
     */
    private int radius;

    /**
     * Image de l'obstacle
     */
    private Image sprite;

    /**
     * Nombre de millisecondes avant de ne plus être touché
     */
    private int hit;

    /**
     * Création d'un obstacle aux coordonnées et au rayon passés en paramètre
     *
     * @param position position de l'obstacle
     * @param radius  rayon de l'obstacle
     */
    public Obstacle(Vector2d position, int radius) {
        super(position, new Vector2d(0, 0), new Vector2d(0, 0));
        this.radius = radius;
        this.sprite = Tool.getImage("/res/flame.png").getScaledCopy(radius * 2, radius * 2);
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {

    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException {
        if (hit <= 0) {
            super.update(gameContainer, stateBasedGame, delta);
        }
        else {
            hit -= delta;
        }
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        if (hit <= 0) {
            sprite.draw((float) position.x - radius, (float) position.y - radius);
        }
        else {
            sprite.drawFlash((float) position.x - radius, (float) position.y - radius);
        }
    }

    public void hit() {
        hit = 2000;
    }

    /**
     * Retourne le rayon de l'obstacle
     *
     * @return le rayon de l'obstacle
     */
    public int getRadius(){
    	return this.radius;
    }
}
