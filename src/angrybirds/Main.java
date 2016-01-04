package angrybirds;

import angrybirds.controllers.Controller;
import angrybirds.controllers.GameController;

/**
 * TODO: Description
 *
 * @author Tititesouris
 */
public class Main {
//TODO Does the controller create the model and or the view? One controller for all models of same type?
    public static void main(String[] args) {

        Controller gameController = new GameController();
        Controller.setupSlick2d();

    }

}
