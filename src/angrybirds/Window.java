package angrybirds;

import angrybirds.controllers.GameController;
import angrybirds.structures.Constants;
import angrybirds.views.GameView;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Cette classe représente la fenêtre de jeu.
 */
public class Window extends StateBasedGame {

    /**
     * Singleton de la fenêtre
     */
    private static Window window = new Window();

    /**
     * Créé une fenêtre intitulée Angry Birds
     */
    public Window() {
        super("Angry Birds");
    }

    public static void main(String[] args) {
        try {
            AppGameContainer app = new AppGameContainer(Window.getWindow());
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
        addState(new GameController());
    }

    /**
     * Retourne l'instance de la fenêtre.
     * @return  Instance de la fenêtre.
     */
    public static Window getWindow() {
        return window;
    }
    
}
