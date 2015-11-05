package angrybirds.parametrics;

import angrybirds.structures.Vector2d;

/**
 * Cette classe représente une courbe sinusoidale.
 *
 * @author Florent Marcaille
 */
public class Sinusoid extends Parametric {

    /**
     * Période de la sinusoide
     */
    private double period;

    /**
     * Amplitude de la sinusoide
     */
    private double amplitude;

    /**
     * Créé une nouvelle courbe
     *
     * @param offset    Offset de la courbe
     * @param period    Période de la courbe
     * @param amplitude Amplitude de la courbe
     */
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
