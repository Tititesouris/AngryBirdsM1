package angrybirds.notifications.inputs;

import angrybirds.notifications.inputs.actions.InputAction;
import angrybirds.utils.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * Toute classe fille de cette classe aura la possibilité d'envoyer des notification d'input à ses observateurs.
 * La vue est observée par le controller via cette classe.
 *
 * @author Quentin Brault
 * @since 2016/01/10
 */
public abstract class InputObservable {

    /**
     * Timestamp du dernier appel à notifyObservers().
     */
    private long lastNotify = System.currentTimeMillis();

    /**
     * Liste des observateurs à notifier.
     */
    private List<InputObserver> observers = new ArrayList<>();

    /**
     * Cette méthode ajoute un observateur à la liste des classes à notifier.
     *
     * @param observer Observateur à ajouter.
     * @return True si l'ajout s'est bien passé, false sinon.
     */
    public boolean addObserver(InputObserver observer) {
        return observers.add(observer);
    }

    /**
     * Cette méthode retire un observateur de la liste des classes à notifier.
     *
     * @param observer Observateur à supprimer.
     * @return True si la suppression s'est passée correctement, false sinon.
     */
    public boolean removeObserver(InputObserver observer) {
        return observers.remove(observer);
    }

    /**
     * Vide la liste des observateurs.
     *
     * @return Nombre d'observateurs supprimés.
     */
    public int clear() {
        int size = observers.size();
        observers = new ArrayList<>();
        return size;
    }

    /**
     * Cette méthode notifie les observateurs si le temps écoulé depuis le dernier appel est suffisant.
     *
     * @param action Instance d'InputAction à envoyer aux observateurs.
     * @return Nombre d'observateurs notifiés.
     */
    protected int notifyObservers(InputAction action) {
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
