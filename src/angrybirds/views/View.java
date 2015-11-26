package angrybirds.views;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 * TODO: Description
 *
 * @author User
 */
public interface View {

    void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException;

    void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException;

}