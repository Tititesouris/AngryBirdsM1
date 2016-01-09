package angrybirds.models.objects.obstacles;

import angrybirds.models.LevelModel;
import angrybirds.models.objects.ObjectModel;
import angrybirds.utils.Vector2d;

/**
 * TODO: Description
 *
 * @author Tititesouris
 */
public class ObstacleModel extends ObjectModel {

    private LevelModel level;

    private ObstacleMaterial material;

    public ObstacleModel(LevelModel level, Vector2d position, Vector2d velocity, Vector2d acceleration, ObstacleSize size, ObstacleMaterial material, float rotation, float angularSpeed) {
        super(position, velocity, acceleration, size.getSize(), material.getDensity(), rotation, angularSpeed, true);
        this.level = level;
        this.material = material;
    }

    public ObstacleMaterial getMaterial() {
        return material;
    }

}
