package angrybirds.views;

import angrybirds.notifications.inputs.actions.GameInputAction;
import angrybirds.notifications.updates.actions.GameUpdateAction;
import angrybirds.notifications.updates.actions.UpdateAction;
import angrybirds.utils.Constants;
import org.newdawn.slick.AppGameContainer;
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
     * Créé une vue de jeu.
     *
     * @param id     Identifiant unique du modèle du jeu.
     * @param levels Vues des niveaux du jeu.
     */
    public GameView(int id, SortedMap<Integer, LevelView> levels) {
        super(id);
        this.levels = levels;
    }

    @Override
    public void init() {
        for (LevelView level : levels.values())
            level.init();
    }

    @Override
    public void input(Input input) {
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
        if(level ==null) {

            int width= Constants.WINDOW_WIDTH;
            int height = Constants.WINDOW_HEIGHT;
            int x = 0;
            int y = height/2;
            int xRect=0;
            int nbLevels=levels.size();
            int largeurRect=width/nbLevels-1;
            for (int i = 0; i < nbLevels; i++) {
                x=x+width/nbLevels;
                graphics.drawString(""+(i+1), xRect+largeurRect/2, y);
                graphics.drawRect(xRect,0,largeurRect,height);
               // graphics.drawRect(x,y,graphics.getFont().getWidth(""+i),graphics.getFont().getHeight(""+i));
                xRect+=x;
                x+=x;

            }
        }else{
            level.display(graphics);
        }
    }

    @Override
    public void onUpdate(UpdateAction updateAction) {
        if (updateAction instanceof GameUpdateAction) {
            if (updateAction instanceof GameUpdateAction.EnterLevel)
                enterLevel(((GameUpdateAction.EnterLevel) updateAction).getLevel());
        }
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
