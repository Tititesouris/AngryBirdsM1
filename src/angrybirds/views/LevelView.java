package angrybirds.views;

import angrybirds.models.LevelModel;
import angrybirds.models.Model;
import angrybirds.inputs.actions.LevelInputAction;
import angrybirds.updates.actions.LevelUpdateAction;
import angrybirds.updates.actions.UpdateAction;
import angrybirds.utils.Constants;
import angrybirds.views.objects.PigView;
import angrybirds.views.objects.birds.BirdView;
import angrybirds.views.objects.obstacles.ObstacleView;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import java.util.List;

/**
 * TODO: Description
 *
 * @author Tititesouris
 */
public class LevelView extends View {

    private int id;

    private String name;

    private SlingshotView slingshot;

    private List<BirdView> birds;

    private List<ObstacleView> obstacles;

    private List<PigView> pigs;

    private Image background;

    public LevelView(SlingshotView slingshot, List<BirdView> birds, List<ObstacleView> obstacles, List<PigView> pigs) {
        this.slingshot = slingshot;
        this.birds = birds;
        this.obstacles = obstacles;
        this.pigs = pigs;
    }

    @Override
    public void init(Model model) {
        LevelModel level = (LevelModel) model;
        this.id = level.getId();
        this.name = level.getName();
        if (this.background == null) { // Pour éviter de recharger l'image, car il n'y a pas de raison qu'elle change.
            try {
                this.background = new Image("/res/sprites/backgrounds/" + level.getName() + ".jpg");
                this.background = background.getScaledCopy(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
            } catch (SlickException e) {
                e.printStackTrace();
            }
        }
        slingshot.init(level.getSlingshot());
        for (int i = 0; i < birds.size(); i++) {
            birds.get(i).init(level.getBirds().get(i));
        }
        for (int i = 0; i < obstacles.size(); i++) {
            obstacles.get(i).init(level.getObstacles().get(i));
        }
        for (int i = 0; i < pigs.size(); i++) {
            pigs.get(i).init(level.getPigs().get(i));
        }
    }

    @Override
    public void input(Input input) {
        if (input.isKeyDown(Input.KEY_SPACE))
            ready();
        else
            slingshot.input(input);
    }

    @Override
    public void display(Graphics graphics) {
        graphics.drawImage(background, 0, 0);
        graphics.drawString(name, Constants.WINDOW_WIDTH - graphics.getFont().getWidth(name) - 10, 10);
        slingshot.display(graphics);
        for (BirdView bird : birds)
            bird.display(graphics);
        for (ObstacleView obstacle : obstacles)
            obstacle.display(graphics);
        for (PigView pig : pigs)
            pig.display(graphics);
    }

    @Override
    public void onUpdate(UpdateAction updateAction) {
        if (updateAction instanceof LevelUpdateAction.Ready) {
            // L'oiseau s'est arreté, le lance-oiseau vient d'etre préparé à tirer
        }
    }

    public void ready() {
        notifyObservers(new LevelInputAction.Ready(id));
    }

}
