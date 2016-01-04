package angrybirds2.controllers;

import angrybirds2.models.Model;
import angrybirds2.utils.InputObserver;
import angrybirds2.views.abstracts.View;

/**
 * TODO: Description
 *
 * @author Quentin Brault
 */
public abstract class Controller implements InputObserver {

    protected Model model;

    protected View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void update(int delta) {
        model.update(delta);
    }

    public void display() {
        view.display();
    }

    protected abstract Model getModel();

    protected abstract View getView();

}
