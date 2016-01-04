package angrybirds2.views.abstracts;

import angrybirds2.datamodels.LevelDataModel;

/**
 * TODO: Description
 *
 * @author Quentin Brault
 */
public abstract class LevelView extends View {

    public LevelView(LevelDataModel dataModel) {
        super(dataModel);
    }

    @Override
    public LevelDataModel getDataModel() {
        return (LevelDataModel) dataModel;
    }

}
