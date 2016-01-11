package angrybirds.models.objects;

import angrybirds.models.LevelModel;
import angrybirds.utils.Vector2d;

/**
 * Cette classe représente les données et actions d'un cochon.
 *
 * @author Quentin Brault
 * @since  2013/10/01
 */
public class PigModel extends CircularObjectModel {

    /**
     * Modèle du niveau.
     */
    private LevelModel level;

    /**
     * Créé un nouveau cochon.
     *
     * @param level    Modèle du niveau.
     * @param position Position de l'objet en m.
     */
    public PigModel(LevelModel level, Vector2d position) {
        super(position, Vector2d.ZERO, Vector2d.ZERO, new Vector2d(50), 2, 0, 0, true);
        this.level = level;
    }

}
