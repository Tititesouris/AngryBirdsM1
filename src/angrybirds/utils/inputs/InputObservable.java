package angrybirds.utils.inputs;

import angrybirds.utils.inputs.actions.InputAction;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO: Description
 *
 * @author Tititesouris
 */
public abstract class InputObservable {

    private List<InputObserver> observers = new ArrayList<>();

    public boolean addObserver(InputObserver observer) {
        return observers.add(observer);
    }

    public boolean removeObserver(InputObserver observer) {
        return observers.remove(observer);
    }

    public int notifyObservers(InputAction inputAction) {
        for (InputObserver observer : observers) {
            observer.onInput(inputAction);
        }
        return observers.size();
    }

}
