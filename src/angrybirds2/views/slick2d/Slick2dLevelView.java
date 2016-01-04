package angrybirds2.views.slick2d;

import angrybirds2.datamodels.LevelDataModel;
import angrybirds2.utils.Constants;
import angrybirds2.views.abstracts.LevelView;
import org.newdawn.slick.Color;

/**
 * TODO: Description
 *
 * @author Quentin Brault
 */
public class Slick2dLevelView extends LevelView implements Slick2dView {

    public Slick2dLevelView(LevelDataModel dataModel) {
        super(dataModel);
    }

    @Override
    public void display() {
        graphics.setColor(Color.green);
        graphics.fillRect(0, Constants.WINDOW_HEIGHT - getDataModel().getGroundHeight(), Constants.WINDOW_WIDTH, getDataModel().getGroundHeight());
    }

}
