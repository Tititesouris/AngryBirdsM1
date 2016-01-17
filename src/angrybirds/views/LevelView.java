package angrybirds.views;

import angrybirds.notifications.inputs.actions.LevelInputAction;
import angrybirds.notifications.updates.actions.LevelUpdateAction;
import angrybirds.notifications.updates.actions.UpdateAction;
import angrybirds.utils.Constants;
import angrybirds.views.objects.PigView;
import angrybirds.views.objects.birds.BirdView;
import angrybirds.views.objects.obstacles.ObstacleView;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import java.util.SortedMap;

/**
 * Cette classe représente une vue de niveau.
 *
 * @author Quentin Brault
 * @since  2013/10/01
 */
public class LevelView extends View {

    /**
     * Nom du niveau.
     */
    private String name;

    /**
     * Vue du lance-oiseau du niveau.
     */
    private SlingshotView slingshot;

    /**
     * Vues des oiseaux du niveau.
     */
    private SortedMap<Integer, BirdView> birds;

    /**
     * Vues des obstacles du niveau.
     */
    private SortedMap<Integer, ObstacleView> obstacles;

    /**
     * Vues des cochons du niveau.
     */
    private SortedMap<Integer, PigView> pigs;

    /**
     * Hauteur du sol du niveau.
     */
    private float ground;

    /**
     * True si un oiseau vient de mourir, false sinon.
     */
    private boolean birdDied;

    /**
     * True si le niveau est terminé, false sinon.
     */
    private boolean levelEnded;

    /**
     * Image du fond du niveau.
     */
    private Image background;

    /**
     * Créé une vue de niveau.
     *
     * @param id        Identifiant unique du modèle du niveau.
     * @param name      Nom du niveau.
     * @param slingshot Vue du lance-oiseau du niveau.
     * @param birds     Vues des oiseaux du niveau.
     * @param obstacles Vues des obstacles du niveau.
     * @param pigs      Vues des cochons du niveau.
     * @param ground    Hauteur du sol.
     */
    public LevelView(int id, String name, SlingshotView slingshot, SortedMap<Integer, BirdView> birds, SortedMap<Integer, ObstacleView> obstacles, SortedMap<Integer, PigView> pigs, float ground) {
        super(id);
        this.name = name;
        this.slingshot = slingshot;
        this.birds = birds;
        this.obstacles = obstacles;
        this.pigs = pigs;
        this.ground = ground;
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
            if (input.isKeyDown(Input.KEY_SPACE))
                notifyObservers(new LevelInputAction.Ready(id));
        }
        else {
            slingshot.input(input);
            for (BirdView bird : birds.values())
                bird.input(input);
            for (ObstacleView obstacle : obstacles.values())
                obstacle.input(input);
            for (PigView pig : pigs.values())
                pig.input(input);
        }
    }

    @Override
    public void display(Graphics graphics) {
        graphics.drawImage(background, 0, 0);
        graphics.setColor(Color.black);
        graphics.drawString(name, Constants.WINDOW_WIDTH - graphics.getFont().getWidth(name) - 10, 10);
        
        slingshot.display(graphics);
        for (BirdView bird : birds.values())
            bird.display(graphics);
        for (ObstacleView obstacle : obstacles.values())
            obstacle.display(graphics);
        for (PigView pig : pigs.values())
            pig.display(graphics);
    }

    /**
     * Cette méthode affiche le niveau en mode débug.
     *
     * @param graphics Contexte graphique.
     */
    public void displayDebug(Graphics graphics) {
        graphics.setColor(Color.white);
        graphics.fillRect(0, 0, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
        graphics.setColor(Color.black);
        graphics.drawString(name, Constants.WINDOW_WIDTH - graphics.getFont().getWidth(name) - 10, 10);
        graphics.drawLine(0, Constants.WINDOW_HEIGHT - ground, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT - ground);

        if (levelEnded) {
            graphics.drawString("LEVEL IS OVER", 250, 50);
        }

        slingshot.displayDebug(graphics);
        for (BirdView bird : birds.values())
            bird.displayDebug(graphics);
        for (ObstacleView obstacle : obstacles.values())
            obstacle.displayDebug(graphics);
        for (PigView pig : pigs.values())
            pig.displayDebug(graphics);
    }

    @Override
    public void onUpdate(UpdateAction updateAction) {
        if (updateAction instanceof LevelUpdateAction.BirdDied) {
            birdDied(((LevelUpdateAction.BirdDied) updateAction).getBirdId());
        }
        else if (updateAction instanceof LevelUpdateAction.Ready) {
            ready();
        }
        else if (updateAction instanceof LevelUpdateAction.End) {
            end();
        }
    }

    /**
     * Cette méthode doit être appellée quand le modèle prévient qu'un oiseau vient de mourir.
     *
     * @param birdId Identifiant unique du modèle de l'oiseau qui est mort.
     */
    private void birdDied(int birdId) {
        birds.remove(birdId);
        birdDied = true;
    }

    /**
     * Cette méthode doit être appellée quand le modèle prévient que le niveau est prêt.
     */
    private void ready() {
        birdDied = false;
        System.out.println("READY");
    }

    /**
     * Cette méthode doit être appellée quand le modèle prévient que le niveau est terminé.
     */
    private void end() {
        levelEnded = true;
    }

}
