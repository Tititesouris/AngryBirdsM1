package angrybirds.parametrics;

import angrybirds.structures.Vector2d;

/**
 * Created by Quentin Brault on 02/10/2015.
 */
public class Sinusoid extends Parametric {

    private double period;

    private double amplitude;

    public Sinusoid(Vector2d offset, double period, double amplitude) {
        super(offset);
        this.period = period;
        this.amplitude = amplitude;
    }

    @Override
    public Vector2d getValue(double t) {
        return new Vector2d(period * t + offset.x, amplitude * Math.sin(t) + offset.y);
    }

    @Override
    public String toString() {
        return "Sinusoid(X: " + period + " * t + " + offset.x + ", Y: " + amplitude + " * sin(t) + " + offset.y + ")";
    }

}
