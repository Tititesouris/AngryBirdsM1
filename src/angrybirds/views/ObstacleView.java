package angrybirds.views;

import angrybirds.Tool;
import angrybirds.models.ObstacleModel;
import angrybirds.structures.Vector2d;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 * TODO: Description
 *
 * @author User
 */
public class ObstacleView implements View {

    private ObstacleModel model;

    //private Image sprite;

    public ObstacleView(ObstacleModel model) {
        this.model = model;
        //this.sprite = Tool.getImage("/res/bird.png").getScaledCopy((int)(model.getSize().x * 2), (int)(model.getSize().y * 2));
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {

    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        /*sprite.setRotation(45 + (float)Math.toDegrees(Math.atan2(model.getVelocity().y, model.getVelocity().x)));
        if (model.isHit()) {
            sprite.drawFlash((float) (model.getPosition().x - model.getSize().x), (float) (model.getPosition().y - model.getSize().y));
        }
        else {
            sprite.draw((float) (model.getPosition().x - model.getSize().x), (float) (model.getPosition().y - model.getSize().y));
        }
        graphics.setColor(Color.white);
        for (Vector2d dot : model.getDots()) {
            graphics.fillOval((float)dot.x - 2, (float)dot.y - 2, 4, 4);
        }*/
    }

}
