package angrybirds.notifications.updates;

import angrybirds.notifications.updates.actions.UpdateAction;

/**
 * TODO: Description
 *
 * @author Tititesouris
 */
public interface UpdateObserver {

    void onUpdate(UpdateAction updateAction);

}
