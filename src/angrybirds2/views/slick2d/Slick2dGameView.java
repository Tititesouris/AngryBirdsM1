package angrybirds2.views.slick2d;

import angrybirds2.datamodels.GameDataModel;
import angrybirds2.views.abstracts.GameView;

/**
 * TODO: Description
 *
 * @author Quentin Brault
 */
public class Slick2dGameView extends GameView implements Slick2dView {

    public Slick2dGameView(GameDataModel dataModel) {
        super(dataModel);
    }

    @Override
    public void display() {
        graphics.drawString("Play!", 0, 0);
    }

}
