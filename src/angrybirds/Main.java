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
//TODO Does the controller create the model and or the view? One controller for all models of same type?
    public static void main(String[] args) {

        try {
            Controller gameController = new GameController();
            View.app.start();
        } catch (AngryBirdsException e) {
            e.printStackTrace();
        } catch (SlickException e) {
            e.printStackTrace();
        }

    }

}
