package angrybirds.parametrics;

import angrybirds.structures.Vector2d;

/**
 * Cette classe représente une courbe linéaire
 *
 * @author Maxime Catteau
 */
public class Linear extends Parametric {

    /**
     * Taux d'accroissement
     */
    private double a;

    /**
     * Créé une courbe linéaire
     *
     * @param offset    offset de la courbe
     * @param a         Taux d'accroissement
     */
    public Linear(Vector2d offset, double a) {
        super(offset);
        this.a = a;
    }

    @Override
    public Vector2d getValue(double t) {
        return new Vector2d(a * t + offset.x, offset.y);
    }

    @Override
    public String toString() {
        return "Linear(X: " + a + " * t + " + offset.x + ", Y: " + offset.y + ")";
    }

}
