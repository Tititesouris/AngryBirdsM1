package angrybirds.updates;

import angrybirds.updates.actions.UpdateAction;

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

    public int notifyObservers(UpdateAction updateAction) {
        for (UpdateObserver observer : observers) {
            observer.onUpdate(updateAction);
        }
        return observers.size();
    }

}
