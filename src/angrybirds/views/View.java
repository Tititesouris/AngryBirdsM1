package angrybirds.views;

import angrybirds.controllers.GameController;
import angrybirds.utils.Constants;
import angrybirds.utils.ModelViewPair;
import angrybirds.notifications.inputs.InputObservable;
import angrybirds.notifications.updates.UpdateObserver;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Transform;

/**
 * Cette classe représente une vue.
 * Une vue possède un identifiant qui correspond à l'identifiant unique du modèle auquel elle correspond.
 * Cela permet d'échanger des informations à propos d'un modèle précis via les InputAction.
 *
 * @author Quentin Brault
 * @since  2013/10/01
 */
public abstract class View extends InputObservable implements UpdateObserver {

    /**
     * Fenêtre de jeu du framework Slick2d.
     */
    private static AppGameContainer app;

    /**
     * Identifiant du modèle auquel correspond cette vue.
     */
    protected final int id;

    /**
     * Créé une vue.
     *
     * @param id Identifiant du modèle auquel correspond cette vue.
     */
    public View(int id) {
        this.id = id;
    }

    /**
     * Cette méthode est appelée une seule fois, juste après la création du contexte graphique par le framework Slick2d.
     * C'est dans cette méthode que l'on met l'initialisation de champs qui dépendent du contexte graphique.
     * Par exemple, c'est dans cette méthode que l'on mettra le chargement des images.
     */
    public abstract void init();

    /**
     * Cette méthode est appellée à chaque tick du jeu.
     * Elle doit être implémentée pour effectuer des opérations basées sur des inputs.
     *
     * @param input Input reçu sur la fenêtre de jeu.
     */
    public abstract void input(Input input);

    /**
     * Cette méthode est appellée à chaque tick du jeu.
     * Elle doit être implémentée pour afficher des éléments à l'écran.
     *
     * @param graphics Contexte graphique de la fenêtre de jeu.
     */
    public abstract void display(Graphics graphics);

    /**
     * Cette méthode utilitaire retourne la version tournée d'une forme.
     *
     * @param shape   Forme à tourner.
     * @param angle   Angle de rotation.
     * @param xOffset Offset X du centre de rotation.
     * @param yOffset Offset Y du centre de rotation.
     * @return Nouvelle forme tournée.
     */
    protected Shape getRotated(Shape shape, float angle, float xOffset, float yOffset) {
        return shape.transform(Transform.createRotateTransform(angle, shape.getCenterX() + xOffset, shape.getCenterY() + yOffset));
    }

    /**
     * Retourne l'identifiant du modèle auquel correspond cette vue.
     *
     * @return Identifiant du modèle auquel correspond cette vue.
     */
    public int getId() {
        return id;
    }

    /**
     * Cette méthode créée une fenêtre du framekwork Slick2d.
     * Cette méthode est le point de relais entre le framework utilisé et le jeu.
     * Comme le framework ne permet pas une approche MVC directe, les différentes méthodes du framework sont redirigées vers la partie du MVC qui leur est appropriée.
     *
     * @param gameController Controlleur du jeu pour lequel créer une fenêtre et relayer les appels de méthodes.
     */
    public static void setupSlick2d(GameController gameController) {
        if (app == null) {
            System.out.println("Creating window");
            try {
                app = new AppGameContainer(new BasicGame("Angry Birds!") {
                    @Override
                    public void init(GameContainer gameContainer) throws SlickException {
                        for (ModelViewPair modelViewPair : gameController.getModelViewPairs()) {
                            modelViewPair.view.init();
                        }
                    }

                    @Override
                    public void update(GameContainer gameContainer, int delta) throws SlickException {
                        for (ModelViewPair modelViewPair : gameController.getModelViewPairs()) {
                            modelViewPair.model.update(delta);
                            modelViewPair.view.input(gameContainer.getInput());
                        }
                    }

                    @Override
                    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
                        for (ModelViewPair modelViewPair : gameController.getModelViewPairs()) {
                            modelViewPair.view.display(gameContainer.getGraphics());
                        }
                    }
                });
                app.setDisplayMode(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT, false);
                app.setAlwaysRender(Constants.DEBUG);
                app.setShowFPS(Constants.DEBUG);
                app.setMinimumLogicUpdateInterval(Constants.MIN_ENGINE_DELAY);
                app.setTargetFrameRate(Constants.FPS);
            } catch (SlickException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Cette méthode lance la fenêtre de jeu du framework Slick2d.
     */
    public static void start() {
        try {
            app.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

}
