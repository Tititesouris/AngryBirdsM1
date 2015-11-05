package angrybirds;

import angrybirds.structures.Constants;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Cette classe représente la fenêtre de jeu.
 */
public class Window extends StateBasedGame {

    /**
     * Créé une fenêtre intitulée Angry Birds
     */
    public Window() {
        super("Angry Birds");
    }

    public static void main(String[] args) {
        try {
            AppGameContainer app = new AppGameContainer(new Window());
            app.setDisplayMode(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT, false);
            app.setAlwaysRender(true);
            app.setTargetFrameRate(60);
            app.setMinimumLogicUpdateInterval(10);
            app.start();
        }
        catch (SlickException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initStatesList(GameContainer gameContainer) throws SlickException {
        addState(new Game());
    }
    
}
