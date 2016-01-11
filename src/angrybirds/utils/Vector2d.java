package angrybirds.utils;

/**
 * Cette classe utilitaire représente un vecteur à deux dimensions.
 *
 * @author Quentin Brault
 * @since  2016/10/01
 */
public class Vector2d {

    /**
     * Vecteur nul.
     */
    public static final Vector2d ZERO = new Vector2d(0, 0);

    /**
     * Vecteur unitaire.
     */
    public static final Vector2d ONE = new Vector2d(1, 1);

    /**
     * Vecteur unitaire X.
     */
    public static final Vector2d X = new Vector2d(1, 0);

    /**
     * Vecteur unitaire Y.
     */
    public static final Vector2d Y = new Vector2d(0, 1);

    /**
     * Vecteur inverse.
     */
    public static final Vector2d INVERSE = new Vector2d(-1, -1);

    /**
     * Valeurs du vecteur.
     */
    public float x, y;

    /**
     * Créé un nouveau vecteur.
     *
     * @param x Position X du vecteur.
     * @param y Position Y du vecteur.
     */
    public Vector2d(float x, float y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Créé un nouveau vecteur.
     *
     * @param n Position X et Y du vecteur.
     */
    public Vector2d(float n) {
        this(n, n);
    }

    /**
     * Calcule et retourne la somme terme à terme du vecteur avec la valeur spécifiée.
     *
     * @param n Valeur à ajouter.
     * @return Nouveau vecteur de la somme terme à terme du vecteur avec la valeur spécifiée.
     */
    public Vector2d sum(float n) {
        return new Vector2d(x + n, y + n);
    }

    /**
     * Calcule et retourne la somme terme à terme du vecteur avec le vecteur spécifié.
     *
     * @param vector Vecteur à ajouter.
     * @return Nouveau vecteur de la somme terme à terme du vecteur avec le vecteur spécifié.
     */
    public Vector2d sum(Vector2d vector) {
        return new Vector2d(x + vector.x, y + vector.y);
    }

    /**
     * Calcule et retourne la différence terme à terme du vecteur avec la valeur spécifiée.
     *
     * @param n Valeur à retirer.
     * @return Nouveau vecteur de la différence terme à terme du vecteur avec la valeur spécifiée.
     */
    public Vector2d difference(float n) {
        return new Vector2d(x - n, y - n);
    }

    /**
     * Calcule et retourne la différence terme à terme du vecteur avec le vecteur spécifié.
     *
     * @param vector Vecteur à retirer.
     * @return Nouveau vecteur de la différence terme à terme du vecteur avec le vecteur spécifié.
     */
    public Vector2d difference(Vector2d vector) {
        return new Vector2d(x - vector.x, y - vector.y);
    }

    /**
     * Calcule et retourne le produit terme à terme du vecteur avec la valeur spécifiée.
     *
     * @param n Valeur à multiplier.
     * @return Nouveau vecteur du produit terme à terme du vecteur avec la valeur spécifiée.
     */
    public Vector2d product(float n) {
        return new Vector2d(x * n, y * n);
    }

    /**
     * Calcule et retourne le produit terme à terme du vecteur avec le vecteur spécifié.
     *
     * @param vector Vecteur à multiplier.
     * @return Nouveau vecteur du produit terme à terme du vecteur avec le vecteur spécifié.
     */
    public Vector2d product(Vector2d vector) {
        return new Vector2d(x * vector.x, y * vector.y);
    }

    /**
     * Calcule et retourne la longueur de l'hypoténuse du vecteur.
     *
     * @return Longueur de l'hypoténuse du vecteur.
     */
    public float hypotenuse() {
        return (float) Math.sqrt(x * x + y * y);
    }

    /**
     * Calcule et retourne la normalisation du vecteur.
     *
     * @return Nouveau vecteur normalisé.
     */
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
