package angrybirds2.views.abstracts;

import angrybirds2.datamodels.SlingshotDataModel;

/**
 * TODO: Description
 *
 * @author Quentin Brault
 */
public abstract class SlingshotView extends View {

    public SlingshotView(SlingshotDataModel dataModel) {
        super(dataModel);
    }

    @Override
    public SlingshotDataModel getDataModel() {
        return (SlingshotDataModel) dataModel;
    }

}
