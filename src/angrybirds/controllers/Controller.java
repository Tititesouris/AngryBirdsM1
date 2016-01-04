package angrybirds.controllers;

import angrybirds.models.Model;
import angrybirds.utils.Constants;
import angrybirds.utils.ModelViewPair;
import angrybirds.utils.inputs.InputObserver;
import angrybirds.views.View;
import org.newdawn.slick.*;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO: Description
 *
 * @author Tititesouris
 */
public abstract class Controller implements InputObserver {

    private final static List<Controller> controllers = new ArrayList<>();

    /**
     * Liste des modèles et leur vue associée de ce controlleur.
     */
    private List<ModelViewPair> modelViewPairs;

    public Controller() {
        controllers.add(this);
        modelViewPairs = new ArrayList<>();
    }

    /**
     * Cette méthode prépare à l'utilisation du framework Slick2d.
     * Cette méthode ne fait des opérations que la première fois qu'elle est appellée.
     * Ces opérations sont:
     * Créer une fenêtre Slick2d si il n'en existe pas.
     * Relayer les appels du framework aux méthodes init(), update(delta) et display() aux modèles et vues.
     */
    public static void setupSlick2d() {
        if (View.app == null) {
            try {
                View.app = new AppGameContainer(new BasicGame("Angry Birds!") {
                    @Override
                    public void init(GameContainer gameContainer) throws SlickException {
                        for (Controller controller : controllers)
                            controller.init();
                    }

                    @Override
                    public void update(GameContainer gameContainer, int delta) throws SlickException {
                        for (Controller controller : controllers)
                            controller.update(delta);
                    }

                    @Override
                    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
                        for (Controller controller : controllers)
                            controller.display();
                    }
                });
                View.app.setDisplayMode(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT, false);
                View.app.setAlwaysRender(true);
                View.app.setMaximumLogicUpdateInterval(10);
                View.app.setTargetFrameRate(60);
                View.app.start();
            } catch (SlickException e) {
                e.printStackTrace();
            }
        }
    }

    public void init() {
        for (ModelViewPair modelViewPair : modelViewPairs) {
            modelViewPair.model.init();
            modelViewPair.view.init(modelViewPair.model);
        }
    }

    public void update(int delta) {
        for (ModelViewPair modelViewPair : modelViewPairs)
            modelViewPair.model.update(delta);
    }

    public void display() {
        for (ModelViewPair modelViewPair : modelViewPairs)
            modelViewPair.view.display();
    }

    protected boolean addModelViewPair(ModelViewPair modelViewPair) {
        modelViewPair.model.addObserver(modelViewPair.view);
        modelViewPair.view.addObserver(this);
        return modelViewPairs.add(modelViewPair);
    }

    protected List<Model> getAbstractModels() {
        List<Model> models = new ArrayList<>();
        for (ModelViewPair modelViewPair : modelViewPairs)
            models.add(modelViewPair.model);
        return models;
    }

    public abstract List<? extends Model> getModels();

}
