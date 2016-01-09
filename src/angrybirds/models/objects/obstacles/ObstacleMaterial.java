package angrybirds.models.objects.obstacles;

/**
 * TODO: Description
 *
 * @author Tititesouris
 */
public enum ObstacleMaterial {

    GLASS(0.25f), WOOD(0.5f), STONE(1);

    private float density;

    ObstacleMaterial(float density) {
        this.density = density;
    }

    public float getDensity() {
        return density;
    }

}
