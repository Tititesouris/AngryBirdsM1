package angrybirds.models;

import angrybirds.structures.Vector2d;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 * TODO: Description
 *
 * @author User
 */
public class ObstacleModel extends GraphicalObjectModel {

    /**
     * Créé un nouvel objet
     *
     * @param position Position de l'objet
     */
    public ObstacleModel(Vector2d position) {
        super(position, new Vector2d(25, 25));
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {

    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException {

    }

}
