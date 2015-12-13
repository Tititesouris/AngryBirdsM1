package angrybirds.models;

import angrybirds.structures.Vector2d;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import java.util.Vector;

/**
 * TODO: Description
 *
 * @author User
 */
public class ObstacleModel extends VectorObjectModel {

    // departure zone
    private Vector2d start;
    private int startRadius;

    // target zone
    private Vector2d target;
    private int targetRadius;

    //private Vector2d velocity;
    //private Vector2d acceleration;

    /**
     * Créé un nouvel objet
     *
     * @param startX,startY Obstacle's position
     * @param targetX,targetY Direction of the obstacle
     * @param startRadius Radius of the departure zone
     * @param targetRadius Radius of the target zone
     */
    public ObstacleModel(double startX, double startY, Vector2d velocity) {
        super(new Vector2d(startX, startY), new Vector2d(20, 20), velocity, new Vector2d(0, 0));
        this.velocity = velocity;
        this.start = new Vector2d(startX,startY);
        //this.target = new Vector2d(targetX,targetY);
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        position = start;
        velocity = new Vector2d(0, 0);
        acceleration = new Vector2d(0, 0);
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException {
        if(this.touchScreen() != null || this.touchObstacle())




        if(this.touchScreen()==null){
            //super.update(gameContainer,stateBasedGame,delta);
        }else{
            reverseObstacleAiming();
        }
    }


    public Vector2d touchObstacle(){
        int obstacleRadius = 1;
        if(this.getPosition().)
        return null;
    }

    /**
     * Return null if the obstacle doesn't touch the border
     * If the obstacle is touching a border and doesn't reach his
     *   target zone, then redefine the target zone with the position
     *      where it touch the screen
     *
     * @return Vector2d position where obstacle touch the border
     */
    public Vector2d touchScreen(){
        if(this.isOutOfBounds()){
            this.target.x = this.getPosition().x;
            this.target.y = this.getPosition().y;

            return this.getPosition();
        }else{
            return null;
        }
    }

    /**
     * Swap the target with the start zone and inside out
     */
    public void reverseObstacleAiming(){
        Vector2d tempVect = this.start;
        this.start = this.target;
        this.target = tempVect;

        int tempRadius = this.startRadius;
        this.startRadius = this.targetRadius;
        this.targetRadius = tempRadius;
    }

    /**
     * Check if the obstacle has reach his going back area
     *
     * @return true when this reached target
     */
    public boolean targetReached(){
        double targetY = this.target.y;
        double targetX = this.target.x;

        double obstacleX = this.getPosition().x;
        double obstacleY = this.getPosition().y;

        double x = targetX - obstacleX;
        double y = targetY - obstacleY;

        double hypo = Math.sqrt((x * x) + (y * y));

        if (hypo <= this. + this.targetRadius) {
            return true;
        }
        return false;
    }

}
