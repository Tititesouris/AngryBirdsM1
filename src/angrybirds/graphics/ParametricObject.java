package angrybirds.graphics;

import angrybirds.parametrics.Parametric;
import angrybirds.structures.Vector2d;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Cette classe représente un objet graphique suivant une courbe paramétrique.
 *
 * @author Quentin Brault
 *
 */
public class ParametricObject extends GraphicalObject {

    /**
     * Courbe paramétrique suivit
     */
    protected Parametric parametric;

    /**
     * Valeur de départ
     */
    private double start;

    /**
     * Valeur actuelle
     */
    protected double t;

    /**
     * Créé un nouvel objet paramétrique
     *
     * @param parametric    Courbe paramétrique à suivre
     * @param t             Valeur de départ
     */
    public ParametricObject(Parametric parametric, double t) {
        super(parametric.getValue(t));
        this.parametric = parametric;
        this.start = t;
        this.t = t;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {

    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException {
        t += delta / 200f;
        position = parametric.getValue(t);
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        double i = start;
        while (i <= t) {
            Vector2d point = parametric.getValue(i);
            graphics.fillOval((float)point.x, (float)point.y, 1, 1);
            i += 0.5;
        }
    }

}
