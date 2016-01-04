package angrybirds2.models;

import angrybirds2.datamodels.GameDataModel;

/**
 * TODO: Description
 *
 * @author Quentin Brault
 */
public class GameModel extends Model {

    public GameModel(GameDataModel dataModel) {
        super(dataModel);
    }

    @Override
    public void update(int delta) {

    }

    @Override
    protected GameDataModel getDataModel() {
        return (GameDataModel) dataModel;
    }

}
