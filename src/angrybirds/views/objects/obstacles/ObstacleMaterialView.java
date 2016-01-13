package angrybirds.views.objects.obstacles;

import org.newdawn.slick.Color;
import org.newdawn.slick.SpriteSheet;

/**
 * Cette énumération représente les informations graphiques des matériaux.
 *
 * @author Quentin Brault
 * @since  2013/10/01
 */
public enum ObstacleMaterialView {

    /**
     * Verre.
     */
    GLASS(Color.blue),

    /**
     * Bois.
     */
    WOOD(Color.orange),

    /**
     * Pierre
     */
    STONE(Color.lightGray);

    /**
     * Couleur du matériau.
     */
    private Color color;

    /**
     * Image du matériau.
     */
    private SpriteSheet spriteSheet;

    /**
     * Créé un nouveau matériau.
     *
     * @param color Couleur du matériau.
     */
    ObstacleMaterialView(Color color) {
        this.color = color;
    }

    /**
     * Retourne la couleur du matériau.
     *
     * @return Couleur du matériau.
     */
    public Color getColor() {
        return color;
    }

    /**
     * Retourne l'image du matériau.
     *
     * @return Image du matériau.
     */
    public SpriteSheet getSpriteSheet() {
        return spriteSheet;
    }

}
