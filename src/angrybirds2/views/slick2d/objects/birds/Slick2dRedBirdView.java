package angrybirds2.views.slick2d.objects.birds;

import angrybirds2.datamodels.objects.birds.RedBirdDataModel;
import angrybirds2.views.abstracts.objects.birds.RedBirdView;
import angrybirds2.views.slick2d.Slick2dView;
import org.newdawn.slick.Color;

/**
 * TODO: Description
 *
 * @author Quentin Brault
 */
public class Slick2dRedBirdView extends RedBirdView implements Slick2dView {

    public Slick2dRedBirdView(RedBirdDataModel dataModel) {
        super(dataModel);
    }

    @Override
    public void display() {
        RedBirdDataModel me = getDataModel();
        graphics.setColor(Color.red);
        graphics.fillOval(me.getPosition().x, me.getPosition().y, me.getSize().x, me.getSize().y);
    }

}
