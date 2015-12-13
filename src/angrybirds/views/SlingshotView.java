package angrybirds.views;

import angrybirds.models.SlingshotModel;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Cette classe affiche la fronde
 *
 * @author AngryBirdsM1
 */
public class SlingshotView implements View {

    /**
     * fronde
     */
    private SlingshotModel model;

    /**
     * crée une vue sur la fronde
     * @param model
     */
    public SlingshotView(SlingshotModel model) {
        this.model = model;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {

    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        graphics.setLineWidth(5);
        graphics.drawRect((float) (model.getPosition().x - model.getSize().x / 2), (float) model.getPosition().y, (float) model.getSize().x, (float) model.getSize().y);
        if (model.isActive()) {
            graphics.drawLine((float) model.getPosition().x, (float) model.getPosition().y, (float) model.getBirdPosition().x, (float) model.getBirdPosition().y);
        }
    }

}
