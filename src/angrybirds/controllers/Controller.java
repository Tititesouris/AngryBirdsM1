package angrybirds.controllers;

import angrybirds.models.Model;
import angrybirds.utils.Constants;
import angrybirds.utils.ModelViewPair;
import angrybirds.utils.inputs.InputObserver;
import angrybirds.views.View;
import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO: Description
 *
 * @author Tititesouris
 */
public abstract class Controller implements InputObserver {

    private static final List<Controller> controllers = new ArrayList<>();

    private List<ModelViewPair> modelViewPairs;

    public Controller() {
        modelViewPairs = new ArrayList<>();
        controllers.add(this);
    }

    public abstract void init();

    public abstract void update(int delta);

    public abstract void display();

    protected boolean addModelViewPair(ModelViewPair modelViewPair) {
        modelViewPair.model.addObserver(modelViewPair.view);
        modelViewPair.view.addObserver(this);
        return modelViewPairs.add(modelViewPair);
    }

    protected <T extends Model> List<T> getModels() {
        List<T> models = new ArrayList<>();
        for (ModelViewPair modelViewPair : modelViewPairs) {
            models.add((T) modelViewPair.model);
        }
        return models;
    }

    public static List<Controller> getControllers() {
        return controllers;
    }

    public List<ModelViewPair> getModelViewPairs() {
        return modelViewPairs;
    }

}
