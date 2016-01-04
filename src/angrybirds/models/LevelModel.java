package angrybirds.models;

import angrybirds.controllers.BirdController;
import angrybirds.models.objects.birds.BirdModel;

import java.util.List;

/**
 * TODO: Description
 *
 * @author Tititesouris
 */
public class LevelModel extends Model {

    private String name;

    private List<BirdModel> birds;

    private SlingshotModel slingshot;

    public LevelModel(String name, List<BirdModel> birds, SlingshotModel slingshot) {
        this.name = name;
        this.birds = birds;
        this.slingshot = slingshot;
    }

    @Override
    public void init() {

    }

    @Override
    public void update(int delta) {

    }

    public void start() {
        nextBird();
    }

    public void nextBird() {
        BirdModel bird = slingshot.getBird();
        if (bird == null)
            slingshot.setBird(birds.get(0));
        else if (birds.indexOf(bird) < birds.size() - 1)
            slingshot.setBird(birds.get(birds.indexOf(bird)));
        else
            System.out.println("Fin du niveau");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BirdModel> getBirds() {
        return birds;
    }

    public void setBirds(List<BirdModel> birds) {
        this.birds = birds;
    }

    public SlingshotModel getSlingshot() {
        return slingshot;
    }

    public void setSlingshot(SlingshotModel slingshot) {
        this.slingshot = slingshot;
    }

}
