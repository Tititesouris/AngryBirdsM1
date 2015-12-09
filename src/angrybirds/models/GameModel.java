package angrybirds.models;

import angrybirds.structures.Constants;
import angrybirds.structures.Vector2d;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * TODO: Description
 *
 * @author Quentin Brault
 */
public class GameModel implements Model {

    private static final Random rand = new Random();

    private BirdModel bird;

    private SlingshotModel slingshot;

    private List<ObstacleModel> obstacles;

    public GameModel() {
        bird = new BirdModel(150, 500);
        slingshot = new SlingshotModel(bird);
        obstacles = new ArrayList<>();
        for (int i = 0; i < 5 + rand.nextInt(5); i++) {
            obstacles.add(new ObstacleModel(new Vector2d(50, 50)));
        }
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        bird.init(gameContainer, stateBasedGame);
        slingshot.init(gameContainer, stateBasedGame);
        for (ObstacleModel obstacle : obstacles) {
            obstacle.init(gameContainer, stateBasedGame);
        }
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException {
        bird.update(gameContainer, stateBasedGame, delta);
        slingshot.update(gameContainer, stateBasedGame, delta);
        for (ObstacleModel obstacle : obstacles) {
            obstacle.update(gameContainer, stateBasedGame, delta);
        }
    }

    public BirdModel getBird() {
        return bird;
    }

    public List<ObstacleModel> getObstacles() {
        return obstacles;
    }


    /**
     * Determine la collision entre l'oiseau et l'obstacle
     * Calcul de la collision par le rapport à la distance entre l'hypothénuse des centres de l'oiseau et des obstacles et leurs rayons
     *
     * @return L'obstacle avec lequel l'oiseau est entré en collision, ou null si aucun
     */
    public ObstacleModel getTouchedObstacle(){
        double obstacleY;
        double obstacleX;
        double birdX = this.bird.getPosition().x;
        double birdY = this.bird.getPosition().y;
        double x;
        double y;
        double hypo;

        for(ObstacleModel obstacle : obstacles){
            obstacleX = obstacle.getPosition().x;
            obstacleY = obstacle.getPosition().y;

            x = obstacleX - birdX;
            y = obstacleY - birdY;

            hypo = Math.sqrt((x*x) + (y*y));

            if(hypo <= this.bird.getSize().x + obstacle.getSize().x) {
                return obstacle;
            }
        }
        return null;
    }

    public SlingshotModel getSlingshot() {
        return slingshot;
    }
}
