package angrybirds.models;

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
    private final List<LevelModel> levels;

    /**
     * Niveau en train d'être joué.
     * Null si le joueur n'est pas sur un niveau.
     */
    private LevelModel level;

    public GameModel(List<LevelModel> levels) {
        this.levels = levels;
    }

    public void openLevel(LevelModel level) {
        this.level = level;
    }

    public void closeLevel() {
        this.level = null;
    }

    @Override
    public void init() {

    }

    @Override
    public void update(int delta) {

    }

    public List<LevelModel> getLevels() {
        return levels;
    }

    public LevelModel getLevel() {
        return level;
    }

}
