package angrybirds.models;

import angrybirds.notifications.updates.actions.GameUpdateAction;

import java.util.Map;

/**
 * TODO: Description
 *
 * @author Tititesouris
 */
public class GameModel extends Model {

    /**
     * Liste des niveaux du jeu.
     */
    private Map<Integer, LevelModel> levels;

    /**
     * Niveau en train d'être joué.
     * Null si le joueur n'est pas sur un niveau.
     */
    private LevelModel level;

    public GameModel(Map<Integer, LevelModel> levels) {
        this.levels = levels;
    }

    @Override
    public void update(int delta) {
        if (level != null)
            level.update(delta);
    }

    public void enterLevel(int levelId) {
        level = levels.get(levelId);
        level.ready();
        notifyObservers(new GameUpdateAction.EnterLevel(levelId));
    }

    public LevelModel getLevel() {
        return level;
    }

}
