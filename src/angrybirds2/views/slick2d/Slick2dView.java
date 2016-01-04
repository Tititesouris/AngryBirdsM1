package angrybirds2.views.slick2d;

import angrybirds2.Window;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

/**
 * TODO: Description
 *
 * @author Quentin Brault
 */
public interface Slick2dView {

    GameContainer container = Window.getInstance().getContainer();

    Graphics graphics = container.getGraphics();

}
