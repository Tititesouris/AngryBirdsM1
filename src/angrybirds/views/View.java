package angrybirds.views;

import angrybirds.models.Model;
import angrybirds.utils.Constants;
import angrybirds.utils.inputs.InputObservable;
import angrybirds.utils.updates.UpdateObserver;
import org.newdawn.slick.*;

/**
 * TODO: Description
 *
 * @author Tititesouris
 */
public abstract class View extends InputObservable implements UpdateObserver {

    public static AppGameContainer app;

    public View() {
    }

    public abstract void init(Model model);

    public abstract void display();

    protected Graphics getGraphics() {
        return app.getGraphics();
    }

    protected Input getInput() {
        return app.getInput();
    }

}
