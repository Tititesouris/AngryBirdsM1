package angrybirds.models;

import angrybirds.models.objects.ObjectModel;
import angrybirds.models.objects.PigModel;
import angrybirds.models.objects.birds.BirdModel;
import angrybirds.models.objects.obstacles.ObstacleModel;
import angrybirds.notifications.updates.actions.LevelUpdateAction;

import java.util.*;

/**
 * Cette classe représente les données et actions d'un niveau.
 *
 * @author Quentin Brault
 * @since  2013/10/01
 */
public class LevelModel extends Model {

    /**
     * Nom du niveau.
     */
    private String name;

    /**
     * Hauteur du sol du niveau.
     */
    private float ground;

    /**
     * Lance-oiseau du niveau.
     */
    private SlingshotModel slingshot;

    /**
     * Ensemble des oiseaux du niveau.
     */
    private SortedMap<Integer, BirdModel> birds;

    /**
     * Ensemble des obstacles du niveau.
     */
    private SortedMap<Integer, ObstacleModel> obstacles;

    /**
     * Ensemble des cochons du niveau.
     */
    private SortedMap<Integer, PigModel> pigs;

    /**
     * Liste des objets à retirer du niveau au prochain update().
     */
    private final List<Model> deadModels = new ArrayList<>();

    /**
     * Créé un nouveau niveau.
     *
     * @param name      Nom du niveau.
     * @param ground    Hauteur du sol du niveau.
     * @param slingshot Lance-oiseau du niveau.
     * @param birds     Ensemble des oiseaux du niveau.
     * @param obstacles Ensemble des obstacles du niveau.
     * @param pigs      Ensemble des cochons du niveau.
     */
    public LevelModel(String name, float ground, SlingshotModel slingshot, SortedMap<Integer, BirdModel> birds, SortedMap<Integer, ObstacleModel> obstacles, SortedMap<Integer, PigModel> pigs) {
        this.name = name;
        this.ground = ground;
        this.slingshot = slingshot;
        this.birds = birds;
        this.obstacles = obstacles;
        this.pigs = pigs;
    }

    /**
     * Créé un nouveau niveau.
     *
     * @param name   Nom du niveau.
     * @param ground Hauteur du sol du niveau.
     */
    public LevelModel(String name, float ground) {
        this(name, ground, null, null, null, null);
    }

    @Override
    public void update(int delta) {
        slingshot.update(delta);
        for (BirdModel bird : birds.values())
            bird.update(delta);
        for (ObstacleModel obstacle : obstacles.values())
            obstacle.update(delta);
        for (PigModel pig : pigs.values())
            pig.update(delta);
        checkHits();
        clearDeadModels();
    }

    /**
     * Cette méthode retire du niveau tous les objets morts.
     */
    private void clearDeadModels() {
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

    /**
     * Cette méthode vérifie les collisions entre tous les objets.
     */
    private void checkHits() {
        for (BirdModel bird : birds.values()) {
            if (bird.isFlying()) {
                for (ObstacleModel obstacle : obstacles.values()) {
                    if (bird.collidesWith(obstacle)) {
                        bird.hit(obstacle);
                        obstacle.hit(bird);
                    }
                }
                for (PigModel pig : pigs.values()) {
                    if (bird.collidesWith(pig)) {
                        bird.hit(pig);
                        pig.hit(bird);
                    }
                }
            }
        }
        for (PigModel pig : pigs.values()) {
            for (ObstacleModel obstacle : obstacles.values()) {
                if (pig.collidesWith(obstacle)) {
                    pig.hit(obstacle);
                    obstacle.hit(pig);
                }
            }
        }
    }

    /**
     * Cette méthode ajoute l'oiseau spécifié à la liste
     * des objets à supprimer et notifie les observateurs.
     *
     * @param bird Oiseau à supprimer.
     */
    public void birdDied(BirdModel bird) {
        deadModels.add(bird);
        notifyObservers(new LevelUpdateAction.BirdDied(bird.getId()));
    }

    /**
     * Cette méthode prépare le niveau au lancement du prochain oiseau.
     * Si il reste au moins 1 oiseau à lancer, les observateurs sont
     * notifiés avec un Ready(), sinon il reçoivent un End().
     */
    public void ready() {
        if (birds.size() > 0) {
            slingshot.ready(birds.get(birds.firstKey()));
            notifyObservers(new LevelUpdateAction.Ready());
        }
        else
            notifyObservers(new LevelUpdateAction.End());
    }

    /**
     * Retourne le nom du niveau.
     *
     * @return Nom du niveau.
     */
    public String getName() {
        return name;
    }

    /**
     * Change le nom du niveau par celui spécifié.
     *
     * @param name Nouveau nom du niveau.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retourne la hauteur du sol du niveau.
     *
     * @return Hauteur du sol du niveau.
     */
    public float getGround() {
        return ground;
    }

    /**
     * Change la hauteur du sol du niveau par celle spécifiée.
     *
     * @param ground Hauteur du sol du niveau.
     */
    public void setGround(float ground) {
        this.ground = ground;
    }

    /**
     * Retourne le lance-oiseau du niveau.
     *
     * @return Lance-oiseau du niveau.
     */
    public SlingshotModel getSlingshot() {
        return slingshot;
    }

    /**
     * Change le lance-oiseau du niveau par celui spécifié.
     *
     * @param slingshot Nouveau lance-oiseau du niveau.
     */
    public void setSlingshot(SlingshotModel slingshot) {
        this.slingshot = slingshot;
    }

    /**
     * Retourne l'ensemble des oiseaux du niveau.
     *
     * @return Ensemble des oiseaux du niveau.
     */
    public SortedMap<Integer, BirdModel> getBirds() {
        return birds;
    }

    /**
     * Change l'ensemble des oiseaux du niveau par celui spécifié.
     *
     * @param birds Nouvel ensemble des oiseaux du niveau.
     */
    public void setBirds(SortedMap<Integer, BirdModel> birds) {
        this.birds = birds;
    }

    /**
     * Retourne l'ensemble des obstacles du niveau.
     *
     * @return Ensemble des obstacles du niveau.
     */
    public SortedMap<Integer, ObstacleModel> getObstacles() {
        return obstacles;
    }

    /**
     * Change l'ensemble des obstacles du niveau par celui spécifié.
     *
     * @param obstacles Nouvel ensemble des obstacles du niveau.
     */
    public void setObstacles(SortedMap<Integer, ObstacleModel> obstacles) {
        this.obstacles = obstacles;
    }

    /**
     * Retourne l'ensemble des cochons du niveau.
     *
     * @return Ensemble des cochons du niveau.
     */
    public SortedMap<Integer, PigModel> getPigs() {
        return pigs;
    }

    /**
     * Change l'ensemble des cochons du niveau par celui spécifié.
     *
     * @param pigs Nouvel ensemble des cochons du niveau.
     */
    public void setPigs(SortedMap<Integer, PigModel> pigs) {
        this.pigs = pigs;
    }

}
