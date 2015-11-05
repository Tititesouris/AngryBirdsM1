package angrybirds.structures;

/**
 * Cette classe représente un vecteur à deux dimensions.
 *
 * @author Quentin Brault
 * @author Florent Marcaille
 */
public class Vector2d {

    /**
     * Valeur x et y du vecteur
     */
    public double x, y;

    /**
     * Création d'un vecteur de valeurs spécifiées
     *
     * @param x Valeur x du vecteur
     * @param y Valeur y du vecteur
     */
    public Vector2d(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Retourne un vecteur étant la somme de ce vecteur et de celui passé en paramètre.
     *
     * @param vector    Vecteur à ajouté
     * @return  Somme des deux vecteurs
     */
    public Vector2d add(Vector2d vector) {
        return new Vector2d(x + vector.x, y + vector.y);
    }

    /**
     * Retourne un vecteur étant le produit de ce vecteur par la quantité passée en paramètre.
     *
     * @param amount    Valeur à multipliée
     * @return  Produit du vecteur et de la valeur
     */
    public Vector2d product(double amount) {
        return new Vector2d(x * amount, y * amount);
    }

    /**
     * Retourne la longueur de l'hypoténuse du triangle rectangle formé par ce vecteur.
     *
     * @return  Longeur de l'hypoténuse.
     */
    public double getHypotenuse() {
        return Math.sqrt(x*x + y*y);
    }

    /**
     * Retourne ce vecteur normalisé
     *
     * @return  Vecteur normalisé
     */
    public Vector2d normalize() {
        double hypotenuse = getHypotenuse();
        return new Vector2d(x / hypotenuse, y / hypotenuse);
    }

    /**
     * Compare ce vecteur avec celui passé en paramètre
     *
     * @param vector    Vecteur à comparer
     * @return  True si les deux vecteurs sont égaux, false sinon.
     */
    public boolean equals(Vector2d vector) {
        return x == vector.x && y == vector.y;
    }

    @Override
    public String toString() {
        return "X: " + x + ", Y: " + y;
    }

}
