package angrybirds;

import angrybirds.controllers.Controller;
import angrybirds.controllers.GameController;
import angrybirds.exceptions.AngryBirdsException;
import angrybirds.models.GameModel;
import angrybirds.views.View;
import org.newdawn.slick.SlickException;

/**
 * TODO: Description
 *
 * @author Tititesouris
 */
public class Main {

    public static void main(String[] args) {

        try {
            GameController gameController = new GameController();
            View.setupSlick2d(gameController);
            View.app.start();
        } catch (AngryBirdsException e) {
            e.printStackTrace();
        } catch (SlickException e) {
            e.printStackTrace();
        }

    }

}
