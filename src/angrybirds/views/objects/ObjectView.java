package angrybirds.views.objects;

import angrybirds.notifications.updates.actions.ObjectUpdateAction;
import angrybirds.notifications.updates.actions.UpdateAction;
import angrybirds.utils.Vector2d;
import angrybirds.views.View;
import angrybirds.views.objects.birds.YellowBirdView;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

/**
 * Cette classe représente une vue d'objet.
 *
 * @author Quentin Brault
 * @since  2013/10/01
 */
public abstract class ObjectView extends View {

    /**
     * Position du centre de l'objet.
     */
    protected Vector2d position;

    /**
     * Taille de l'objet.
     */
    protected Vector2d size;

    /**
     * Angle de rotation de l'objet.
     */
    protected float rotation;

    /**
     * True si l'objet a été touché, false sinon.
     */
    protected boolean hit;

    /**
     * Image de l'objet.
     */
    protected Image sprite;

    /**
     * Créé une vue d'objet.
     *
     * @param id       Identifiant unique du modèle de l'objet.
     * @param position Position du centre de l'objet.
     * @param size     Taille de l'objet.
     * @param rotation Angle de rotation de l'objet.
     */
    public ObjectView(int id, Vector2d position, Vector2d size, float rotation) {
        super(id);
        this.position = position;
        this.size = size;
        this.rotation = rotation;
    }

    /**
     * Cette méthode affiche l'objet en mode débug.
     *
     * @param graphics Contexte graphique.
     */
    public abstract void displayDebug(Graphics graphics);

    @Override
    public void onUpdate(UpdateAction updateAction) {
        if (updateAction instanceof ObjectUpdateAction.MoveTo) {
            moveTo(((ObjectUpdateAction.MoveTo) updateAction).getPosition());
        }
        else if (updateAction instanceof ObjectUpdateAction.RotateTo) {
            rotateTo(((ObjectUpdateAction.RotateTo) updateAction).getRotation());
        }
        else if (updateAction instanceof ObjectUpdateAction.Hit) {
        	hit();
        }
    }

    /**
     * Cette méthode doit être appellée quand le modèle prévient que l'objet a été déplacé.
     *
     * @param position Nouvelle position de l'objet.
     */
    protected void moveTo(Vector2d position) {
        this.position = position;
    }

    /**
     * Cette méthode doit être appellée quand le modèle prévient que l'objet a été tourné.
     *
     * @param rotation Nouvelle rotation de l'objet.
     */
    protected void rotateTo(float rotation) {
        this.rotation = rotation;
        sprite.setRotation((float) (rotation * -180 / Math.PI));
    }

    /**
     * Cette méthode doit être appellée quand le modèle prévient que l'objet a été touché.
     */
    protected void hit(){
    	hit = true;
    }

}
