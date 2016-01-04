package angrybirdsold.controllers;

import angrybirdsold.models.GameModel;
import angrybirdsold.views.GameView;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Le controlleur du jeu. Il créé le model de jeu et la vue du jeu, et implémente les méthodes du framework Slick2d et dispatch les appels à ces méthodes au model et à la vue.
 *
 * @author Quentin Brault
 */
public class  GameController extends BasicGameState {

    /**
     * Model du jeu qui reçoit les updates.
     */
    private final GameModel model = new GameModel();

    /**
     * Vue du jeu qui reçoit les appels à render().
     */
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
