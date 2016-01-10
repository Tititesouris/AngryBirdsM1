package angrybirds;

import angrybirds.controllers.GameController;
import angrybirds.exceptions.AngryBirdsException;
import angrybirds.views.View;
import org.newdawn.slick.SlickException;

/**
 * Cette classe est la première éxécutée.
 * Elle créée le controlleur du jeu et lance l'interface graphique.
 *
 * @author AngryBirdsM1
 * @since  2016/10/01
 */
public class Main {

    public static void main(String[] args) {

        try {
            GameController gameController = new GameController("res/game.json");
            View.setupSlick2d(gameController);
            View.app.start();
        } catch (AngryBirdsException e) {
            e.printStackTrace();
        } catch (SlickException e) {
            e.printStackTrace();
        }

    }

}