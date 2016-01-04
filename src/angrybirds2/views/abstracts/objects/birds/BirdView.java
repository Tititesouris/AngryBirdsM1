package angrybirds2.views.abstracts.objects.birds;


import angrybirds2.datamodels.objects.birds.BirdDataModel;
import angrybirds2.views.abstracts.objects.ObjectView;

/**
 * TODO: Description
 *
 * @author Quentin Brault
 */
public abstract class BirdView extends ObjectView {

    public BirdView(BirdDataModel dataModel) {
        super(dataModel);
    }

    @Override
    public abstract BirdDataModel getDataModel();

}
