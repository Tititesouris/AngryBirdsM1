package angrybirds2.views.abstracts.objects.birds;

import angrybirds2.datamodels.objects.birds.RedBirdDataModel;

/**
 * TODO: Description
 *
 * @author Quentin Brault
 */
public abstract class RedBirdView extends BirdView {

    public RedBirdView(RedBirdDataModel dataModel) {
        super(dataModel);
    }

    @Override
    public RedBirdDataModel getDataModel() {
        return (RedBirdDataModel) dataModel;
    }

}
