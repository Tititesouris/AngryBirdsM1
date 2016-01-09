package angrybirds.models;

import angrybirds.models.objects.PigModel;
import angrybirds.models.objects.birds.BirdModel;
import angrybirds.models.objects.obstacles.ObstacleModel;
import angrybirds.notifications.updates.actions.LevelUpdateAction;

import java.util.*;

/**
 * TODO: Description
 *
 * @author Tititesouris
 */
public class LevelModel extends Model {

    private String name;

    private float ground;

    private SlingshotModel slingshot;

    private SortedMap<Integer, BirdModel> birds;

    private SortedMap<Integer, ObstacleModel> obstacles;

    private SortedMap<Integer, PigModel> pigs;

    private final List<Model> deadModels = new ArrayList<>();

    public LevelModel(String name, float ground, SlingshotModel slingshot, SortedMap<Integer, BirdModel> birds, SortedMap<Integer, ObstacleModel> obstacles, SortedMap<Integer, PigModel> pigs) {
        this.name = name;
        this.ground = ground;
        this.slingshot = slingshot;
        this.birds = birds;
        this.obstacles = obstacles;
        this.pigs = pigs;
    }

    public LevelModel(String name, float ground) {
        this(name, ground, null, null, null, null);
    }

    @Override
    public void update(int delta) {
        clearDeadModels();

        slingshot.update(delta);

        for (BirdModel bird : birds.values())
            bird.update(delta);
        /*
        for (ObstacleModel obstacle : obstacles.values())
            obstacle.update(delta);

        for (PigModel pig : pigs.values())
            pig.update(delta);*/
    }

    public void clearDeadModels() {
        if (deadModels.size() > 0) {
            for (Model model : deadModels) {
                if (model instanceof BirdModel)
                    birds.remove(model.getId());
                else if (model instanceof ObstacleModel)
                    obstacles.remove(model.getId());
                else if (model instanceof PigModel)
                    pigs.remove(model.getId());
            }
        }
        deadModels.clear();
    }

    public void enter() {
        slingshot.setBird(birds.get(birds.firstKey()));
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

    public SortedMap<Integer, BirdModel> getBirds() {
        return birds;
    }

    public void setBirds(SortedMap<Integer, BirdModel> birds) {
        this.birds = birds;
    }

    public SortedMap<Integer, ObstacleModel> getObstacles() {
        return obstacles;
    }

    public void setObstacles(SortedMap<Integer, ObstacleModel> obstacles) {
        this.obstacles = obstacles;
    }

    public SortedMap<Integer, PigModel> getPigs() {
        return pigs;
    }

    public void setPigs(SortedMap<Integer, PigModel> pigs) {
        this.pigs = pigs;
    }

}
