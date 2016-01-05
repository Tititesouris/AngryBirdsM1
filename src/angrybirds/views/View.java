package angrybirds.views;

import angrybirds.controllers.Controller;
import angrybirds.models.Model;
import angrybirds.utils.Constants;
import angrybirds.utils.ModelViewPair;
import angrybirds.utils.inputs.InputObservable;
import angrybirds.utils.updates.UpdateObserver;
import org.newdawn.slick.*;

/**
 * TODO: Description
 *
 * @author Tititesouris
 */
public abstract class View extends InputObservable implements UpdateObserver {

    public static AppGameContainer app;

    public View() {
        setupSlick2d();
    }

    private static void setupSlick2d() {
        if (app == null) {
            System.out.println("Creating window");
            try {
                app = new AppGameContainer(new BasicGame("Angry Birds!") {
                    @Override
                    public void init(GameContainer gameContainer) throws SlickException {
                        for (Controller controller : Controller.getControllers()) {
                            for (ModelViewPair modelViewPair : controller.getModelViewPairs()) {
                                modelViewPair.model.init();
                                modelViewPair.view.init(modelViewPair.model);
                            }
                            controller.init();
                        }
                    }

                    @Override
                    public void update(GameContainer gameContainer, int delta) throws SlickException {
                        for (Controller controller : Controller.getControllers()) {
                            for (ModelViewPair modelViewPair : controller.getModelViewPairs()) {
                                modelViewPair.model.update(delta);
                                modelViewPair.view.input(gameContainer.getInput());
                            }
                            controller.update(delta);
                        }
                    }

                    @Override
                    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
                        for (Controller controller : Controller.getControllers()) {
                            for (ModelViewPair modelViewPair : controller.getModelViewPairs()) {
                                modelViewPair.view.display(gameContainer.getGraphics());
                            }
                            controller.display();
                        }
                    }
                });
                app.setDisplayMode(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT, false);
                app.setAlwaysRender(true);
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
}
