package angrybirdsold.models;

import angrybirdsold.structures.Vector2d;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import java.util.ArrayList;
import java.util.List;

/**
 * Cette classe représente le model de l'oiseau.
 *
 * @author Quentin Brault
 */
public class BirdModel extends VectorObjectModel {

    /**
     * Position de départ de l'oiseau
     */
    private Vector2d startPosition;

    /**
     * L'ensemble des points laissés derrière le passage de l'oiseau
     */
    private List<Vector2d> dots;

    /**
     * True si l'oiseau est en vol. False si il est sur le lanceur.
     */
    private boolean flying;

    /**
     * Temps en millisecondes avant de ne plus être touché.
     */
    private int hit;

    /**
     * Créé un nouvel oiseau.
     *
     * @param x La position X de départ.
     * @param y La position Y de départ.
     */
    public BirdModel(double x, double y) {
        super(new Vector2d(x, y), new Vector2d(20, 20), new Vector2d(0, 0), new Vector2d(0, 0));
        startPosition = new Vector2d(x, y);
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        flying = false;
        hit = 0;
        dots = new ArrayList<>();
        position = startPosition;
        velocity = new Vector2d(0, 0);
        acceleration = new Vector2d(0, 0);
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException {
        if (isHit()) {
            hit -= delta;
            if (!isHit()) {
                init(gameContainer, stateBasedGame);
            }
        }
        else {
            super.update(gameContainer, stateBasedGame, delta);
            if (flying) {
                if (dots.size() == 0 || dots.get(dots.size() - 1).diff(position).getHypotenuse() > 40) {
                    dots.add(new Vector2d(position.x, position.y));
                }
            }
        }
    }

    /**
     * Indique que l'oiseau vient d'être touché.
     */
    public void hit() {
        hit = 2000;
    }

    /**
     * Retourne true si l'oiseau est en vol. False sinon.
     * @return  True si l'oiseau vol. False si il est sur le lanceur.
     */
    public boolean isFlying() {
        return flying;
    }

    /**
     * Indique si l'oiseau est en vol ou non.
     * @param flying    True si l'oiseau vol. False sinon.
     */
    public void setFlying(boolean flying) {
        this.flying = flying;
    }

    /**
     * Retourne true si l'oiseau est touché. False sinon.
     *
     * @return  True si l'oiseau est touché. False sinon.
     */
    public boolean isHit() {
        return hit > 0;
    }

    /**
     * Retourne la liste des points pour tracer le chemin.
     *
     * @return  La liste des points sur le chemin de l'oiseau.
     */
    public List<Vector2d> getDots() {
        return dots;
    }

}
