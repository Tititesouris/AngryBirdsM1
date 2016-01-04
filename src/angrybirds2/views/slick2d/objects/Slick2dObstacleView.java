package angrybirds2.views.slick2d.objects;

import angrybirds2.views.slick2d.Slick2dView;
import angrybirdsold.models.ObstacleModel;
import angrybirdsold.views.ObstacleView;

/**
 * TODO: Description
 *
 * @author Tititesouris
 */
public class Slick2dObstacleView extends ObstacleView implements Slick2dView {

    /**
     * Crée une vue de l'obstacle
     *
     * @param model Modèle de l'obstacle
     */
    public Slick2dObstacleView(ObstacleModel model) {
        super(model);
    }

}
