package angrybirds.controllers;

import angrybirds.models.Model;
import angrybirds.utils.ModelViewPair;
import angrybirds.notifications.inputs.InputObserver;
import angrybirds.views.View;

import java.util.*;

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

    protected <T extends Model> SortedMap<Integer, T> getModels() {
        SortedMap<Integer, T> models = new TreeMap<>();
        for (ModelViewPair modelViewPair : modelViewPairs) {
            models.put(modelViewPair.model.getId(), (T) modelViewPair.model);
        }
        return models;
    }

    protected <T extends View> SortedMap<Integer, T> getViews() {
        SortedMap<Integer, T> views = new TreeMap<>();
        for (ModelViewPair modelViewPair : modelViewPairs) {
            views.put(modelViewPair.view.getId(), (T) modelViewPair.view);
        }
        return views;
    }

    public List<ModelViewPair> getModelViewPairs() {
        return modelViewPairs;
    }

}
