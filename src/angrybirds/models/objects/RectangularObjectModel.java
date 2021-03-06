package angrybirds.models.objects;

import angrybirds.models.LevelModel;
import angrybirds.utils.Vector2d;

/**
 * Cette classe représente les données et actions d'un objet rectangulaire.
 *
 * @author Quentin Brault
 * @since 2016/01/10
 */
public abstract class RectangularObjectModel extends ObjectModel {

    /**
     * Créé un nouvel objet rectangulaire.
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
    public RectangularObjectModel(LevelModel level, Vector2d position, Vector2d velocity, Vector2d acceleration, Vector2d size, float density, float rotation, float angularSpeed, boolean gravity) {
        super(level, position, velocity, acceleration, size, density, rotation, angularSpeed, gravity);
    }

    @Override
    public boolean collidesWith(ObjectModel object) {
        return !(position.x - size.x / 2 >= object.position.x + object.size.x / 2 ||
                position.y - size.y / 2 >= object.position.y + object.size.y / 2 ||
                position.x + size.x / 2 <= object.position.x - object.size.x / 2 ||
                position.y + size.y / 2 <= object.position.y - object.size.y / 2);
    }

    @Override
    public float getSurface() {
        return size.x * size.y;
    }

}
