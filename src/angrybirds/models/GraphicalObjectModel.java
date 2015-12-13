package angrybirds.models;

import angrybirds.structures.Constants;
import angrybirds.structures.Vector2d;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Cette classe abstraite représente un object avec une position et une taille.
 *
 * @author Maxime Catteau
 * @author Quentin Brault
 */
public abstract class GraphicalObjectModel implements Model {

    /**
     * Position de l'objet
     */
    protected Vector2d position;

    protected Vector2d size;

    /**
     * Créé un nouvel objet
     *
     * @param position  Position de l'objet
     */
    public GraphicalObjectModel(Vector2d position, Vector2d size) {
        this.position = position;
        this.size = size;
    }

    /**
     * Retourne la position de l'objet.
     *
     * @return  Position de l'objet
     */
    public Vector2d getPosition(){
    	return this.position;
    }

    /**
     * Change la position de l'objet
     * @param x Position X de l'objet
     * @param y Position Y de l'objet
     */
    public void setPosition(double x, double y) {
        this.position = new Vector2d(x, y);
    }

    /**
     * Retourne la taille de l'objet
     * @return  Taille de l'objet
     */
    public Vector2d getSize() {
        return size;
    }

}
