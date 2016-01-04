package angrybirds2.models.objects;

import angrybirds2.datamodels.objects.ObjectDataModel;
import angrybirds2.models.Model;
import angrybirds2.utils.Constants;

/**
 * TODO: Description
 *
 * @author Quentin Brault
 */
public abstract class ObjectModel extends Model {

    public ObjectModel(ObjectDataModel dataModel) {
        super(dataModel);
    }

    public void update(int delta) {
        ObjectDataModel me = getDataModel();
        if (me.hasGravity())
            me.setAcceleration(Constants.GRAVITY.product(me.getMass()));
        me.setVelocity(me.getVelocity().sum(me.getAcceleration().product(delta)));
        me.setPosition(me.getPosition().sum(me.getVelocity().product(delta)));
    }

    protected abstract ObjectDataModel getDataModel();

}
