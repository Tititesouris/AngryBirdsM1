package angrybirds.models;

import angrybirds.updates.UpdateObservable;

/**
 * TODO: Description
 *
 * @author Tititesouris
 */
public abstract class Model extends UpdateObservable {

    private static int idCount = 0;

    private final int id;

    public Model() {
        id = idCount++;
    }

    public abstract void update(int delta);

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Model)
            return this.id == ((Model) object).id;
        return false;
    }

}
