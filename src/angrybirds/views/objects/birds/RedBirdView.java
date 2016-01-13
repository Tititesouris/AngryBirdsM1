package angrybirds.views.objects.birds;

import angrybirds.utils.Vector2d;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

/**
 * Cette classe représente une vue d'oiseau rouge.
 *
 * @author Quentin Brault
 * @since  2013/10/01
 */
public class RedBirdView extends BirdView {

    /**
     * Créé une vue d'oiseau rouge.
     *
     * @param id       Identifiant unique du modèle d'oiseau.
     * @param position Position de l'oiseau.
     * @param size     Taille de l'oiseau.
     * @param rotation Angle de rotation de l'oiseau.
     */
    public RedBirdView(int id, Vector2d position, Vector2d size, float rotation) {
        super(id, position, size, rotation);
    }

    @Override
    public void init() {
        color = Color.red;
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
