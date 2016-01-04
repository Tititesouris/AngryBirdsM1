package angrybirdsold.views;

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
     * Cette méthode est appelé au chargement de l'objet.
     *
     * @param gameContainer     Contexte du jeu
     * @param stateBasedGame    Référence au jeu
     * @throws SlickException   Librairie Slick
     */
    void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException;

    /**
     * Affiche la vue.
     *
     * @param gameContainer     Contexte du jeu
     * @param stateBasedGame    Référence au jeu
     * @param graphics          Contexte graphique.
     * @throws SlickException   Librairie Slick
     */
    void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException;

}