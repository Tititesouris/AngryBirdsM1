package angrybirds.views.objects.birds;

import angrybirds.utils.Vector2d;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
/**
 * Cette classe représente une vue d'oiseau jaune.
 *
 * @author Quentin Brault
 * @since  2013/10/01
 */
public class YellowBirdView extends BirdView {

    /**
     * Image de l'oiseau jaune.
     */
	private Image sprite;
	
    /**
     * Créé une vue d'oiseau jaune.
     *
     * @param id       Identifiant unique du modèle d'oiseau.
     * @param position Position de l'oiseau.
     * @param size     Taille de l'oiseau.
     * @param rotation Angle de rotation de l'oiseau.
     */
    public YellowBirdView(int id, Vector2d position, Vector2d size, float rotation) {
        super(id, position, size, rotation);
    }

    @Override
    public void init() {
        color = Color.yellow;
        try {
			sprite = new Image("/res/sprites/objects/birds/yellow.png");
		} catch (SlickException e) {
			e.printStackTrace();
		}
    }

    @Override
    public void input(Input input) {
        super.input(input);
    }

    @Override
    public void display(Graphics graphics) {
        super.display(graphics);
    }

}
