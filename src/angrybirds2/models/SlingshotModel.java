package angrybirds2.models;

import angrybirds2.datamodels.SlingshotDataModel;
import angrybirds2.utils.Vector2d;

/**
 * TODO: Description
 *
 * @author Quentin Brault
 */
public class SlingshotModel extends Model {

    public SlingshotModel(SlingshotDataModel dataModel) {
        super(dataModel);
    }

    public void pull(Vector2d location) {
        SlingshotDataModel me = getDataModel();
        me.setHolderPosition(location);
        me.getBird().setPosition(location);
    }

    public void realease() {
        SlingshotDataModel me = getDataModel();
        Vector2d impulse = me.getHolderPosition().difference(me.getDefaultHolderPosition());
        impulse = impulse.normalized();
        impulse = impulse.product(100);
        me.getBird().setVelocity(me.getBird().getVelocity().sum(impulse));
    }

    @Override
    public void update(int delta) {
    }

    @Override
    protected SlingshotDataModel getDataModel() {
        return (SlingshotDataModel) dataModel;
    }

}
