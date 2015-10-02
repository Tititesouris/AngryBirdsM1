package angrybirds.parametrics;

import angrybirds.structures.Vector2d;

/**
 * Created by Quentin Brault on 02/10/2015.
 */
public class Linear extends Parametric {

    private double a;

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
        return "Linear(X: " + a + "t + " + offset.x + ", Y: " + offset.y + ")";
    }

}
