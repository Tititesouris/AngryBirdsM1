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
 * TODO: Description
 *
 * @author Tititesouris
 */
public abstract class View extends InputObservable implements UpdateObserver {

    public static AppGameContainer app;

    protected final int id;

    public View(int id) {
        this.id = id;
    }

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
                app.setTargetFrameRate(60);
            } catch (SlickException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Cette méthode est appelée une seule fois, juste après la création du contexte graphique.
     * C'est dans cette méthode que l'on met l'initialisation de champs qui dépendent du contexte graphique.
     * Par exemple, c'est dans cette méthode que l'on mettra le chargement des images.
     */
    public abstract void init();

    public abstract void input(Input input);

    public abstract void display(Graphics graphics);

    protected Shape getRotated(Shape shape, float angle, float xOffset, float yOffset) {
        return shape.transform(Transform.createRotateTransform(angle, shape.getCenterX() + xOffset, shape.getCenterY() + yOffset));
    }

    public int getId() {
        return id;
    }

}
