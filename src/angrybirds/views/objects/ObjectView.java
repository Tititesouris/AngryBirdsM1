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

    public ObjectView(int id, Vector2d position, Vector2d size, float rotation) {
        super(id);
        this.position = position;
        this.size = size;
        this.rotation = rotation;
    }

}
