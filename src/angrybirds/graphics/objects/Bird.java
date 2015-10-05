package angrybirds.graphics.objects;

import angrybirds.Tool;
import angrybirds.graphics.ParametricObject;
import angrybirds.parametrics.Parametric;
import angrybirds.parametrics.Sinusoid;
import angrybirds.parametrics.Spiral;
import angrybirds.structures.Vector2d;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Created by Quentin Brault on 25/09/2015.
 */
public class Bird extends ParametricObject {

    private static final int SIZE = 50;

    private Image sprite;

    public Bird(Vector2d position) {
        super(new Sinusoid(position, 50, 50), 0);
        this.sprite = Tool.getImage("bird.png").getScaledCopy(SIZE, SIZE);
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {

    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        super.render(gameContainer, stateBasedGame, graphics);
        Vector2d tangent = parametric.getTangent(t);
        sprite.setRotation(45 + (float)(Math.atan2(tangent.y, tangent.x) / (2 * Math.PI) * 360));
        sprite.draw((float)position.x - SIZE / 2, (float)position.y - SIZE / 2);
    }

}
