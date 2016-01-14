package angrybirds.views;

import angrybirds.notifications.inputs.actions.GameInputAction;
import angrybirds.notifications.updates.actions.GameUpdateAction;
import angrybirds.notifications.updates.actions.UpdateAction;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

import java.util.SortedMap;

/**
 * Cette classe représente une vue de jeu.
 *
 * @author Quentin Brault
 * @since  2013/10/01
 */
public class GameView extends View {

    /**
     * Vues des niveaux du jeu.
     */
    private SortedMap<Integer, LevelView> levels;

    /**
     * Vue du niveau actif du jeu.
     */
    private LevelView level;

    /**
     * True si le jeu est en mode débug.
     */
    private boolean debug;

    /**
     * Créé une vue de jeu.
     *
     * @param id     Identifiant unique du modèle du jeu.
     * @param levels Vues des niveaux du jeu.
     */
    public GameView(int id, SortedMap<Integer, LevelView> levels, boolean debug) {
        super(id);
        this.levels = levels;
        this.debug = debug;
    }

    @Override
    public void init() {
        for (LevelView level : levels.values())
            level.init();
    }

    @Override
    public void input(Input input) {
        if (input.isKeyDown(Input.KEY_D))
            notifyObservers(new GameInputAction.SwitchDebug(id));
        if (level == null) {
            if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
                LevelView levelSelected = levels.get(levels.firstKey());
                notifyObservers(new GameInputAction.EnterLevel(id, levelSelected.id));
            }
        } else
            level.input(input);
    }

    @Override
    public void display(Graphics graphics) {
        if (debug)
            displayDebug(graphics);
        else if (level == null) {

        }
        else {
            level.display(graphics);
        }
    }

    /**
     * Cette méthode affiche le jeu en mode débug.
     *
     * @param graphics Contexte graphique.
     */
    public void displayDebug(Graphics graphics) {
        if (level == null) {
            int x = 200;
            int y = 200;
            for (int i = 0; i < levels.size(); i++) {
                graphics.drawString("" + (i + 1), x, y);
                graphics.drawRect(x, y, graphics.getFont().getWidth("" + i), graphics.getFont().getHeight("" + i));
                x += 100;
            }
        } else {
            level.displayDebug(graphics);
        }
    }

    @Override
    public void onUpdate(UpdateAction updateAction) {
            if (updateAction instanceof GameUpdateAction.EnterLevel)
                enterLevel(((GameUpdateAction.EnterLevel) updateAction).getLevel());
        else if (updateAction instanceof GameUpdateAction.SwitchDebug)
            debug = ((GameUpdateAction.SwitchDebug) updateAction).isDebug();
    }

    /**
     * Cette méthode doit être appellée quand le modèle prévient qu'on rentre dans un niveau.
     *
     * @param levelId Identifiant unique du niveau entré.
     */
    private void enterLevel(int levelId) {
        this.level = levels.get(levelId);
    }

}
