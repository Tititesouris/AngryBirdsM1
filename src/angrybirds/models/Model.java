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
     * Initialise le modèle.
     *
     * @param gameContainer     Conteneur du jeu.
     * @param stateBasedGame    Référence au jeu.
     * @throws SlickException
     */
    void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException;

    /**
     * Met à jour le modèle.
     *
     * @param gameContainer     Conteneur du jeu.
     * @param stateBasedGame    Référence au jeu.
     * @param delta             Temps en millisecondes depuis le dernier appel à update()
     * @throws SlickException
     */
    void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException;

}