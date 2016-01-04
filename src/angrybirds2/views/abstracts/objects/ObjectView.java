package angrybirds2.views.abstracts.objects;

import angrybirds2.datamodels.objects.ObjectDataModel;
import angrybirds2.views.abstracts.View;

/**
 * TODO: Description
 *
 * @author Quentin Brault
 */
public abstract class ObjectView extends View {

    public ObjectView(ObjectDataModel dataModel) {
        super(dataModel);
    }

    @Override
    public abstract ObjectDataModel getDataModel();

}
