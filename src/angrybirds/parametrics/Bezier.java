package angrybirds.parametrics;

import angrybirds.structures.Vector2d;

/**
 * Created by Quentin Brault on 03/11/2015.
 */
public class Bezier extends Parametric {

    private Vector2d[] points;

    public Bezier(Vector2d offset, Vector2d[] points) {
        super(offset);
        this.points = points;
    }

    @Override
    public Vector2d getValue(double t) {
        Vector2d[] points = this.points;
        while (points.length > 2) {
            Vector2d[] middles = new Vector2d[points.length / 2 + 1];
            for (int i = 0; i < middles.length; i++) {
                middles[i] = points[i + 1].diff(points[i]);
            }
            points = middles;
        }
        return points[0].sum(points[1].diff(points[0]).product(t / 100));
    }

    @Override
    public String toString() {
        String bezier = "Bezier(";
        for (Vector2d point : points) {
            bezier += point + ", ";
        }
        return bezier + ")";
    }

}
