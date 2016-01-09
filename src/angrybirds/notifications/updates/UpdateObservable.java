package angrybirds.notifications.updates;

import angrybirds.notifications.updates.actions.UpdateAction;
import angrybirds.utils.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO: Description
 *
 * @author Tititesouris
 */
public abstract class UpdateObservable {

    private List<UpdateObserver> observers = new ArrayList<>();

    public boolean addObserver(UpdateObserver observer) {
        return observers.add(observer);
    }

    public boolean removeObserver(UpdateObserver observer) {
        return observers.remove(observer);
    }

    public boolean clear() {
        this.observers = new ArrayList<>();
        return true;
    }

    public int notifyObservers(UpdateAction action) {
        for (UpdateObserver observer : observers) {
            observer.onUpdate(action);
        }
        return observers.size();
    }

}
