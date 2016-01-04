package angrybirds2.views.slick2d.objects.birds;

import angrybirds2.datamodels.objects.birds.YellowBirdDataModel;
import angrybirds2.views.abstracts.objects.birds.YellowBirdView;
import angrybirds2.views.slick2d.Slick2dView;
import org.newdawn.slick.Color;
import org.newdawn.slick.geom.Polygon;

/**
 * TODO: Description
 *
 * @author Tititesouris
 */
public class Slick2dYellowBirdView extends YellowBirdView implements Slick2dView {

    public Slick2dYellowBirdView(YellowBirdDataModel dataModel) {
        super(dataModel);
    }

    @Override
    public void display() {
        YellowBirdDataModel me = getDataModel();
        Polygon triangle = new Polygon(new float[] {
                me.getPosition().x, me.getPosition().y + me.getSize().y,
                me.getPosition().x + me.getSize().x / 2, me.getPosition().y,
                me.getPosition().x + me.getSize().x, me.getPosition().y + me.getSize().y
        });
        graphics.setColor(Color.yellow);
        graphics.fill(triangle);
    }

}
