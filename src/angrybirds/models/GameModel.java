package angrybirds.models;

import angrybirds.notifications.updates.actions.GameUpdateAction;

import java.util.Map;

/**
 * Cette classe représente les données et actions du jeu.
 *
 * @author Quentin Brault
 * @since  2013/10/01
 */
public class GameModel extends Model {

    /**
     * Ensemble des niveaux du jeu.
     */
    private Map<Integer, LevelModel> levels;

    /**
     * Niveau en train d'être joué.
     * Null si le joueur n'est pas dans un niveau.
     */
    private LevelModel level;

    /**
     * Créé un nouveau jeu.
     *
     * @param levels Ensemble des niveaux du jeu.
     */
    public GameModel(Map<Integer, LevelModel> levels) {
        this.levels = levels;
    }

    @Override
    public void update(int delta) {
        if (level != null)
            level.update(delta);
    }

    /**
     * Cette méthode modifie le niveau qui est joué et notifie les observateurs.
     *
     * @param levelId Id du modèle du niveau à jouer.
     */
    public void enterLevel(int levelId) {
        level = levels.get(levelId);
        level.ready();
        notifyObservers(new GameUpdateAction.EnterLevel(levelId));
    }

    /**
     * Cette méthode retourne le niveau qui est en train d'être joué.
     * Elle retourne null si le joueur n'est pas dans un niveau.
     *
     * @return Niveau qui est en train d'être joué, ou null si le joueur n'est pas dans un niveau.
     */
    public LevelModel getLevel() {
        return level;
    }

}
