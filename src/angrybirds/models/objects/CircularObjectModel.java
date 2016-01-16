package angrybirds.models.objects;

import angrybirds.models.LevelModel;
import angrybirds.utils.Vector2d;

import java.util.ArrayList;
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

            Vector2d larg = new Vector2d(object.getPosition().x+largeur,object.getPosition().y);
            Vector2d largRotate = larg.product(object.getRotation());
            Vector2d middleX = new Vector2d(object.getPosition().x+largRotate.x,object.getPosition().y+largRotate.y);

            Vector2d longe = new Vector2d(object.getPosition().x,object.getPosition().y+longeur);
            Vector2d longeRotate = longe.product((float)(object.getRotation()+Math.PI/2));
            Vector2d middleY = new Vector2d(object.getPosition().x+longeRotate.x,object.getPosition().y+longeRotate.y);

            Vector2d negLarg = new Vector2d(object.getPosition().x - largeur,object.getPosition().y);
            Vector2d negLargRotate = negLarg.product((float)(object.getRotation()+Math.PI));
            Vector2d negMiddleX = new Vector2d(object.getPosition().x-negLargRotate.x,object.getPosition().y-negLargRotate.y);

            Vector2d negLonge = new Vector2d(object.getPosition().x,object.getPosition().y - longeur);
            Vector2d negLongeRotate = negLonge.product((float)(object.getRotation()-Math.PI/2));
            Vector2d negMiddleY = new Vector2d(object.getPosition().x-negLongeRotate.x,object.getPosition().y-negLongeRotate.y);

            Vector2d corner1 = new Vector2d(negMiddleX.x+longeRotate.x,negMiddleX.y+longeRotate.y); // coin supérieur gauche
            Vector2d corner2 = new Vector2d(middleY.x+largRotate.x,middleX.y+largRotate.y);   // coin superieur droit
            Vector2d corner3 = new Vector2d(negMiddleY.x+longeRotate.x,negMiddleY.y+longeRotate.y); // coin inferieur droit
            Vector2d corner4 = new Vector2d(negMiddleY.x+negLargRotate.x,negMiddleY.y+negLargRotate.y); // coin inferieur gauche

            // parcours des 4 corners et prendre les 2 plus prets pour faire calcul hauteur avec oiseau
            ArrayList<Vector2d> rectangularCorners = new ArrayList<>();

            rectangularCorners.add(corner1);
            rectangularCorners.add(corner2);
            rectangularCorners.add(corner3);
            rectangularCorners.add(corner4);

            float bestX = 0;
            float bestY = 0;

            for(int i=0;i<rectangularCorners.size();i++){
                if(rectangularCorners.get(i).x - this.getPosition().x >= bestX){
                    bestX = rectangularCorners.get(i).x;
                }
                if(rectangularCorners.get(i).y - this.getPosition().y >= bestY){
                    bestY = rectangularCorners.get(i).y;
                }
            }

            //System.out.println("X : "+bestX+" Y : "+bestY);

            Vector2d proxyCorner = new Vector2d(bestX,bestY);

            Vector2d hypo = new Vector2d(proxyCorner.x-this.getPosition().x,proxyCorner.y-this.getPosition().y);
            float hypotenuse = hypo.hypotenuse();

            if((hypotenuse - (this.getSize().product(0.5f).x) ) <= 0){
                System.out.print("Hit");
                return true;
            }else{
                return false;
            }
        }

       return false;
    }

    @Override
    public float getSurface() {
        return (float) (Math.PI * (size.x / 2) * (size.y / 2));
    }

}
