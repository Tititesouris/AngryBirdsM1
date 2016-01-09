package angrybirds.views.objects.obstacles;

import org.newdawn.slick.Color;
import org.newdawn.slick.SpriteSheet;

/**
 * TODO: Description
 *
 * @author Tititesouris
 */
public enum ObstacleMaterialView {

    GLASS(Color.blue), WOOD(Color.orange), STONE(Color.lightGray);

    private Color color;

    private SpriteSheet spriteSheet;

    ObstacleMaterialView(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public SpriteSheet getSpriteSheet() {
        return spriteSheet;
    }

}
