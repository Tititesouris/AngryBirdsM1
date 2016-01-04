package angrybirds2.views.abstracts.objects.birds;

import angrybirds2.datamodels.objects.birds.YellowBirdDataModel;

/**
 * TODO: Description
 *
 * @author Quentin Brault
 */
public abstract class YellowBirdView extends BirdView {

    public YellowBirdView(YellowBirdDataModel dataModel) {
        super(dataModel);
    }

    @Override
    public YellowBirdDataModel getDataModel() {
        return (YellowBirdDataModel) dataModel;
    }

}
