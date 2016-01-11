package angrybirds.models.objects.obstacles;

import angrybirds.models.LevelModel;
import angrybirds.models.objects.ObjectModel;
import angrybirds.models.objects.RectangularObjectModel;
import angrybirds.utils.Vector2d;

/**
 * Cette classe représente les données et actions d'un obstacle.
 *
 * @author Quentin Brault
 * @since 2013/10/01
 */
public class ObstacleModel extends RectangularObjectModel {

    /**
     * Modèle du niveau qui possède cet obstacle.
     */
    private LevelModel level;

    /**
     * Matériau de l'obstacle.
     */
    private ObstacleMaterial material;

    /**
     * Créé un nouvel obstacle.
     *
     * @param level        Modèle du niveau qui possède cet obstacle.
     * @param position     Position de l'objet en m.
     * @param size         Taille de l'objet en m.
     * @param rotation     Rotation de l'objet en radians par rapport au 0 du cercle trigonométrique.
     */
    public ObstacleModel(LevelModel level, Vector2d position, ObstacleSize size, ObstacleMaterial material, float rotation) {
        super(position, Vector2d.ZERO, Vector2d.ZERO, size.getSize(), material.getDensity(), rotation, 0, true);
        this.level = level;
        this.material = material;
    }

    /**
     * Retourne le matériau de l'obstacle.
     *
     * @return Matériau de l'obstacle
     */
    public ObstacleMaterial getMaterial() {
        return material;
    }

}
