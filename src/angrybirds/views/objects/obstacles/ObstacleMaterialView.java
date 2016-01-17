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
    GLASS(Color.blue, "/src/sprites/objects/obstacles/glass.png"),

    /**
     * Bois.
     */
    WOOD(Color.orange, "/src/sprites/objects/obstacles/wood.png"),

    /**
     * Pierre
     */
    STONE(Color.lightGray, "/src/sprites/objects/obstacles/stone.png");

    /**
     * Couleur du matériau.
     */
    private Color color;

    /**
     * Chemin vers l'image du matériau.
     */
    private String spritePath;

    /**
     * Créé un nouveau matériau.
     *
     * @param color      Couleur du matériau.
     * @param spritePath Chemin vers l'image du matériau.
     */
    ObstacleMaterialView(Color color, String spritePath) {
        this.color = color;
        this.spritePath = spritePath;
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
     * Retourne le chemin vers l'image du matériau.
     *
     * @return Chemin vers l'image du matériau.
     */
    public String getSpritePath() {
        return spritePath;
    }

}
