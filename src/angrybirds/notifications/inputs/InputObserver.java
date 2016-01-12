package angrybirds.notifications.inputs;

import angrybirds.notifications.inputs.actions.InputAction;

/**
 * Toute classe implémentant cette interface recevra un appel de sa fonction lorsqu'une classe observée enverra une notification.
 * Le controlleur observe la vue via cette classe.
 *
 * @author Quentin Brault
 * @since 2016/01/10
 */
public interface InputObserver {

    /**
     * Cette méthode est appellée lorsqu'un InputObservable observé envoit une notification.
     *
     * @param inputAction Instance d'InputAction envoyée par l'observé.
     */
    void onInput(InputAction inputAction);

}
