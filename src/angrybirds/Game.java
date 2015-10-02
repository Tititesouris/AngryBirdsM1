package angrybirds;

import angrybirds.graphics.objects.Bird;
import angrybirds.graphics.objects.Obstacle;
import angrybirds.structures.Vector2d;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Created by Quentin Brault on 24/09/2015.
 */
public class Game extends BasicGameState {

    private Bird bird;

    private Obstacle obstacle;

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        bird = new Bird(new Vector2d(0, 100));
        bird.init(gameContainer, stateBasedGame);
        obstacle = new Obstacle(new Vector2d(50, 50));
        obstacle.init(gameContainer, stateBasedGame);
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException {
        bird.update(gameContainer, stateBasedGame, delta);
        obstacle.update(gameContainer, stateBasedGame, delta);
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        graphics.drawString("Hello World!", 50, 50);
        bird.render(gameContainer, stateBasedGame, graphics);
        obstacle.render(gameContainer, stateBasedGame, graphics);
    }

    @Override
    public int getID() {
        return 0;
    }

}
