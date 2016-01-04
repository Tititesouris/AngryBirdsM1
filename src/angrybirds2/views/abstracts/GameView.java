package angrybirds2.views.abstracts;

import angrybirds2.datamodels.GameDataModel;

/**
 * TODO: Description
 *
 * @author Quentin Brault
 */
public abstract class GameView extends View {

    public GameView(GameDataModel dataModel) {
        super(dataModel);
    }

    @Override
    public GameDataModel getDataModel() {
        return (GameDataModel) dataModel;
    }

}
