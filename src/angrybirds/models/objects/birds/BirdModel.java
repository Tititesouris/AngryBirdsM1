package angrybirds.models.objects.birds;

import angrybirds.models.LevelModel;
import angrybirds.models.SlingshotModel;
import angrybirds.models.objects.CircularObjectModel;
import angrybirds.models.objects.ObjectModel;
import angrybirds.models.objects.RectangularObjectModel;
import angrybirds.notifications.updates.actions.BirdUpdateAction;
import angrybirds.utils.Vector2d;

/**
 * Cette classe représente les données et actions d'un oiseau.
 *
 * @author Quentin Brault
 * @since  2013/10/01
 */
public abstract class BirdModel extends CircularObjectModel {

    /**
     * FIXME: facon temporaire de mourrir
     */
    private long dies;

    /**
     * FIXME: facon temporaire de mourrir
     */
    private boolean dying;

    /**
     * Créé un nouvel oiseau.
     *
     * @param level    Modèle du niveau.
     * @param position Position du centre de l'objet en m.
     * @param size     Taille de l'objet en m.
     * @param density  Densité (ou masse surfacique) de l'objet en kg/m^2.
     */
    public BirdModel(LevelModel level, Vector2d position, Vector2d size, float density) {
        super(level, position, Vector2d.ZERO, Vector2d.ZERO, size, density, 0, 0, true);
    }

    @Override
    public void update(int delta) {
        super.update(delta);
        if (dying && dies < System.currentTimeMillis()) {
            dying = false;
            level.birdDied(this);
            notifyObservers(new BirdUpdateAction.Die());
        }
    }

    /**
     * Cette méthode lance l'oiseau à la vélocité spécifiée et notifie les observateurs.
     *
     * @param velocity Vélocité initiale de l'oiseau.
     */
    public void launch(Vector2d velocity) {
        setGravity(true);
        setVelocity(velocity);
        dying = true;
        dies = System.currentTimeMillis() + 5000;
        notifyObservers(new BirdUpdateAction.Launch());
    }

    /**
     * Cette méthode prépare l'oiseau pour être lancé.
     *
     * @param holderPosition Position du holder du lance-oiseau.
     */
    public void ready(Vector2d holderPosition) {
        setGravity(false);
        setPosition(holderPosition);
        setVelocity(Vector2d.ZERO);
        setAcceleration(Vector2d.ZERO);
        setRotation(0);
        setAngularSpeed(0);
    }

}
