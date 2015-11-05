package angrybirds.parametrics;

import angrybirds.structures.Vector2d;

/**
 * Cette classe représente une courbe de bézier.
 *
 * @author Quentin Brault
 * @see Parametric
 */
public class Bezier extends Parametric {

    /**
     * Liste des points qui définissent la courbe de bézier
     */
    private Vector2d[] points;

    /**
     * Créé une nouvelle courbe de bézier
     *
     * @param offset    Offset de la courbe
     * @param points    Liste des points de la courbe
     */
    public Bezier(Vector2d offset, Vector2d[] points) {
        super(offset);
        this.points = points;
    }

    @Override
    public Vector2d getValue(double t) {
        Vector2d[] oldPoints = this.points;
        Vector2d[] points = oldPoints;
        while (points.length > 1) {
            points = new Vector2d[points.length - 1];
            for (int i = 0; i < points.length; i++) {
                Vector2d line = new Vector2d(oldPoints[i + 1].x - oldPoints[i].x, oldPoints[i + 1].y - oldPoints[i].y);
                Vector2d direction = line.normalize();
                points[i] = oldPoints[i].add(direction.product(t * 30));
            }
            oldPoints = points;
        }
        return points[0];
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
