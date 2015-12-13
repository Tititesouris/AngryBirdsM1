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
 * Cette classe représente le jeu
 * @author Quentin Brault, Marcaille Florent
 */
public class GameModel implements Model {

    /**
     * Générateur de nombre aléatoire.
     */
    private static final Random rand = new Random();

    /**
     * L'oiseau
     */
    private BirdModel bird;

    /**
     * Le lanceur
     */
    private SlingshotModel slingshot;

    /**
     * Les obstacles
     */

    private List<ObstacleModel> obstacles;


    /**
     * Créé les objects du jeu.
     */
    public GameModel() {
        bird = new BirdModel(150, 500);
        slingshot = new SlingshotModel(bird, 150);
        obstacles = new ArrayList<>();

        obstacles.add(new CircularObstacleModel(new Vector2d(700, 500), new Vector2d(30, 30), new Vector2d(0.1,0.2), 600));
        obstacles.add(new CircularObstacleModel(new Vector2d(500, 300), new Vector2d(30, 30), new Vector2d(0.5,0.1), 1000));
        obstacles.add(new CircularObstacleModel(new Vector2d(800, 200), new Vector2d(30, 30), new Vector2d(0.3,0.7), 800));
        obstacles.add(new RectangularObstacleModel(new Vector2d(550, 300), new Vector2d(20, 100), new Vector2d(0.05,0.4), 1200));
        obstacles.add(new RectangularObstacleModel(new Vector2d(1000,100), new Vector2d(75, 30), new Vector2d(0.8,0.2), 750));

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
        if (!bird.isHit()) {
            for (ObstacleModel obstacle : obstacles) {
                obstacle.update(gameContainer, stateBasedGame, delta);
                ObstacleModel touched = getTouchedObstacle();
                if (touched != null) {
                    touched.setHit(true);
                    bird.hit();
                }
            }
            if (isOutOfBounds(bird)) {
                slingshot.init(gameContainer, stateBasedGame);
                bird.hit();
            }
        }
    }

    /**
     * Retourne l'oiseau
     * @return bird
     */
    public BirdModel getBird() {
        return bird;
    }

    /**
     * retourne une liste d'obstacles
     * @return une liste d'obstacles
     */
    public List<ObstacleModel> getObstacles() {
        return obstacles;
    }

    /**
     * Determine si un objet est en dehors de l'écran
     * @param object    Objet à vérifier
     * @return true si l'objet est en dehors de l'ecran
     */
    public boolean isOutOfBounds(GraphicalObjectModel object) {
        return object.getPosition().x < 0
                || object.getPosition().y < 0
                || object.getPosition().x + object.size.x > Constants.SCREEN_WIDTH
                || object.getPosition().y + object.size.y > Constants.SCREEN_HEIGHT - Constants.GROUND_HEIGHT;
    }

    /**
     * Determine la collision entre l'oiseau et un obstacle
     * @return L'obstacle avec lequel l'oiseau est entré en collision, ou null si aucun
     */
    public ObstacleModel getTouchedObstacle() {
        for (ObstacleModel obstacle : obstacles) {
            if (obstacle.touchesBird(bird))
                return obstacle;
        }
        return null;
    }

    /**
     * Retourne le lanceur
     * @return le lanceur
     */
    public SlingshotModel getSlingshot() {
        return slingshot;
    }
}
