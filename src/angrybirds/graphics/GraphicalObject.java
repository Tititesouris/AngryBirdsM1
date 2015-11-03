package angrybirds.graphics;

import angrybirds.structures.Vector2d;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Created by Quentin Brault on 25/09/2015.
 */
/**
 * Cette classe abstraite permet d'effectuer le rendu des objects graphiques
 * ce qui affiche l'ecran de jeu et les objects qu'il contient
 * @author Maxime Catteau
 *
 */
public abstract class GraphicalObject {

    protected Vector2d position;

    public GraphicalObject(Vector2d position) {
        this.position = position;
    }

    /**
     * Cette m�thode permet d'initialiser l'�cran de jeu
     * @param gameContainer
     * @param stateBasedGame
     * @throws SlickException
     */
    public abstract void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException;

    /**
     * Cette methode permet de mettre a jour l'�cran a chaque fois qu'il subit
     * un changement
     * @param gameContainer
     * @param stateBasedGame
     * @param delta
     * @throws SlickException
     */
    public abstract void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException;

    /**
     * Cette m�thode est un compl�ment de update, elle permet d'effectuer le rendu de
     * l'�cran � chaque fois qu'il est mis � jour
     * @param gameContainer
     * @param stateBasedGame
     * @param graphics
     * @throws SlickException
     */
    public abstract void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException;
    
    public Vector2d getPosition(){
    	return this.position;
    }

}
