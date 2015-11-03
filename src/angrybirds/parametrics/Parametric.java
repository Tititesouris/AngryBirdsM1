package angrybirds.parametrics;

import angrybirds.structures.Vector2d;

/**
 * Created by Quentin Brault on 02/10/2015.
 */
/**
 * Cette classe abstraite permet de creer des courbes parametriques
 * telles que des sinusoidales, des lineaires, des courbes de bezier ...
 * @author Maxime Catteau
 *
 */
public abstract class Parametric {

    protected Vector2d offset;

    public Parametric(Vector2d offset) {
        this.offset = offset;
    }

    /**
     * Cette m�thode permet de recup�rer la valeur du ratio t permettant
     * d'�viter les probl�mes de latences selon le PC des utilisateurs
     * @param t
     * @return
     */
    
    public abstract Vector2d getValue(double t);

    /**
     * Cette m�thode permet de r�cup�rer les coordonn�es de la tangente
     * ce qui nous permettra plus tard de dessiner la trajectoire de
     * l'oiseau
     * @param t
     * @return
     */
    public Vector2d getTangent(double t) {
        Vector2d a = getValue(t + 0.001);
        Vector2d b = getValue(t);
        return new Vector2d((a.x - b.x) / 0.001, (a.y - b.y) / 0.001);
    }

    @Override
    public abstract String toString();

}
