package angrybirds.graphics.objects;

import java.util.ArrayList;
import java.util.List;

import angrybirds.Tool;
import angrybirds.graphics.ParametricObject;
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

    private static final int RADIUS = 32;

    private Image sprite;

    public Bird(Vector2d position) {
        super(new Sinusoid(position, 50, 50), 0);
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
    
    public int getRadius(){
    	return this.RADIUS;
    }
}
