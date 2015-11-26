package angrybirds.views;

import angrybirds.models.GameModel;
import angrybirds.models.ObstacleModel;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import java.util.ArrayList;
import java.util.List;

/**
 * Cette classe représente le jeu.
 *
 * @author Quentin Brault
 * @author Florent Marcaille
 * @author Maxime Catteau
 */
public class GameView implements View {

    private GameModel model;

    private BirdView bird;

    private List<ObstacleView> obstacles;

    public GameView(GameModel model) {
        this.model = model;
        bird = new BirdView(model.getBird());
        obstacles = new ArrayList<>();
        for (ObstacleModel obstacle : model.getObstacles()) {
            obstacles.add(new ObstacleView(obstacle));
        }
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        bird.init(gameContainer, stateBasedGame);
        for (ObstacleView obstacle : obstacles) {
            obstacle.init(gameContainer, stateBasedGame);
        }
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        bird.render(gameContainer, stateBasedGame, graphics);
        for (ObstacleView obstacle : obstacles) {
            obstacle.render(gameContainer, stateBasedGame, graphics);
        }
    }

}
