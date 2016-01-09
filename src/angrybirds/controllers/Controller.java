package angrybirds.controllers;

import angrybirds.models.Model;
import angrybirds.utils.ModelViewPair;
import angrybirds.inputs.InputObserver;
import angrybirds.views.View;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO: Description
 *
 * @author Tititesouris
 */
public abstract class Controller implements InputObserver {

    private List<ModelViewPair> modelViewPairs;

    public Controller() {
        modelViewPairs = new ArrayList<>();
    }

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

    protected <T extends View> List<T> getViews() {
        List<T> views = new ArrayList<>();
        for (ModelViewPair modelViewPair : modelViewPairs) {
            views.add((T) modelViewPair.view);
        }
        return views;
    }

    public List<ModelViewPair> getModelViewPairs() {
        return modelViewPairs;
    }

}
