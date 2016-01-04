package angrybirdsold.views;

import angrybirdsold.Tool;
import angrybirdsold.models.BirdModel;
import angrybirdsold.structures.Vector2d;
import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Cette classe affiche l'oiseau
 *
 * @author Quentin Brault
 */
public class BirdView implements View {

    /**
     * Le modèle de l'oiseau
     */
    private BirdModel model;

    /**
     * Image de l'oiseau
     */
    private Image sprite;

    /**
     * Crée une vue pour l'oiseau
     * @param model Modèle de l'oiseau.
     */
    public BirdView(BirdModel model) {
        this.model = model;
        this.sprite = Tool.getImage("/res/bird.png").getScaledCopy((int)(model.getSize().x * 2), (int)(model.getSize().y * 2));
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {

    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        sprite.setRotation(45 + (float)Math.toDegrees(Math.atan2(model.getVelocity().y, model.getVelocity().x)));
        if (model.isHit()) {
            sprite.drawFlash((float) (model.getPosition().x - model.getSize().x), (float) (model.getPosition().y - model.getSize().y));
        }
        else {
            sprite.draw((float) (model.getPosition().x - model.getSize().x), (float) (model.getPosition().y - model.getSize().y));
        }
        graphics.setColor(Color.white);
        for (Vector2d dot : model.getDots()) {
            graphics.fillOval((float)dot.x - 2, (float)dot.y - 2, 4, 4);
        }
    }

}
