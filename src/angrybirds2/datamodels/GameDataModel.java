package angrybirds2.datamodels;

import java.util.List;

/**
 * TODO: Description
 *
 * @author Quentin Brault
 */
public class GameDataModel extends DataModel {

    /**
     * Liste des niveaux du jeu.
     */
    protected List<LevelDataModel> levels;

    public GameDataModel(List<LevelDataModel> levels) {
        this.levels = levels;
    }

    public List<LevelDataModel> getLevels() {
        return levels;
    }

    public void setLevels(List<LevelDataModel> levels) {
        this.levels = levels;
    }

}
