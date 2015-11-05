package angrybirds.graphics;

import angrybirds.structures.Vector2d;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Cette classe abstraite contient toutes les méthodes et le champs nécessaire à l'affichage et à la mise à jour d'objets graphiques.
 *
 * @author Maxime Catteau
 * @author Quentin Brault
 */
public abstract class GraphicalObject {

    /**
     * Position de l'objet
     */
    protected Vector2d position;

    /**
     * Créé un nouvel objet
     *
     * @param position  Position de l'objet
     */
    public GraphicalObject(Vector2d position) {
        this.position = position;
    }

    /**
     * Cette méthode est appelé au chargement de l'objet.
     *
     * @param gameContainer     Contexte du jeu
     * @param stateBasedGame    Référence au jeu
     * @throws SlickException
     */
    public abstract void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException;

    /**
     * Cette méthode est appelée à chaque cycle du jeu.
     *
     * @param gameContainer     Contexte du jeu
     * @param stateBasedGame    Référence au jeu
     * @param delta             Nombre de millisecondes depuis le dernier appel de la méthode
     * @throws SlickException
     */
    public abstract void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException;

    /**
     * Cette méthode permet d'afficher l'objet sur l'écran.
     *
     * @param gameContainer     Contexte du jeu
     * @param stateBasedGame    Référence au jeu
     * @param graphics          Contexte graphique
     * @throws SlickException
     */
    public abstract void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException;

    /**
     * Retourne la position de l'objet.
     *
     * @return  Position de l'objet
     */
    public Vector2d getPosition(){
    	return this.position;
    }

}
