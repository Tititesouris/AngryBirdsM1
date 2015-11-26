package angrybirds.graphics.objects;

import angrybirds.graphics.VectorObject;
import angrybirds.structures.Vector2d;

/**
 * Created by Florent on 26/11/2015.
 */
public class PlateformeObject extends Obstacle {

    // zone d'arrivée
    Vector2d target;
    private int radiusTarget = 10;

    // zone de depart
    Vector2d departure;
    private int radiusDeparture = 10;

    private Vector2d velocity;

    private int radius ;

    public PlateformeObject(Vector2d position, Vector2d velocity, Vector2d target,int radius){
        super(position, radius);
        this.departure = position;
        this.target = target;
        this.velocity = velocity;
        this.radius = radius;
    }

    /**
     * Vecteur normalisée, copier fonction normalize pour pouvoir appliquer velocity sur le vecteur de
     * deplacement
     * NB : penser au cas où la velocity est elevée de checker les radius à augmenter pour eviter un depassement
     *      en 1 calcul de l'aobstacle par rapport a son target
     * NB 2 : delta a aligner sur la velocity
     */
    public void deplacer(Vector2d position){

    }

    public boolean targetReached(){
        double targetY;
        double targetX;
        double obstacleX = this.getPosition().x;
        double obstacleY = this.getPosition().y;
        double x;
        double y;
        double hypo;

        targetX = target.x;
        targetY = target.y;

        x = targetX - obstacleX;
        y = targetY - obstacleY;

        hypo = Math.sqrt((x * x) + (y * y));

        if (hypo <= this.radius + this.radiusTarget) {
            return true;
        }
        return false;
    }

    /**
     * Si l'obstacle arrive dans la zone de depart ou la zone d arrivée il doit repartir dans l'autre
     * sens et vice versa
     */
    public void allerRetour(){

    }
}
