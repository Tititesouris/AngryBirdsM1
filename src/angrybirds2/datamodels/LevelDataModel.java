package angrybirds2.datamodels;

import angrybirds2.datamodels.objects.PigDataModel;
import angrybirds2.datamodels.objects.birds.BirdDataModel;
import angrybirds2.datamodels.objects.obstacles.ObstacleDataModel;

import java.util.List;

/**
 * TODO: Description
 *
 * @author Quentin Brault
 */
public class LevelDataModel extends DataModel {

    /**
     * Liste des oiseaux à lancer.
     */
    protected List<BirdDataModel> birds;

    /**
     * Oiseau à lancer ou étant lancé.
     */
    protected BirdDataModel bird;

    /**
     * Lance-oiseau du niveau.
     */
    protected SlingshotDataModel slingshot;

    /**
     * Liste des cochons.
     */
    protected List<PigDataModel> pigs;

    /**
     * Liste des obstacles.
     */
    protected List<ObstacleDataModel> obstacles;

    protected int groundHeight;

    public LevelDataModel(List<BirdDataModel> birds, SlingshotDataModel slingshot, List<PigDataModel> pigs, List<ObstacleDataModel> obstacles) {
        this.birds = birds;
        this.bird = birds.get(0);
        this.slingshot = slingshot;
        this.pigs = pigs;
        this.obstacles = obstacles;
        this.groundHeight = 50;
    }

    public List<BirdDataModel> getBirds() {
        return birds;
    }

    public void setBirds(List<BirdDataModel> birds) {
        this.birds = birds;
    }

    public BirdDataModel getBird() {
        return bird;
    }

    public void setBird(BirdDataModel bird) {
        this.bird = bird;
    }

    public SlingshotDataModel getSlingshot() {
        return slingshot;
    }

    public void setSlingshot(SlingshotDataModel slingshot) {
        this.slingshot = slingshot;
    }

    public List<PigDataModel> getPigs() {
        return pigs;
    }

    public void setPigs(List<PigDataModel> pigs) {
        this.pigs = pigs;
    }

    public List<ObstacleDataModel> getObstacles() {
        return obstacles;
    }

    public void setObstacles(List<ObstacleDataModel> obstacles) {
        this.obstacles = obstacles;
    }

    public int getGroundHeight() {
        return groundHeight;
    }

    public void setGroundHeight(int groundHeight) {
        this.groundHeight = groundHeight;
    }

}
