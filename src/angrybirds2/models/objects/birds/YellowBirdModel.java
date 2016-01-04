package angrybirds2.models.objects.birds;

import angrybirds2.datamodels.objects.birds.BirdDataModel;
import angrybirds2.datamodels.objects.birds.YellowBirdDataModel;

/**
 * TODO: Description
 *
 * @author Quentin Brault
 */
public class YellowBirdModel extends BirdModel {

    public YellowBirdModel(BirdDataModel dataModel) {
        super(dataModel);
    }

    @Override
    protected YellowBirdDataModel getDataModel() {
        return (YellowBirdDataModel) dataModel;
    }

}
