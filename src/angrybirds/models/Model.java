package angrybirds.models;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 * TODO: Description
 *
 * @author User
 */
public interface Model {

    void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException;

    void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException;

}