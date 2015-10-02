package angrybirds.parametrics;

import angrybirds.structures.Vector2d;

/**
 * Created by Quentin Brault on 02/10/2015.
 */
public abstract class Parametric {

    protected Vector2d offset;

    public Parametric(Vector2d offset) {
        this.offset = offset;
    }

    public abstract Vector2d getValue(double t);

    @Override
    public abstract String toString();

}
