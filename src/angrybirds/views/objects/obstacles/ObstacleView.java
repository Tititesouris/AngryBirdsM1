package angrybirds.views.objects.obstacles;

import angrybirds.notifications.updates.actions.UpdateAction;
import angrybirds.utils.Constants;
import angrybirds.utils.Vector2d;
import angrybirds.views.objects.ObjectView;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

/**
 * Cette classe représente une vue d'obstacle.
 *
 * @author Quentin Brault
 * A contribué : Maxime Catteau
 * @since 2013/10/01
 */
public class ObstacleView extends ObjectView {

	/**
	 * Informations graphiques du matériau de l'objet.
	 */
	private ObstacleMaterialView material;

	/**
	 * Créé une vue d'obstacle.
	 *
	 * @param id       Identifiant unique du modèle d'obstacle.
	 * @param position Position du centre de l'obstacle.
	 * @param size     Taille de l'obstacle.
	 * @param rotation Angle de rotation de l'obstacle.
     * @param material Matériau de l'obstacle.
     */
	public ObstacleView(int id, Vector2d position, Vector2d size, float rotation, ObstacleMaterialView material) {
        super(id, position, size, rotation);
        this.material = material;
    }

	@Override
	public void init() {
		try {
            switch (material.name()) {
                case "GLASS":
                    sprite = new Image("/res/sprites/objects/obstacles/glass.png").getScaledCopy((int) size.x, (int) size.y);
                    break;
                case "STONE":
                    sprite = new Image("/res/sprites/objects/obstacles/rock.png").getScaledCopy((int) size.x, (int) size.y);
                    break;
                case "WOOD":
                    sprite = new Image("/res/sprites/objects/obstacles/wood.png").getScaledCopy((int) size.x, (int) size.y);
                    break;
            }
		} catch (SlickException e) {
			e.printStackTrace();
		}
        rotateTo(rotation);
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
		graphics.setColor(material.getColor());
		Shape obstacle = new Rectangle(position.x - size.x / 2, position.y
				- size.y / 2, size.x, size.y);
		obstacle = getRotated(obstacle, rotation, 0, 0);
		graphics.fill(obstacle);
	}

	@Override
	public void onUpdate(UpdateAction updateAction) {
		super.onUpdate(updateAction);
	}

}
