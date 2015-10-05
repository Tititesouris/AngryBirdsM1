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

    public Vector2d getTangent(double t) {
        Vector2d a = getValue(t + 0.001);
        Vector2d b = getValue(t);
        return new Vector2d((a.x - b.x) / 0.001, (a.y - b.y) / 0.001);
    }

    @Override
    public abstract String toString();

}
