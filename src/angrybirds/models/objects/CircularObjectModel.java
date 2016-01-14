package angrybirds.models.objects;

import angrybirds.models.LevelModel;
import angrybirds.utils.Vector2d;

import java.util.Vector;

/**
 * Cette classe représente les données et actions d'un objet rectangulaire.
 *
 * @author Quentin Brault
 * @since 2016/01/10
 */
public abstract class CircularObjectModel extends ObjectModel {

    /**
     * Créé un nouvel objet circulaire.
     *
     * @param level        Modèle du niveau.
     * @param position     Position du centre de l'objet en m.
     * @param velocity     Vélocité de l'objet en m/s.
     * @param acceleration Accélération de l'objet en m/s^2.
     * @param size         Taille de l'objet en m.
     * @param density      Densité (ou masse surfacique) de l'objet en kg/m^2.
     * @param rotation     Rotation de l'objet en radians par rapport au 0 du cercle trigonométrique.
     * @param angularSpeed Vitesse de rotation de l'objet en rad/s
     * @param gravity      True si l'objet est soumis à la pesanteur, false sinon.
     */
    public CircularObjectModel(LevelModel level, Vector2d position, Vector2d velocity, Vector2d acceleration, Vector2d size, float density, float rotation, float angularSpeed, boolean gravity) {
        super(level, position, velocity, acceleration, size, density, rotation, angularSpeed, gravity);
    }


    @Override
    public boolean collidesWith(ObjectModel object) {
        if(object instanceof CircularObjectModel){
            Vector2d hypo = new Vector2d(object.getPosition().x-this.getPosition().x,object.getPosition().y-this.getPosition().y);
            float hypotenuse = hypo.hypotenuse();

            if((hypotenuse - ((this.getSize().product(0.5f).x) + (object.getSize().product(0.5f).x))) <= 0){
                return true;
            }else{
                return false;
            }
        }else if(object instanceof RectangularObjectModel){
            float largeur = object.getSize().x/2;
            float longeur = object.getSize().y/2;



        }

       return false;
    }

    @Override
    public float getSurface() {
        return (float) (Math.PI * (size.x / 2) * (size.y / 2));
    }

}
