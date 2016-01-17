package angrybirds.models.objects;

import angrybirds.models.LevelModel;
import angrybirds.utils.Vector2d;

import java.util.ArrayList;
import java.util.Vector;

/**
 * TODO: Description
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

            float distX = corner1.x - this.getPosition().x;
            float distY = corner1.y - this.getPosition().y;
            float closeCornerX = corner1.x;
            float closeCornerY = corner1.y;

            for(int i=0;i<rectangularCorners.size();i++){
                float distanceX = rectangularCorners.get(i).x - this.getPosition().x;
                float distanceY = rectangularCorners.get(i).y - this.getPosition().y;

                if(distanceX < 0){
                    distanceX = distanceX * -1;
                }
                if(distanceY < 0){
                    distanceY = distanceY * -1;
                }

                if(distanceX <= distX){
                    distX = rectangularCorners.get(i).x - this.getPosition().x;
                    closeCornerX = rectangularCorners.get(i).x;
                }
                if(distanceY >= distY){
                    distY = rectangularCorners.get(i).y - this.getPosition().y;
                    closeCornerY = rectangularCorners.get(i).y;
                }
            }

            float secondDistX = corner2.x - this.getPosition().x;
            float secondDistY = corner2.y - this.getPosition().y;
            float secondCloseCornerX = corner2.x;
            float secondCloseCornerY = corner2.y;

            //search the 2nd closest corner
            for(int i=0;i<rectangularCorners.size();i++){
                float secondDistanceX = rectangularCorners.get(i).x - this.getPosition().x;
                float secondDistanceY = rectangularCorners.get(i).y - this.getPosition().y;

                if(secondDistanceX < 0){
                    secondDistanceX = secondDistanceX * -1;
                }
                if(secondDistanceY < 0){
                    secondDistanceY = secondDistanceY * -1;
                }

                if(secondDistanceX <= secondDistX && secondDistanceX > distX){
                    secondDistX = rectangularCorners.get(i).x - this.getPosition().x;
                    secondCloseCornerX = rectangularCorners.get(i).x;
                }
                if(secondDistanceY >= secondDistY && secondDistanceY > distY){
                    secondDistY = rectangularCorners.get(i).y - this.getPosition().y;
                    secondCloseCornerY = rectangularCorners.get(i).y;
                }
            }

            float thirdDistX = corner3.x - this.getPosition().x;
            float thirdDistY = corner3.y - this.getPosition().y;
            float thirdCloseCornerX = corner3.x;
            float thirdCloseCornerY = corner3.y;

            //search the 3rd closest corner
            for(int i=0;i<rectangularCorners.size();i++){
                float thirdDistanceX = rectangularCorners.get(i).x - this.getPosition().x;
                float thirdDistanceY = rectangularCorners.get(i).y - this.getPosition().y;

                if(thirdDistanceX < 0){
                    thirdDistanceX = thirdDistanceX * -1;
                }
                if(thirdDistanceY < 0){
                    thirdDistanceY = thirdDistanceY * -1;
                }

                if(thirdDistanceX <= thirdDistX && thirdDistanceX > distX && thirdDistanceX > secondDistX){
                    thirdDistX = rectangularCorners.get(i).x - this.getPosition().x;
                    thirdCloseCornerX = rectangularCorners.get(i).x;
                }
                if(thirdDistanceY >= thirdDistY && thirdDistanceY > distY && thirdDistanceY > secondDistY){
                    thirdDistY = rectangularCorners.get(i).y - this.getPosition().y;
                    thirdCloseCornerY = rectangularCorners.get(i).y;
                }
            }


            // reduction des tailles des vecteurs pour que les distances influent moins
            // et donc recuperer le cote ou l oiseau est sense toucher
            Vector2d closeCorner = new Vector2d(closeCornerX,closeCornerY);
            Vector2d secondCloseCorner = new Vector2d(secondCloseCornerX,secondCloseCornerY);
            Vector2d thirdCloseCorner = new Vector2d(thirdCloseCornerX,thirdCloseCornerY);

            Vector2d middleFirstSecond = closeCorner;
            middleFirstSecond.sum(secondCloseCorner);
            middleFirstSecond.product(0.5f);

            Vector2d middleFirstThird = closeCorner;
            middleFirstThird.sum(thirdCloseCorner);
            middleFirstThird.product(0.5f);

            Vector2d firstSecondDist = middleFirstSecond.sum(this.getPosition());
            Vector2d firstThirdDist = middleFirstThird.sum(this.getPosition());

            float distMaxFirstSecond = firstSecondDist.x + firstSecondDist.y;
            float distMaxFirstThird = firstThirdDist.x + firstThirdDist.y;

            Vector2d secondTrianglePoint;

            if(distMaxFirstSecond < distMaxFirstThird){
                secondTrianglePoint = secondCloseCorner;
            }else{
                secondTrianglePoint = thirdCloseCorner;
            }

            // calcul de la hauteur du triangle
            float distCircularSecondTriangle = (float)Math.sqrt((double)((this.getPosition().x-secondTrianglePoint.x)*(this.getPosition().x-secondTrianglePoint.x)+(this.getPosition().y-secondTrianglePoint.y)*(this.getPosition().y-secondTrianglePoint.y)));
            float distCircularFirstTriangle = (float)Math.sqrt((double)((this.getPosition().x-closeCorner.x)*(this.getPosition().x-closeCorner.x)+(this.getPosition().y-closeCorner.y)*(this.getPosition().y-closeCorner.y)));
            float distFirstSecondTriangle = (float)Math.sqrt((double)((closeCorner.x-secondTrianglePoint.x)*(closeCorner.x-secondTrianglePoint.x)+(closeCorner.y-secondTrianglePoint.y)*(closeCorner.y-secondTrianglePoint.y)));

            ArrayList<Float> distTriangle = new ArrayList<>();

            distTriangle.add(distFirstSecondTriangle);
            distTriangle.add(distCircularSecondTriangle);
            distTriangle.add(distCircularFirstTriangle);

            float min = distCircularSecondTriangle;
            float base = distFirstSecondTriangle;
            float max = distCircularSecondTriangle;

            for(int i=0;i<distTriangle.size();i++){
                if(distTriangle.get(i) > max){
                    max = distTriangle.get(i);
                }
                if(distTriangle.get(i) < min){
                    min = distTriangle.get(i);
                }
            }

            float hauteur = (float)Math.sqrt(max*max - (((base*base - min*min + max*max)/2*base)*(base*base - min*min + max*max)/2*base));

            if((hauteur - (this.getSize().product(0.5f).x) ) <= 0){
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
