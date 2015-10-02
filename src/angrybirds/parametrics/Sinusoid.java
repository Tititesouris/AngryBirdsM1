package angrybirds.parametrics;

import angrybirds.structures.Vector2d;

/**
 * Created by Quentin Brault on 02/10/2015.
 */
public class Sinusoid implements Parametric {

    @Override
    public Vector2d getValue(double t) {
        return new Vector2d(30 * t, 100 + 50 * Math.sin(t));
    }

}
