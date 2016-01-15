package angrybirds.views.objects;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import angrybirds.notifications.updates.actions.UpdateAction;
import angrybirds.utils.Vector2d;

/**
 * Cette classe représente une vue d'objet.
 *
 * @author Quentin Brault
 * @since  2013/10/01
 */
public class PigView extends ObjectView {

    /**
     * Créé une vue de cochon.
     *
     * @param id       Identifiant unique du modèle de cochon.
     * @param position Position du cochon.
     * @param size     Taille du cochon.
     * @param rotation Rotation du cochon.
     */
	
	/**
	 * Cette variable contient la texture du cochon
	 */
	private Image sprite;
	
    public PigView(int id, Vector2d position, Vector2d size, float rotation) {
        super(id, position, size, rotation);
    }

    @Override
    public void init() {
    	try {
			sprite = new Image("/res/sprites/objects/pig.png").getScaledCopy((int) size.x,(int) size.y);
		} catch (SlickException e) {
			e.printStackTrace();
		}
    }

    @Override
    public void input(Input input) {

    }

    @Override
    public void display(Graphics graphics) {
    	graphics.drawImage(sprite, position.x - size.x / 2, position.y - size.y / 2);
    }

    @Override
    public void displayDebug(Graphics graphics) {
        graphics.setColor(Color.green);
        graphics.fillOval(position.x - size.x / 2, position.y - size.y / 2, size.x, size.y);
    }

    @Override
    public void onUpdate(UpdateAction updateAction) {
        super.onUpdate(updateAction);
    }

}
