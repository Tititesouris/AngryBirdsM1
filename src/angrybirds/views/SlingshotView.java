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
 * Cette classe représente une vue de lance-oiseau.
 *
 * @author Quentin Brault
 * @since  2013/10/01
 */
public class SlingshotView extends View {

    /**
     * Position du centre du lance-oiseau.
     */
    private Vector2d position;

    /**
     * Taille du lance-oiseau.
     */
    private Vector2d size;

    /**
     * Position du holder du lance-oiseau par rapport à la position du centre du lance-oiseau.
     */
    private Vector2d defaultHolderPosition;

    /**
     * Position du holder du lance-oiseau par rapport à sa position par défaut.
     */
    private Vector2d holderPosition;

    /**
     * Taille du holder du lance-oiseau.
     */
    private Vector2d holderSize = new Vector2d(50, 20);

    /**
     * True si l'utilisateur est en train de tirer sur le lance-oiseau, false sinon.
     */
    private boolean pulling;

    /**
     * Créé une vue de slingshot.
     *
     * @param id                    Identifiant unique du modèle de lance-oiseau.
     * @param position              Position du centre du lance-oiseau.
     * @param size                  Taille du lance-oiseau.
     * @param defaultHolderPosition Position du holder du lance-oiseau par rapport au centre du lance-oiseau.
     * @param holderPosition        Position du holder du lance-oiseau par rapport à sa position par défaut.
     */
    public SlingshotView(int id, Vector2d position, Vector2d size, Vector2d defaultHolderPosition, Vector2d holderPosition) {
        super(id);
        this.position = position;
        this.size = size;
        this.defaultHolderPosition = defaultHolderPosition;
        this.holderPosition = holderPosition;
    }

    @Override
    public void init() {

    }

    @Override
    public void input(Input input) {
        if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
            Vector2d mousePosition = new Vector2d(input.getMouseX(), input.getMouseY());
            if (pulling || mousePosition.difference(position.sum(holderPosition.sum(defaultHolderPosition))).hypotenuse() <= 50) {
                notifyObservers(new SlingshotInputAction.Pull(mousePosition.difference(position.sum(defaultHolderPosition))));
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
                    position.x + defaultHolderPosition.x + holderPosition.x - holderSize.x / 2,
                    position.y + defaultHolderPosition.y + holderPosition.y - holderSize.y / 2,
                    holderSize.x,
                    holderSize.y
            );
            Shape elastic1 = new Line(
                    position.x + defaultHolderPosition.x - holderSize.x / 2,
                    position.y + defaultHolderPosition.y - holderSize.y / 2,
                    position.x + defaultHolderPosition.x + holderPosition.x - holderSize.x / 2,
                    position.y + defaultHolderPosition.y + holderPosition.y
            );
            Shape elastic2 = new Line(
                    position.x + defaultHolderPosition.x + holderSize.x / 2,
                    position.y + defaultHolderPosition.y - holderSize.y / 2,
                    position.x + defaultHolderPosition.x + holderPosition.x + holderSize.x / 2,
                    position.y + defaultHolderPosition.y + holderPosition.y
            );

            graphics.draw(slingshot);
            graphics.draw(holder);
            graphics.setLineWidth(5);
            graphics.draw(elastic1);
            graphics.draw(elastic2);
        }
    }

    /**
     * Cette méthode doit être appellée quand le modèle prévient que le lance-oiseau a été étiré.
     *
     * @param holderPosition Nouvelle position du holder du lance-oiseau.
     */
    private void pull(Vector2d holderPosition) {
        pulling = true;
        this.holderPosition = holderPosition;
    }

    /**
     * Cette méthode doit être appellée quand le modèle prévient que le lance-oiseau a été relaché.
     */
    private void release() {
        pulling = false;
        holderPosition = Vector2d.ZERO;
    }

}
