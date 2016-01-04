package angrybirds2.models.objects.birds;

import angrybirds2.datamodels.objects.birds.RedBirdDataModel;

/**
 * TODO: Description
 *
 * @author Quentin Brault
 */
public class RedBirdModel extends BirdModel {

    public RedBirdModel(RedBirdDataModel dataModel) {
        super(dataModel);
    }

    @Override
    protected RedBirdDataModel getDataModel() {
        return (RedBirdDataModel) dataModel;
    }

}
