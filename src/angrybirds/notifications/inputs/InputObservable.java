package angrybirds.notifications.inputs;

import angrybirds.notifications.inputs.actions.InputAction;
import angrybirds.utils.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO: Description
 *
 * @author Tititesouris
 */
public abstract class InputObservable {

    private long lastNotify = System.currentTimeMillis();

    private List<InputObserver> observers = new ArrayList<>();

    public boolean addObserver(InputObserver observer) {
        return observers.add(observer);
    }

    public boolean removeObserver(InputObserver observer) {
        return observers.remove(observer);
    }

    public boolean clear() {
        this.observers = new ArrayList<>();
        return true;
    }

    public int notifyObservers(InputAction action) {
        long currentTime = System.currentTimeMillis();
        if (lastNotify + Constants.MIN_ENGINE_DELAY < currentTime) {
            for (InputObserver observer : observers) {
                observer.onInput(action);
            }
            lastNotify = currentTime;
            return observers.size();
        }
        return 0;
    }

}
