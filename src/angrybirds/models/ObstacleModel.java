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

    private int reverseTime;

    /**
     * Créé un nouvel objet
     *
     * @param startX,startY Obstacle's position
     */
    public ObstacleModel(double startX, double startY, Vector2d velocity) {
        super(new Vector2d(startX, startY), new Vector2d(20, 20), velocity, new Vector2d(0, 0));
        this.start = new Vector2d(startX,startY);
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        position = start;
        reverseTime = 500;
        velocity = new Vector2d(0, 0);
        acceleration = new Vector2d(0, 0);
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException {
        if(this.touchScreen() != null || this.touchObstacle() != null || reverseTime < 0){
            reverseObstacleAiming();
        }else{
            this.reverseTime -= delta;
            super.update(gameContainer,stateBasedGame,delta);
        }
    }

    /**
     * Need to get the coordonates of the perimeter of this obstacle +1
     *  Check if the coordonates are instanceof Obstacle
     *    If yes in updates reverserObstacleAiming
     *
     * NB : Obstacle can be a square or a circle
     * @return
     */
    public Vector2d touchObstacle(){
        int obstacleRadius = 1;
        if(this.getPosition().x == 0){
            // todo think miss a method to get the perimeter coordonates in graphicalObject
        }
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
        Vector2d velocityReverse = new Vector2d(velocity.x*-1,velocity.y*-1);
        velocity = velocityReverse;
    }
}
