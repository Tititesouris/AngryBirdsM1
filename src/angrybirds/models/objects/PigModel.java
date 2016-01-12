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
     * Créé un nouveau cochon.
     *
     * @param level    Modèle du niveau.
     * @param position Position du centre de l'objet en m.
     */
    public PigModel(LevelModel level, Vector2d position) {
        super(level, position, Vector2d.ZERO, Vector2d.ZERO, new Vector2d(50), 0.01f, 0, 0, true);
    }

}
