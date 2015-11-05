package angrybirds.parametrics;

import angrybirds.structures.Vector2d;

/**
 * Cette classe représente une courbe en spirale.
 *
 * @author Florent Marcaille
 */
public class Spiral extends Parametric {

    /**
     * Taux d'accroissement des x
     */
    private double xIncrease;

    /**
     * Taux d'accroisement des y
     */
    private double yIncrease;

    /**
     * Créé une nouvelle spirale
     *
     * @param offset        Offsetde la courbe
     * @param xIncrease     Accroissement des x
     * @param yIncrease     Accroissement des y
     */
    public Spiral(Vector2d offset, double xIncrease, double yIncrease) {
        super(offset);
        this.xIncrease = xIncrease;
        this.yIncrease = yIncrease;
    }

    @Override
    public Vector2d getValue(double t) {
        return new Vector2d(xIncrease * t * Math.cos(t) + offset.x, yIncrease * t * Math.sin(t) + offset.y);
    }

    @Override
    public String toString() {
        return "Spiral(X: " + xIncrease + " * t * cos(t) + " + offset.x + ", Y: " + yIncrease + " * t * sin(t) + " + offset.y +  ")";
    }

}
