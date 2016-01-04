package angrybirds2.models;

import angrybirds2.datamodels.LevelDataModel;
import angrybirds2.datamodels.SlingshotDataModel;
import angrybirds2.datamodels.objects.birds.BirdDataModel;

import java.util.List;

/**
 * TODO: Description
 *
 * @author Quentin Brault
 */
public class LevelModel extends Model {

    public LevelModel(LevelDataModel dataModel) {
        super(dataModel);
    }

    /**
     * Pose le prochain oiseau sur le lance-oiseau
     */
    public void readyNextBird() {
        LevelDataModel me = getDataModel();
        List<BirdDataModel> birds = me.getBirds();
        SlingshotDataModel slingshot = me.getSlingshot();
        BirdDataModel bird;
        if (me.getBird() == null)
            bird = birds.get(0);
        else
            bird = birds.get(birds.indexOf(me.getBird()) + 1);
        bird.setPosition(slingshot.getPosition().sum(slingshot.getHolderPosition()));
        slingshot.setBird(bird);
        me.setBird(bird);
    }

    @Override
    public void update(int delta) {

    }

    @Override
    protected LevelDataModel getDataModel() {
        return (LevelDataModel) dataModel;
    }

}
