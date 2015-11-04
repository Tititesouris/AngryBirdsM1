package angrybirds.structures;

/**
 * Created by Quentin Brault on 25/09/2015.
 */
public class Vector2d {

    /**
     * Variables qui stockant les coordonn�es des objets
     */
    public double x, y;

    /**
     * Cr�ation d'un vecteur de coordonn�es pass�s en param�tres
     * @param x
     * @param y
     */
    public Vector2d(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * M�thode qui ajoute le vecteur courant au vecteur pass� en param�tre
     * @param vector
     * @return Vector2d issu du calcul
     */
    public Vector2d add(Vector2d vector) {
        return new Vector2d(x + vector.x, y + vector.y);
    }

    /**
     * M�thode qui fait la diff�rence du vecteur courant avec vecteur pass� en param�tre
     * @param vector
     * @return Vector2d issu du calcul
     */
    public Vector2d diff(Vector2d vector) {
        return new Vector2d(this.x - vector.x, this.y - vector.y);
    }

    /**
     * M�thode qui fait le produit entre le vecteur avec le nombre pass� en param�tre
     * @param amount
     * @return Vector2d issu du calcul
     */
    public Vector2d product(double amount) {
        return new Vector2d(x * amount, y * amount);
    }

    public double getHypotenuse() {
        return Math.sqrt(x*x + y*y);
    }

    public Vector2d normalize() {
        double hypotenuse = getHypotenuse();
        return new Vector2d(x / hypotenuse, y / hypotenuse);
    }

    public boolean equals(Vector2d vector) {
        return x == vector.x && y == vector.y;
    }

    @Override
    public String toString() {
        return "X: " + x + ", Y: " + y;
    }

}
