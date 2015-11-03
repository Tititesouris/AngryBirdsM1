package angrybirds.parametrics;

import angrybirds.structures.Vector2d;

/**
 * Created by Quentin Brault on 02/10/2015.
 */
/**
 * Cette classe permet a l'oiseau de suivre une trajectoire
 * correspondant a une spirale
 * @author Maxime Catteau
 *
 */
public class Spiral extends Parametric {

    private double xIncrease;

    private double yIncrease;

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
