package angrybirdsold.models;

import angrybirdsold.structures.Vector2d;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Cette classe représente un objet graphique vectoriel.
 *
 * @author Quentin Brault
 *
 */
public abstract class VectorObjectModel extends GraphicalObjectModel {

    /**
     * Vecteurs vélocité et accélération
     */
    protected Vector2d velocity, acceleration;

    /**
     * Créé un nouvel objet vectoriel
     *
     * @param position      Position de départ de l'objet
     * @param size          Taille de l'objet
     * @param velocity      Vélocité de départ de l'objet
     * @param acceleration  Accélération de départ de l'objet
     */
    public VectorObjectModel(Vector2d position, Vector2d size, Vector2d velocity, Vector2d acceleration) {
        super(position, size);
        this.velocity = velocity;
        this.acceleration = acceleration;
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException {
        velocity = velocity.add(acceleration.product(delta));
        position = position.add(velocity.product(delta));
    }

    /**
     * Retourne la vélocité
     *
     * @return  Vélocité de l'objet
     */
    public Vector2d getVelocity() {
        return velocity;
    }

    /**
     * Change la vélocité
     * @param x Vélocité sur l'axe des X.
     * @param y Vélocité sur l'axe des Y.
     */
    public void setVelocity(double x, double y) {
        this.velocity = new Vector2d(x, y);
    }

    /**
     * Retourne l'accélération.
     * @return  Accélération de l'objet.
     */
    public Vector2d getAcceleration() {
        return acceleration;
    }

    /**
     * Change l'accélération.
     * @param x Accélération sur l'axe des X.
     * @param y Accélération sur l'axe des Y.
     */
    public void setAcceleration(double x, double y) {
        this.acceleration = new Vector2d(x, y);
    }

}
