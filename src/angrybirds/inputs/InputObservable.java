package angrybirds.inputs;

import angrybirds.inputs.actions.InputAction;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO: Description
 *
 * @author Tititesouris
 */
public abstract class InputObservable {

    private List<InputObserver> observers = new ArrayList<>();

    private long lastNotify = System.currentTimeMillis();

    public boolean addObserver(InputObserver observer) {
        return observers.add(observer);
    }

    public boolean removeObserver(InputObserver observer) {
        return observers.remove(observer);
    }

    public boolean removeObservers() {
        this.observers = new ArrayList<>();
        return true;
    }

    public int notifyObservers(InputAction inputAction) {
        long currentTime = System.currentTimeMillis();
        if (lastNotify + 100 < currentTime) {
            for (InputObserver observer : observers) {
                observer.onInput(inputAction);
            }
            lastNotify = currentTime;
            return observers.size();
        }
        return 0;
    }

}
