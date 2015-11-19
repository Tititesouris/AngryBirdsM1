package angrybirds.graphics;

import angrybirds.structures.Vector2d;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Created by Quentin Brault on 25/09/2015.
 */
public abstract class GraphicalObject {

    protected Vector2d position;

    public GraphicalObject(Vector2d position) {
        this.position = position;
    }

    public abstract void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException;

    public abstract void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException;

    public abstract void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException;
    
    public Vector2d getPosition(){
    	return this.position;
    }

}
