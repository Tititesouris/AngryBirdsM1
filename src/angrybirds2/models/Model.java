package angrybirds2.models;

import angrybirds2.datamodels.DataModel;

/**
 * TODO: Description
 *
 * @author Quentin Brault
 */
public abstract class Model {

    protected DataModel dataModel;

    public Model(DataModel dataModel) {
        this.dataModel = dataModel;
    }

    public abstract void update(int delta);

    protected abstract DataModel getDataModel();

}
