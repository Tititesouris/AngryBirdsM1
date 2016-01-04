package angrybirds.utils;

/**
 * Cette classe utilitaire représente un vecteur à deux dimensions.
 *
 * @author Quentin Brault
 */
public class Vector2d {

    public static final Vector2d ZERO = new Vector2d(0, 0);

    public static final Vector2d ONE = new Vector2d(1, 1);

    public static final Vector2d INVERSE = new Vector2d(-1, -1);

    public float x, y;

    public Vector2d(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Vector2d(float n) {
        this(n, n);
    }

    public Vector2d sum(float n) {
        return new Vector2d(x + n, y + n);
    }

    public Vector2d sum(Vector2d vector) {
        return new Vector2d(x + vector.x, y + vector.y);
    }

    public Vector2d difference(float n) {
        return new Vector2d(x - n, y - n);
    }

    public Vector2d difference(Vector2d vector) {
        return new Vector2d(x - vector.x, y - vector.y);
    }

    public Vector2d product(float n) {
        return new Vector2d(x * n, y * n);
    }

    public Vector2d product(Vector2d vector) {
        return new Vector2d(x * vector.x, y * vector.y);
    }

    public float hypotenuse() {
        return (float) Math.sqrt(x * x + y * y);
    }

    public Vector2d normalized() {
        return new Vector2d(x / hypotenuse(), y / hypotenuse());
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Vector2d && ((Vector2d) o).x == x && ((Vector2d) o).y == y;
    }

    @Override
    public String toString() {
        return "(X: " + x + ", Y: " + y + ")";
    }

}
