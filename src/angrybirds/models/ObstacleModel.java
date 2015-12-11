package angrybirds.models;

import angrybirds.structures.Vector2d;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 * TODO: Description
 *
 * @author User
 */
public class ObstacleModel extends GraphicalObjectModel {

    // target zone
    private Vector2d target;
    private int targetRadius;

    // departure zone
    private Vector2d start;
    private int startRadius;

    /**
     * Créé un nouvel objet
     *
     * @param position Position de l'objet
     */
    public ObstacleModel(Vector2d position) {
        super(position, new Vector2d(25, 25));
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {

    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException {
        if(this.touchScreen()==null){
            //super.update(gameContainer,stateBasedGame,delta);
        }else{
            reverseObstacleAiming();
        }
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
