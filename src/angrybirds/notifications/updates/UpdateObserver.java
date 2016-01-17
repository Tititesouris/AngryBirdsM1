package angrybirds.notifications.updates;

import angrybirds.notifications.updates.actions.UpdateAction;

/**
 * Toute classe implémentant cette interface recevra un appel de sa fonction lorsqu'une classe observée enverra une notification.
 * La vue observe le modèle via cette classe.
 *
 * @author Quentin Brault
 * @since 2016/01/10
 */
public interface UpdateObserver {

    /**
     * Cette méthode est appellée lorsqu'un UpdateObservable observé envoit une notification.
     *
     * @param updateAction Instance d'UpdateAction envoyée par l'observé.
     */
    void onUpdate(UpdateAction updateAction);

}
