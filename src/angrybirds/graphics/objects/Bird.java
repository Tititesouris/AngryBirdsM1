package angrybirds.graphics.objects;

import java.util.ArrayList;
import java.util.List;

import angrybirds.Tool;
import angrybirds.graphics.ParametricObject;
import angrybirds.parametrics.Bezier;
import angrybirds.parametrics.Parametric;
import angrybirds.parametrics.Sinusoid;
import angrybirds.structures.Vector2d;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Created by Quentin Brault on 25/09/2015.
 */
public class Bird extends ParametricObject {

    /**
     * Taille du rayon de l'oiseau
     */
    private static final int RADIUS = 16;
    /**
     * Variable de type Image
     */
    private Image sprite;

    /**
     * Création d'un oiseau.
     *
     * @param position  Position initiale de l'oiseau
     * @param parametric    Courbe décrivant le chemin de l'oiseau
     */
    public Bird(Vector2d position, Parametric parametric) {
        super(parametric, 0);
        this.position = position;
        this.sprite = Tool.getImage("/res/bird.png").getScaledCopy(RADIUS * 2, RADIUS * 2);
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {

    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        super.render(gameContainer, stateBasedGame, graphics);
        Vector2d tangent = parametric.getTangent(t);
        sprite.setRotation(45 + (float)Math.toDegrees(Math.atan2(tangent.y, tangent.x)));
        sprite.draw((float)position.x - RADIUS, (float)position.y - RADIUS);
    }

    /**
     * Retourne le rayon de l'oiseau
     * @return le rayon de l'oiseau
     */
    public int getRadius(){
    	return this.RADIUS;
    }
}
