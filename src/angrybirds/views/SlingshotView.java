package angrybirds.views;

import angrybirds.utils.Constants;
import angrybirds.utils.Vector2d;
import angrybirds.notifications.inputs.actions.SlingshotInputAction;
import angrybirds.notifications.updates.actions.SlingshotUpdateAction;
import angrybirds.notifications.updates.actions.UpdateAction;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Line;
import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

/**
 * TODO: Description
 *
 * @author Quentin Brault
 */
public class SlingshotView extends View {

    private Vector2d position;

    private Vector2d size;

    private Vector2d holderPosition;

    private Vector2d holderPositionOffset = new Vector2d(0, -50);

    private Vector2d holderSize = new Vector2d(50, 20);

    private boolean pulling;

    public SlingshotView(int id, Vector2d position, Vector2d size, Vector2d holderPosition) {
        super(id);
        this.position = position;
        this.size = size;
        this.holderPosition = holderPosition;
    }

    @Override
    public void init() {

    }

    @Override
    public void input(Input input) {
        if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
            Vector2d mousePosition = new Vector2d(input.getMouseX(), input.getMouseY());
            if (pulling || mousePosition.difference(position.sum(holderPosition.sum(holderPositionOffset))).hypotenuse() <= 50) {
                notifyObservers(new SlingshotInputAction.Pull(mousePosition.difference(position.sum(holderPositionOffset))));
            }
        }
        else if (pulling) {
            notifyObservers(new SlingshotInputAction.Release());
        }
    }

    @Override
    public void onUpdate(UpdateAction updateAction) {
        if (updateAction instanceof SlingshotUpdateAction.Pull) {
            pull(((SlingshotUpdateAction.Pull) updateAction).getHolderPosition());
        } else if (updateAction instanceof SlingshotUpdateAction.Release) {
            release();
        }
    }

    @Override
    public void display(Graphics graphics) {
        if (Constants.DEBUG) {
            graphics.setColor(Color.black);
            Shape slingshot = new Polygon(new float[]{
                    position.x - size.x / 2, position.y - size.y / 2,
                    position.x - size.x / 2 + 10, position.y - size.y / 2,
                    position.x, position.y - 10,
                    position.x + size.x / 2 - 10, position.y - size.y / 2,
                    position.x + size.x / 2, position.y - size.y / 2,
                    position.x + 10, position.y + 10,
                    position.x + 10, position.y + size.y / 2,
                    position.x - 10, position.y + size.y / 2,
                    position.x - 10, position.y + 10

            });
            Shape holder = new Rectangle(
                    position.x + holderPosition.x + holderPositionOffset.x - holderSize.x / 2,
                    position.y + holderPosition.y + holderPositionOffset.y - holderSize.y / 2,
                    holderSize.x,
                    holderSize.y
            );
            Shape elastic1 = new Line(
                    position.x + holderPositionOffset.x - holderSize.x / 2,
                    position.y + holderPositionOffset.y - holderSize.y / 2,
                    position.x + holderPosition.x + holderPositionOffset.x - holderSize.x / 2,
                    position.y + holderPosition.y + holderPositionOffset.y
            );
            Shape elastic2 = new Line(
                    position.x + holderPositionOffset.x + holderSize.x / 2,
                    position.y + holderPositionOffset.y - holderSize.y / 2,
                    position.x + holderPosition.x + holderPositionOffset.x + holderSize.x / 2,
                    position.y + holderPosition.y + holderPositionOffset.y
            );

            graphics.draw(slingshot);
            graphics.draw(holder);
            graphics.setLineWidth(5);
            graphics.draw(elastic1);
            graphics.draw(elastic2);
        }
    }

    private void pull(Vector2d holderPosition) {
        pulling = true;
        this.holderPosition = holderPosition;
    }

    private void release() {
        pulling = false;
        holderPosition = Vector2d.ZERO;
    }

    public Vector2d getHolderPositionOffset() {
        return holderPositionOffset;
    }

}
