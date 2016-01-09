package angrybirds.views;

import angrybirds.controllers.Controller;
import angrybirds.controllers.GameController;
import angrybirds.models.Model;
import angrybirds.utils.Constants;
import angrybirds.utils.ModelViewPair;
import angrybirds.inputs.InputObservable;
import angrybirds.updates.UpdateObserver;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Transform;

/**
 * TODO: Description
 *
 * @author Tititesouris
 */
public abstract class View extends InputObservable implements UpdateObserver {

    public static AppGameContainer app;

    public static void setupSlick2d(Controller controller) {
        if (app == null) {
            System.out.println("Creating window");
            try {
                app = new AppGameContainer(new BasicGame("Angry Birds!") {
                    @Override
                    public void init(GameContainer gameContainer) throws SlickException {
                    }

                    @Override
                    public void update(GameContainer gameContainer, int delta) throws SlickException {
                        for (ModelViewPair modelViewPair : controller.getModelViewPairs()) {
                            modelViewPair.model.update(delta);
                            modelViewPair.view.input(gameContainer.getInput());
                        }
                    }

                    @Override
                    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
                        for (ModelViewPair modelViewPair : controller.getModelViewPairs()) {
                            modelViewPair.view.display(gameContainer.getGraphics());
                        }
                    }
                });
                app.setDisplayMode(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT, false);
                app.setAlwaysRender(Constants.DEBUG);
                app.setShowFPS(Constants.DEBUG);
                app.setMaximumLogicUpdateInterval(10);
                app.setTargetFrameRate(60);
            } catch (SlickException e) {
                e.printStackTrace();
            }
        }
    }

    public abstract void init(Model model);

    public abstract void input(Input input);

    public abstract void display(Graphics graphics);

    protected Shape getRotated(Shape shape, float angle, float xOffset, float yOffset) {
        return shape.transform(Transform.createRotateTransform(angle, shape.getX() + xOffset, shape.getY() + yOffset));
    }

}
