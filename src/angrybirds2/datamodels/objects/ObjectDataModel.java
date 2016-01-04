package angrybirds2.datamodels.objects;

import angrybirds2.datamodels.DataModel;
import angrybirds2.utils.Vector2d;

/**
 * TODO: Description
 *
 * @author Quentin Brault
 */
public abstract class ObjectDataModel extends DataModel {

    protected Vector2d position;

    protected Vector2d velocity;

    protected Vector2d acceleration;

    protected Vector2d size;

    protected float density;

    protected float rotation;

    protected float spin;

    protected boolean gravity;

    public ObjectDataModel(Vector2d position, Vector2d velocity, Vector2d acceleration, Vector2d size, float density, float rotation, float spin, boolean gravity) {
        this.position = position;
        this.velocity = velocity;
        this.acceleration = acceleration;
        this.size = size;
        this.density = density;
        this.rotation = rotation;
        this.spin = spin;
        this.gravity = gravity;
    }

    public Vector2d getPosition() {
        return position;
    }

    public void setPosition(Vector2d position) {
        this.position = position;
    }

    public Vector2d getVelocity() {
        return velocity;
    }

    public void setVelocity(Vector2d velocity) {
        this.velocity = velocity;
    }

    public Vector2d getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(Vector2d acceleration) {
        this.acceleration = acceleration;
    }

    public Vector2d getSize() {
        return size;
    }

    public void setSize(Vector2d size) {
        this.size = size;
    }

    public float getDensity() {
        return density;
    }

    public void setDensity(float density) {
        this.density = density;
    }

    public float getRotation() {
        return rotation;
    }

    public void setRotation(float rotation) {
        this.rotation = rotation;
    }

    public float getSpin() {
        return spin;
    }

    public void setSpin(float spin) {
        this.spin = spin;
    }

    public float getMass() {
        return density * size.x * size.y;
    }

    public float getKineticEnergy() {
        return 0.5f * getMass() * (velocity.x * velocity.x + velocity.y * velocity.y);
    }

    public boolean hasGravity() {
        return gravity;
    }

    public void setGravity(boolean gravity) {
        this.gravity = gravity;
    }

}
