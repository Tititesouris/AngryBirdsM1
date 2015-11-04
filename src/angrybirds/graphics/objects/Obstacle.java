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
 * Created by Quentin Brault on 25/09/2015.
 */
public class Obstacle extends VectorObject {

    /**
     *  stock le rayon
     */
    private int radius;

    /**
     * image de l'obstacle
     */
    private Image sprite;

    /**
     * Création d'un obstacle aux coordonnées et au rayon passés en paramètre
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
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        sprite.draw((float)position.x - radius, (float)position.y - radius);
        graphics.drawOval((float)position.x - radius, (float)position.y - radius, radius * 2, radius * 2);
    }

    /**
     * Retourne le rayon de l'obstacle
     * @return le rayon de l'obstacle
     */
    public int getRadius(){
    	return this.radius;
    }
}
