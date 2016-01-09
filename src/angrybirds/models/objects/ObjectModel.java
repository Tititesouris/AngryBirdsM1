package angrybirds.models.objects;

import angrybirds.models.Model;
import angrybirds.notifications.updates.actions.ObjectUpdateAction;
import angrybirds.utils.Constants;
import angrybirds.utils.Vector2d;

/**
 * TODO: Description
 *
 * @author Tititesouris
 */
public abstract class ObjectModel extends Model {

    protected Vector2d position;

    protected Vector2d velocity;

    protected Vector2d acceleration;

    protected Vector2d size;

    protected float density;

    protected float rotation;

    protected float angularSpeed;

    protected boolean gravity;

    public ObjectModel(Vector2d position, Vector2d velocity, Vector2d acceleration, Vector2d size, float density, float rotation, float angularSpeed, boolean gravity) {
        this.position = position;
        this.velocity = velocity;
        this.acceleration = acceleration;
        this.size = size;
        this.density = density;
        this.rotation = rotation;
        this.angularSpeed = angularSpeed;
        this.gravity = gravity;
    }

    @Override
    public void update(int delta) {
        if (gravity)
            accelerate(acceleration.sum(Constants.GRAVITY.product(getMass())).product(delta));
        else
            accelerate(acceleration.product(delta));
        move(velocity.product(delta));
        rotate(angularSpeed * delta);
    }

    public void move(Vector2d distance) {
        if (!distance.equals(Vector2d.ZERO)) {
            setPosition(this.position.sum(distance));
        }
    }

    public void accelerate(Vector2d acceleration) {
        if (!acceleration.equals(Vector2d.ZERO)) {
            setVelocity(this.velocity.sum(acceleration));
        }
    }

    public void rotate(float angle) {
        if (angle > 0) {
            setRotation(this.rotation + angle);
        }
    }

    public float getMass() {
        return density * size.x * size.y;
    }

    public float getKineticEnergy() {
        return 0.5f * getMass() * (velocity.x * velocity.x + velocity.y * velocity.y);
    }

    public Vector2d getPosition() {
        return position;
    }

    public void setPosition(Vector2d position) {
        this.position = position;
        notifyObservers(new ObjectUpdateAction.MoveTo(position));
    }

    public Vector2d getVelocity() {
        return velocity;
    }

    public void setVelocity(Vector2d velocity) {
        this.velocity = velocity;
        notifyObservers(new ObjectUpdateAction.AccelerateTo(velocity));
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
        notifyObservers(new ObjectUpdateAction.RotateTo(rotation));
    }

    public float getAngularSpeed() {
        return angularSpeed;
    }

    public void setAngularSpeed(float angularSpeed) {
        this.angularSpeed = angularSpeed;
    }

    public boolean hasGravity() {
        return gravity;
    }

    public void setGravity(boolean gravity) {
        this.gravity = gravity;
    }

}
