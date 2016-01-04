package angrybirds2;

import angrybirds2.controllers.Controller;
import angrybirds2.controllers.GameController;
import angrybirds2.controllers.LevelController;
import angrybirds2.controllers.SlingshotController;
import angrybirds2.controllers.objects.birds.BirdController;
import angrybirds2.datamodels.GameDataModel;
import angrybirds2.datamodels.LevelDataModel;
import angrybirds2.datamodels.SlingshotDataModel;
import angrybirds2.datamodels.objects.PigDataModel;
import angrybirds2.datamodels.objects.birds.BirdDataModel;
import angrybirds2.datamodels.objects.birds.RedBirdDataModel;
import angrybirds2.datamodels.objects.birds.YellowBirdDataModel;
import angrybirds2.datamodels.objects.obstacles.ObstacleDataModel;
import angrybirds2.models.GameModel;
import angrybirds2.models.LevelModel;
import angrybirds2.models.SlingshotModel;
import angrybirds2.models.objects.birds.RedBirdModel;
import angrybirds2.models.objects.birds.YellowBirdModel;
import angrybirds2.utils.Constants;
import angrybirds2.utils.Vector2d;
import angrybirds2.views.abstracts.GameView;
import angrybirds2.views.abstracts.LevelView;
import angrybirds2.views.abstracts.SlingshotView;
import angrybirds2.views.abstracts.objects.birds.RedBirdView;
import angrybirds2.views.abstracts.objects.birds.YellowBirdView;
import angrybirds2.views.slick2d.Slick2dGameView;
import angrybirds2.views.slick2d.Slick2dLevelView;
import angrybirds2.views.slick2d.Slick2dSlingshotView;
import angrybirds2.views.slick2d.objects.birds.Slick2dRedBirdView;
import angrybirds2.views.slick2d.objects.birds.Slick2dYellowBirdView;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO: Description
 *
 * @author Quentin Brault
 */
public class Window extends StateBasedGame {

    private static final Window window = new Window();

    private final List<Controller> controllers = new ArrayList<>();

    public Window() {
        super("Angry Birds");

        RedBirdDataModel redBirdDataModel = new RedBirdDataModel(new Vector2d(100));
        RedBirdModel redBirdModel = new RedBirdModel(redBirdDataModel);
        RedBirdView redBirdView = new Slick2dRedBirdView(redBirdDataModel);
        BirdController redBirdController = new BirdController(redBirdModel, redBirdView);
        redBirdView.addObserver(redBirdController);

        YellowBirdDataModel yellowBirdDataModel = new YellowBirdDataModel(new Vector2d(200));
        YellowBirdModel yellowBirdModel = new YellowBirdModel(yellowBirdDataModel);
        YellowBirdView yellowBirdView = new Slick2dYellowBirdView(yellowBirdDataModel);
        BirdController yellowBirdController = new BirdController(yellowBirdModel, yellowBirdView);
        yellowBirdView.addObserver(yellowBirdController);

        List<BirdDataModel> birds = new ArrayList<>();
        birds.add(redBirdDataModel);
        birds.add(yellowBirdDataModel);

        SlingshotDataModel slingshotDataModel = new SlingshotDataModel(new Vector2d(100, 300), new Vector2d(100, 200), new Vector2d(50, 0), 50);
        SlingshotModel slingshotModel = new SlingshotModel(slingshotDataModel);
        SlingshotView slingshotView = new Slick2dSlingshotView(slingshotDataModel);
        SlingshotController slingshotController = new SlingshotController(slingshotModel, slingshotView);
        slingshotView.addObserver(slingshotController);

        List<PigDataModel> pigs = new ArrayList<>();
        List<ObstacleDataModel> obstacles = new ArrayList<>();

        LevelDataModel levelDataModel = new LevelDataModel(birds, slingshotDataModel, pigs, obstacles);
        LevelModel levelModel = new LevelModel(levelDataModel);
        LevelView levelView = new Slick2dLevelView(levelDataModel);
        LevelController levelController = new LevelController(levelModel, levelView);
        levelView.addObserver(levelController);
        levelModel.readyNextBird();

        List<LevelDataModel> levels = new ArrayList<>();
        levels.add(levelDataModel);

        GameDataModel gameDataModel = new GameDataModel(levels);
        GameModel gameModel = new GameModel(gameDataModel);
        GameView gameView = new Slick2dGameView(gameDataModel);
        GameController gameController = new GameController(gameModel, gameView);
        gameView.addObserver(gameController);

        controllers.add(gameController);
        controllers.add(levelController);
        controllers.add(slingshotController);
        controllers.add(redBirdController);
        controllers.add(yellowBirdController);
    }

    public static void main(String[] args) {
        try {
            AppGameContainer app = new AppGameContainer(window);
            app.setDisplayMode(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT, false);
            app.setAlwaysRender(true);
            app.setTargetFrameRate(60);
            app.setMaximumLogicUpdateInterval(10);
            app.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initStatesList(GameContainer gameContainer) throws SlickException {
        addState(new BasicGameState() {

            @Override
            public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
            }

            @Override
            public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException {
                for (Controller controller : controllers)
                    controller.update(delta);
            }

            @Override
            public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
                for (Controller controller : controllers)
                    controller.display();
            }

            @Override
            public int getID() {
                return 0;
            }

        });
    }

    public static Window getInstance() {
        return window;
    }

}
