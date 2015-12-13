package angrybirds.models;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Cette interface doit être implémentée par tous les models.
 *
 * @author Quentin Brault
 */
public interface Model {

    /**
     * Cette méthode est appelé au chargement de l'objet.
     *
     * @param gameContainer     Contexte du jeu
     * @param stateBasedGame    Référence au jeu
     * @throws SlickException   Librairie Slick
     */
    void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException;

    /**
     * Cette méthode est appelée à chaque cycle du jeu.
     *
     * @param gameContainer     Contexte du jeu
     * @param stateBasedGame    Référence au jeu
     * @param delta             Nombre de millisecondes depuis le dernier appel de la méthode
     * @throws SlickException   Librairie Slick
     */
    void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException;

}