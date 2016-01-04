package angrybirdsold.views;

import angrybirdsold.models.GameModel;
import angrybirdsold.models.ObstacleModel;
import angrybirdsold.structures.Constants;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import java.util.ArrayList;
import java.util.List;

/**
 * Cette classe représente la vue du jeu.
 *
 * @author Quentin Brault
 * @author Florent Marcaille
 * @author Maxime Catteau
 */
public class GameView implements View {

    /**
     * Modèle de jeu
     */
    private GameModel model;

    /**
     * Vue de l'oiseau
     */

    private BirdView bird;

    /**
     * Vue du lanceur
     */
    private SlingshotView slingshot;

    /**
     * liste d'obsatacles
     */
    private List<ObstacleView> obstacles;

    /**
     * crée un nouveau modèle de jeu
     * @param model Modèle du jeu
     */
    public GameView(GameModel model) {
        this.model = model;
        bird = new BirdView(model.getBird());
        slingshot = new SlingshotView(model.getSlingshot());
        obstacles = new ArrayList<>();
        for (ObstacleModel obstacle : model.getObstacles()) {
            obstacles.add(new ObstacleView(obstacle));
        }
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        bird.init(gameContainer, stateBasedGame);
        slingshot.init(gameContainer, stateBasedGame);
        for (ObstacleView obstacle : obstacles) {
            obstacle.init(gameContainer, stateBasedGame);
        }
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        bird.render(gameContainer, stateBasedGame, graphics);
        slingshot.render(gameContainer, stateBasedGame, graphics);
        for (ObstacleView obstacle : obstacles) {
            obstacle.render(gameContainer, stateBasedGame, graphics);
        }
        graphics.setColor(Color.green);
        graphics.fillRect(0, Constants.SCREEN_HEIGHT - Constants.GROUND_HEIGHT, Constants.SCREEN_WIDTH, Constants.GROUND_HEIGHT);
    }

}
