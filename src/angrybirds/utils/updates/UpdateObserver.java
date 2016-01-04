package angrybirds.utils.updates;

import angrybirds.utils.updates.actions.UpdateAction;

/**
 * TODO: Description
 *
 * @author Tititesouris
 */
public interface UpdateObserver {

    void onUpdate(UpdateAction updateAction);

}
