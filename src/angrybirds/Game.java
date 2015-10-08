package angrybirds;

import angrybirds.graphics.objects.Bird;
import angrybirds.graphics.objects.Obstacle;
import angrybirds.structures.Vector2d;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Quentin Brault on 24/09/2015.
 */
public class Game extends BasicGameState {

    private static final Random rand = new Random();

    private Bird bird;

    private List<Obstacle> obstacles;

    public Game() {
        bird = new Bird(new Vector2d(0, 100));
        obstacles = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            obstacles.add(new Obstacle(new Vector2d(900, 100 + i * 150), 25 + rand.nextInt(50)));
        }
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        bird.init(gameContainer, stateBasedGame);
        for (Obstacle obstacle : obstacles) {
            obstacle.init(gameContainer, stateBasedGame);
        }
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException {
        bird.update(gameContainer, stateBasedGame, delta);
        for (Obstacle obstacle : obstacles) {
            obstacle.update(gameContainer, stateBasedGame, delta);
        }
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        bird.render(gameContainer, stateBasedGame, graphics);
        for (Obstacle obstacle : obstacles) {
            obstacle.render(gameContainer, stateBasedGame, graphics);
        }
    }

    @Override
    public int getID() {
        return 0;
    }

}
