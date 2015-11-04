package angrybirds.structures;

/**
 * Created by Quentin Brault on 25/09/2015.
 */
public class Vector2d {

    /**
     * Variables qui stockant les coordonnées des objets
     */
    public double x, y;

    /**
     * Création d'un vecteur de coordonnées passés en paramètres
     * @param x
     * @param y
     */
    public Vector2d(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Méthode qui ajoute le vecteur courant au vecteur passé en paramètre
     * @param vector
     * @return Vector2d issu du calcul
     */
    public Vector2d add(Vector2d vector) {
        this.x += vector.x;
        this.y += vector.y;
        return this;
    }

    /**
     * Méthode qui fait la somme du vecteur courant avec vecteur passé en paramètre
     * @param vector
     * @return Vector2d issu du calcul
     */
    public Vector2d sum(Vector2d vector) {
        return new Vector2d(this.x + vector.x, this.y + vector.y);
    }

    /**
     * Méthode qui fait la différence du vecteur courant avec vecteur passé en paramètre
     * @param vector
     * @return Vector2d issu du calcul
     */
    public Vector2d diff(Vector2d vector) {
        return new Vector2d(this.x - vector.x, this.y - vector.y);
    }

    /**
     * Méthode qui fait le produit entre le vecteur avec le nombre passé en paramètre
     * @param amount
     * @return Vector2d issu du calcul
     */
    public Vector2d product(double amount) {
        return new Vector2d(x * amount, y * amount);
    }

    /**
     * Méthode qui vérifie si le vecteur courant est égal au vecteur passé en paramètre
     * @param vector
     * @return true si les vecteurs sont égaux, sinon false
     */
    public boolean equals(Vector2d vector) {
        return x == vector.x && y == vector.y;
    }

    @Override
    public String toString() {
        return "X: " + x + ", Y: " + y;
    }

}
