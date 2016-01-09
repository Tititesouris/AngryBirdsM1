package angrybirds.models;

import angrybirds.models.objects.PigModel;
import angrybirds.models.objects.birds.BirdModel;
import angrybirds.models.objects.obstacles.ObstacleModel;
import angrybirds.updates.actions.LevelUpdateAction;

import java.util.List;

/**
 * TODO: Description
 *
 * @author Tititesouris
 */
public class LevelModel extends Model {

    private String name;

    private float ground;

    private SlingshotModel slingshot;

    private List<BirdModel> birds;

    private List<ObstacleModel> obstacles;

    private List<PigModel> pigs;

    public LevelModel(String name, float ground, SlingshotModel slingshot, List<BirdModel> birds, List<ObstacleModel> obstacles, List<PigModel> pigs) {
        this.name = name;
        this.ground = ground;
        this.slingshot = slingshot;
        this.birds = birds;
        this.obstacles = obstacles;
        this.pigs = pigs;
    }

    @Override
    public void update(int delta) {
        slingshot.update(delta);
        for (BirdModel bird : birds)
            bird.update(delta);
        for (ObstacleModel obstacle : obstacles)
            obstacle.update(delta);
        for (PigModel pig : pigs)
            pig.update(delta);
    }

    /**
     * Cette méthode prépare le lance-oiseau à tirer.
     * Elle notifie les observateurs avec LevelUpdateAction.Ready() si il reste au moins un oiseau.
     * Sinon, elle les notifie avec LevelUpdateAction.End()
     */
    public void ready() {
        BirdModel bird = slingshot.getBird();
        if (bird == null) {
            slingshot.ready(birds.get(0));
            notifyObservers(new LevelUpdateAction.Ready());
        }
        else if (birds.indexOf(bird) < birds.size() - 1) {
            slingshot.ready(birds.get(birds.indexOf(bird)));
            notifyObservers(new LevelUpdateAction.Ready());
        }
        else
            notifyObservers(new LevelUpdateAction.End());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getGround() {
        return ground;
    }

    public void setGround(float ground) {
        this.ground = ground;
    }

    public SlingshotModel getSlingshot() {
        return slingshot;
    }

    public void setSlingshot(SlingshotModel slingshot) {
        this.slingshot = slingshot;
    }

    public List<BirdModel> getBirds() {
        return birds;
    }

    public void setBirds(List<BirdModel> birds) {
        this.birds = birds;
    }

    public List<ObstacleModel> getObstacles() {
        return obstacles;
    }

    public void setObstacles(List<ObstacleModel> obstacles) {
        this.obstacles = obstacles;
    }

    public List<PigModel> getPigs() {
        return pigs;
    }

    public void setPigs(List<PigModel> pigs) {
        this.pigs = pigs;
    }

}
