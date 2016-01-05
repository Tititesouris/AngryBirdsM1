package angrybirds.utils;

import angrybirds.models.Model;
import angrybirds.views.View;

/**
 * TODO: Description
 *
 * @author Tititesouris
 */
public class ModelViewPair<M extends Model, V extends View> {

    public final M model;

    public final V view;

    public ModelViewPair(M model, V view) {
        this.model = model;
        this.view = view;
    }

}
