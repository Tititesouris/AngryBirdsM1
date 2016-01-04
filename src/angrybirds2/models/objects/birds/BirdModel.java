package angrybirds2.models.objects.birds;

import angrybirds2.datamodels.objects.birds.BirdDataModel;
import angrybirds2.models.objects.ObjectModel;

/**
 * TODO: Description
 *
 * @author Quentin Brault
 */
public abstract class BirdModel extends ObjectModel {

    public BirdModel(BirdDataModel dataModel) {
        super(dataModel);
    }

    @Override
    protected abstract BirdDataModel getDataModel();

}
