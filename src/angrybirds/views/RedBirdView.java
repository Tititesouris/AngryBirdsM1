package angrybirds.views;

/**
 * TODO: Description
 *
 * @author Tititesouris
 */
public class RedBirdView extends BirdView {

    @Override
    public void display() {
        getGraphics().fillOval(position.x, position.y, size.x, size.y);
    }

}
