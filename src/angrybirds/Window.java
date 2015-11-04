package angrybirds;

import angrybirds.structures.Constantes;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Created by Quentin Brault on 24/09/2015.
 */
public class Window extends StateBasedGame {

    public Window() {
        super("Angry Birds");
    }

    public static void main(String[] args) {
        try {
            AppGameContainer app = new AppGameContainer(new Window());
            app.setDisplayMode(Constantes.SCREEN_LENGTH,Constantes.SCREEN_WIDTH, false);
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
