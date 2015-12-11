package angrybirds.controllers;

import angrybirds.models.GameModel;
import angrybirds.views.GameView;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 * TODO: Description
 *
 * @author Quentin Brault
 */
public class  GameController extends BasicGameState {

    private final GameModel model = new GameModel();

    private final GameView view = new GameView(model);

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        model.init(gameContainer, stateBasedGame);
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        view.render(gameContainer, stateBasedGame, graphics);
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException {
        model.update(gameContainer, stateBasedGame, delta);
    }

    @Override
    public int getID() {
        return 0;
    }

}
