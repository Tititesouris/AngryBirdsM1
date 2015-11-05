package angrybirds.parametrics;

import angrybirds.structures.Vector2d;

/**
 * Cette classe abstraite représente une courbe paramétrique.
 *
 * @author Quentin Brault
 */
public abstract class Parametric {

    /**
     * Offset de la courbe
     */
    protected Vector2d offset;

    /**
     * Créé une nouvelle courbe
     *
     * @param offset    Offset de la courbe
     */
    public Parametric(Vector2d offset) {
        this.offset = offset;
    }

    /**
     * Cette méthode retourne la valeur de la courbe à l'instant t
     *
     * @param t     Instant de la courbe
     * @return      Valeur à l'instant t
     */
    public abstract Vector2d getValue(double t);

    /**
     * Cette méthode retourne le vecteur tangeante à la courbe à l'instant t
     */
    public Vector2d getTangent(double t) {
        Vector2d a = getValue(t + 0.001);
        Vector2d b = getValue(t);
        return new Vector2d((a.x - b.x) / 0.001, (a.y - b.y) / 0.001);
    }

    @Override
    public abstract String toString();

}
