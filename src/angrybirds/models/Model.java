package angrybirds.models;

import angrybirds.utils.updates.UpdateObservable;

/**
 * TODO: Description
 *
 * @author Tititesouris
 */
public abstract class Model extends UpdateObservable {

    public abstract void init();

    public abstract void update(int delta);

}
