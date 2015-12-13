package angrybirds.views;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Cette interface determine comment les vues doivent etre concues
 *
 * @author Quentin Brault
 */
public interface View {

    /**
     * Initialise la vue.
     *
     * @param gameContainer     Conteneur du jeu.
     * @param stateBasedGame    Référence au jeu.
     * @throws SlickException
     */
    void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException;

    /**
     * Affiche la vue.
     *
     * @param gameContainer     Conteneur du jeu.
     * @param stateBasedGame    Référence au jeu.
     * @param graphics          Contexte graphique.
     * @throws SlickException
     */
    void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException;

}