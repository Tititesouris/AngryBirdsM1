package angrybirds.parametrics;

import angrybirds.structures.Vector2d;

/**
 * Created by Quentin Brault on 02/10/2015.
 */
public class Sinusoid extends Parametric {

    public Sinusoid(Vector2d offset) {
        super(offset);
    }

    @Override
    public Vector2d getValue(double t) {
        return new Vector2d(30 * t + offset.x, 50 * Math.sin(t) + offset.y);
    }

    @Override
    public String toString() {
        return "Sinusoid: TODO";
    }

}
