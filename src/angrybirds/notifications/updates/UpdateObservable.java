package angrybirds.notifications.updates;

import angrybirds.notifications.updates.actions.UpdateAction;
import angrybirds.utils.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * Toute classe fille de cette classe aura la possibilité d'envoyer des notification d'update à ses observateurs.
 * Le modèle est observé via cette classe.
 *
 * @author Quentin Brault
 * @since 2016/01/10
 */
public abstract class UpdateObservable {

    /**
     * Liste des observateurs à notifier.
     */
    private List<UpdateObserver> observers = new ArrayList<>();

    /**
     * Cette méthode ajoute un observateur à la liste des classes à notifier.
     *
     * @param observer Observateur à ajouter.
     * @return True si l'ajout s'est bien passé, false sinon.
     */
    public boolean addObserver(UpdateObserver observer) {
        return observers.add(observer);
    }

    /**
     * Cette méthode retire un observateur de la liste des classes à notifier.
     *
     * @param observer Observateur à supprimer.
     * @return True si la suppression s'est passée correctement, false sinon.
     */
    public boolean removeObserver(UpdateObserver observer) {
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
     * Cette méthode notifie les observateurs.
     *
     * @param action Instance d'UpdateAction à envoyer aux observateurs.
     * @return Nombre d'observateurs notifiés.
     */
    public int notifyObservers(UpdateAction action) {
        for (UpdateObserver observer : observers) {
            observer.onUpdate(action);
        }
        return observers.size();
    }

}
