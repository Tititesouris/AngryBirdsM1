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
 * Cette classe représente l'oiseau qui suit une courbe paramétrique.
 *
 * @author Maxime Catteau
 * @author Noémie Clay
 */
public class Bird extends VectorObject {

    /**
     * Taille du rayon de l'oiseau
     */
    private static final int RADIUS = 16;

    /**
     * Variable de type Image
     */
    private Image sprite;

    /**
     * Nombre de millisecondes avant de ne plus etre touché
     */
    private int hit;

    /**
     * Création d'un oiseau.
     *
     * @param position  Position initiale de l'oiseau
     */
    public Bird(Vector2d position) {
        super(position, new Vector2d(0.1, -0.1), new Vector2d(0, 0));
        this.sprite = Tool.getImage("/res/bird.png").getScaledCopy(RADIUS * 2, RADIUS * 2);
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
        super.render(gameContainer, stateBasedGame, graphics);
        Vector2d tangent = new Vector2d(1, 0);
        sprite.setRotation(45 + (float)Math.toDegrees(Math.atan2(tangent.y, tangent.x)));
        if (hit <= 0) {
            sprite.draw((float) position.x - RADIUS, (float) position.y - RADIUS);
        }
        else {
            sprite.drawFlash((float) position.x - RADIUS, (float) position.y - RADIUS);
        }
    }

    public void hit() {
        hit = 2000;
    }

    /**
     * Retourne le rayon de l'oiseau
     *
     * @return le rayon de l'oiseau
     */
    public int getRadius(){
    	return this.RADIUS;
    }
}
