package angrybirds.controllers.objects;

import angrybirds.controllers.Controller;
import angrybirds.exceptions.AngryBirdsException;
import angrybirds.exceptions.UnknownObstacleMaterialException;
import angrybirds.exceptions.UnknownObstacleSizeException;
import angrybirds.models.LevelModel;
import angrybirds.models.objects.obstacles.ObstacleMaterial;
import angrybirds.models.objects.obstacles.ObstacleModel;
import angrybirds.models.objects.obstacles.ObstacleSize;
import angrybirds.utils.ModelViewPair;
import angrybirds.notifications.inputs.actions.InputAction;
import angrybirds.utils.Vector2d;
import angrybirds.views.objects.obstacles.ObstacleMaterialView;
import angrybirds.views.objects.obstacles.ObstacleView;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/**
 * Cette classe représente le controlleur pour les obstacles.
 *
 * @author Quentin Brault
 * @since  2013/10/01
 */
public class ObstacleController extends Controller {

    /**
     * Créé un nouveau controlleur pour obstacles.
     *
     * @param obstacles Liste des descriptions d'obstacle.
     * @param level     Modèle du niveau.
     * @throws AngryBirdsException
     */
    public ObstacleController(JsonArray obstacles, LevelModel level) throws AngryBirdsException {
        for (JsonElement element : obstacles) {
            JsonObject obstacle = element.getAsJsonObject();
            JsonArray position = obstacle.get("position").getAsJsonArray();
            String size = obstacle.get("size").getAsString();
            String material = obstacle.get("material").getAsString();

            ObstacleSize obstacleSize = ObstacleSize.valueOf(size);
            if (obstacleSize == null)
                throw new UnknownObstacleSizeException();
            ObstacleMaterial obstacleMaterial = ObstacleMaterial.valueOf(material);
            if (obstacleMaterial == null)
                throw new UnknownObstacleMaterialException();
            ObstacleModel model = new ObstacleModel(
                    level,
                    new Vector2d(position.get(0).getAsFloat(), position.get(1).getAsFloat()),
                    obstacleSize, obstacleMaterial,
                    obstacle.get("rotation").getAsFloat());
            ObstacleView view = new ObstacleView(model.getId(), model.getPosition(), model.getSize(), model.getRotation(), ObstacleMaterialView.valueOf(model.getMaterial().name()));
            addModelViewPair(new ModelViewPair<>(model, view));
        }
    }

    @Override
    public void onInput(InputAction inputAction) {

    }

}
