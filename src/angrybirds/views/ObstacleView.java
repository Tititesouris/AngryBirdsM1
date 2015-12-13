package angrybirds.views;

import angrybirds.Tool;
import angrybirds.models.CircularObstacleModel;
import angrybirds.models.ObstacleModel;
import angrybirds.models.RectangularObstacleModel;
import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;

/**
 * TODO: Description
 *
 * @author User
 */
public class ObstacleView implements View {

    private ObstacleModel model;

    private Image sprite;

    public ObstacleView(ObstacleModel model) {
        this.model = model;
        this.sprite = Tool.getImage("/res/pig.png").getScaledCopy((int)(model.getSize().x * 2), (int)(model.getSize().y * 2));
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {

    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        if (model instanceof CircularObstacleModel)
            sprite.draw((float) (model.getPosition().x - model.getSize().x), (float) (model.getPosition().y - model.getSize().y));
        else if (model instanceof RectangularObstacleModel)
            graphics.fillRect((float)model.getPosition().x, (float)model.getPosition().y, (float)model.getSize().x, (float)model.getSize().y);
    }

}
