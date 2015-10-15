package angrybirds.graphics.objects;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import angrybirds.Tool;
import angrybirds.graphics.ParametricObject;
import angrybirds.parametrics.Linear;
import angrybirds.parametrics.Sinusoid;
import angrybirds.parametrics.Spiral;
import angrybirds.structures.Vector2d;

/**
 * Created by Quentin Brault on 25/09/2015.
 */
public class Bird extends ParametricObject {

    private static final int SIZE = 50;
    private int stunned;
    
    private Image sprite;

    public Bird(Vector2d position) {
        super(new Sinusoid(position, 50, 50), 0); //Courbe sinusoidale
        //super(new Spiral(position, 5, 5), 0); //Courbe Spirale
        //super(new Linear(position,50),0); //Courbe lineaire
        this.sprite = Tool.getImage("res/bird.png").getScaledCopy(SIZE, SIZE);
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {

    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException {
    	if(stunned <= 0){
    		super.update(gameContainer, stateBasedGame, delta);
    	} else {
    		stunned-=delta;
    	}
    }
    
    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        super.render(gameContainer, stateBasedGame, graphics);
        Vector2d tangent = parametric.getTangent(t);
        sprite.setRotation(45 + (float)Math.toDegrees(Math.atan2(tangent.y, tangent.x)));
        sprite.draw((float)position.x - SIZE / 2, (float)position.y - SIZE / 2);
    }

    public void hitsObject(){
    	this.stunned = 2000;
    	
    	reset();
    }
    
    public void reset(){
    	t = start;
    }
}
