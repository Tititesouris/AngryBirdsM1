package angrybirds.views.objects.obstacles;

import angrybirds.notifications.updates.actions.UpdateAction;
import angrybirds.utils.Constants;
import angrybirds.utils.Vector2d;
import angrybirds.views.objects.ObjectView;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

/**
 * Cette classe représente une vue d'obstacle.
 *
 * @author Quentin Brault
 * @since  2013/10/01
 */
public class ObstacleView extends ObjectView {

    /**
     * Informations graphiques du matériau de l'objet.
     */
    private ObstacleMaterialView material;

    public ObstacleView(int id, Vector2d position, Vector2d size, float rotation, ObstacleMaterialView material) {
        super(id, position, size, rotation);
        this.material = material;
    }

    @Override
    public void init() {

    }

    @Override
    public void input(Input input) {

    }

    @Override
    public void display(Graphics graphics) {

    }

    @Override
    public void displayDebug(Graphics graphics) {
        graphics.setColor(material.getColor());
        Shape obstacle = new Rectangle(position.x - size.x / 2, position.y - size.y / 2, size.x, size.y);
        obstacle = getRotated(obstacle, rotation, size.x / 2, size.y / 2);
        graphics.fill(obstacle);
    }

    @Override
    public void onUpdate(UpdateAction updateAction) {
        super.onUpdate(updateAction);
    }

}
