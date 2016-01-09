package angrybirds.views.objects;

import angrybirds.models.Model;
import angrybirds.models.objects.ObjectModel;
import angrybirds.utils.Vector2d;
import angrybirds.views.View;

/**
 * TODO: Description
 *
 * @author Tititesouris
 */
public abstract class ObjectView extends View {

    protected Vector2d position;

    protected Vector2d size;

    protected float rotation;

    @Override
    public void init(Model model) {
        ObjectModel object = (ObjectModel) model;
        this.position = object.getPosition();
        this.size = object.getSize();
        this.rotation = object.getRotation();
    }

}
