package angrybirds.views;

import angrybirds.notifications.inputs.actions.LevelInputAction;
import angrybirds.notifications.updates.actions.LevelUpdateAction;
import angrybirds.notifications.updates.actions.UpdateAction;
import angrybirds.utils.Constants;
import angrybirds.views.objects.PigView;
import angrybirds.views.objects.birds.BirdView;
import angrybirds.views.objects.obstacles.ObstacleView;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import java.util.SortedMap;

/**
 * TODO: Description
 *
 * @author Tititesouris
 */
public class LevelView extends View {

    private String name;

    private SlingshotView slingshot;

    private SortedMap<Integer, BirdView> birds;

    private SortedMap<Integer, ObstacleView> obstacles;

    private SortedMap<Integer, PigView> pigs;

    private Image background;

    private boolean birdDied;

    public LevelView(int id, String name, SlingshotView slingshot, SortedMap<Integer, BirdView> birds, SortedMap<Integer, ObstacleView> obstacles, SortedMap<Integer, PigView> pigs) {
        super(id);
        this.name = name;
        this.slingshot = slingshot;
        this.birds = birds;
        this.obstacles = obstacles;
        this.pigs = pigs;
    }

    @Override
    public void init() {
        try {
            this.background = new Image("/res/sprites/backgrounds/" + name + ".jpg");
            this.background = background.getScaledCopy(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
        } catch (SlickException e) {
            e.printStackTrace();
        }

        slingshot.init();
        for (BirdView bird : birds.values())
            bird.init();
        for (ObstacleView obstacle : obstacles.values())
            obstacle.init();
        for (PigView pig : pigs.values())
            pig.init();
    }

    @Override
    public void input(Input input) {
        if (birdDied) {
            if (input.isKeyDown(Input.KEY_SPACE)) {
                notifyObservers(new LevelInputAction.Ready(id));
            }
        }
        slingshot.input(input);
    }

    @Override
    public void display(Graphics graphics) {
        graphics.drawImage(background, 0, 0);
        graphics.drawString(name, Constants.WINDOW_WIDTH - graphics.getFont().getWidth(name) - 10, 10);
        slingshot.display(graphics);
        for (BirdView bird : birds.values())
            bird.display(graphics);
        for (ObstacleView obstacle : obstacles.values())
            obstacle.display(graphics);
        for (PigView pig : pigs.values())
            pig.display(graphics);
    }

    @Override
    public void onUpdate(UpdateAction updateAction) {
        if (updateAction instanceof LevelUpdateAction.Ready) {
            // L'oiseau s'est arreté, le lance-oiseau vient d'etre préparé à tirer
        }
        if (updateAction instanceof LevelUpdateAction.BirdDied) {
            birdDied = true;
        }
    }

}
