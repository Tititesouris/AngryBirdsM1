package angrybirds.controllers.objects;

import angrybirds.controllers.Controller;
import angrybirds.exceptions.AngryBirdsException;
import angrybirds.exceptions.UnknownObstacleMaterialException;
import angrybirds.exceptions.UnknownObstacleSizeException;
import angrybirds.models.objects.obstacles.ObstacleMaterial;
import angrybirds.models.objects.obstacles.ObstacleModel;
import angrybirds.models.objects.obstacles.ObstacleSize;
import angrybirds.utils.ModelViewPair;
import angrybirds.inputs.actions.InputAction;
import angrybirds.utils.Vector2d;
import angrybirds.views.objects.ObjectView;
import angrybirds.views.objects.obstacles.ObstacleView;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/**
 * TODO: Description
 *
 * @author Tititesouris
 */
public class ObstacleController extends Controller {

    public ObstacleController(JsonArray obstacles) throws AngryBirdsException {
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
                    new Vector2d(position.get(0).getAsFloat(), position.get(1).getAsFloat()),
                    Vector2d.ZERO, Vector2d.ZERO,
                    obstacleSize, obstacleMaterial,
                    0, 0);
            ObstacleView view = new ObstacleView();
            addModelViewPair(new ModelViewPair<>(model, view));
        }
    }

    @Override
    public void onInput(InputAction inputAction) {

    }

}
