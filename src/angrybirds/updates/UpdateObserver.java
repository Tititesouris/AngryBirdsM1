package angrybirds.updates;

import angrybirds.updates.actions.UpdateAction;

/**
 * TODO: Description
 *
 * @author Tititesouris
 */
public interface UpdateObserver {

    void onUpdate(UpdateAction updateAction);

}
