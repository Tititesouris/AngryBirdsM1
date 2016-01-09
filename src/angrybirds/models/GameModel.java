package angrybirds.models;

import angrybirds.updates.actions.GameUpdateAction;

import java.util.List;

/**
 * TODO: Description
 *
 * @author Tititesouris
 */
public class GameModel extends Model {

    /**
     * Liste des niveaux du jeu.
     */
    private List<LevelModel> levels;

    /**
     * Niveau en train d'être joué.
     * Null si le joueur n'est pas sur un niveau.
     */
    private LevelModel level;

    public GameModel(List<LevelModel> levels) {
        this.levels = levels;
    }

    @Override
    public void update(int delta) {
        if (level != null)
            level.update(delta);
    }

    public void enterLevel(int id) {
        this.level = levels.get(id);
        notifyObservers(new GameUpdateAction.EnterLevel(id));
    }

    public List<LevelModel> getLevels() {
        return levels;
    }

    public void setLevels(List<LevelModel> levels) {
        this.levels = levels;
    }

    public LevelModel getLevel() {
        return level;
    }

    public void setLevel(LevelModel level) {
        this.level = level;
    }

}
