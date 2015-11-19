package tests;

import angrybirds.parametrics.*;
import angrybirds.structures.Vector2d;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Florent Marcaille
 * @author Quentin Brault
 */
public class TestParametrics {

    @Test
    public void testTangent() {
        Parametric linear = new Linear(new Vector2d(0, 0), 1);
        assertTrue(linear.getTangent(0).equals(new Vector2d(1, 0)));
        assertTrue(Math.abs(1 - linear.getTangent(1).x) < 0.0000001);
        assertTrue(Math.abs(1 - linear.getTangent(50).x) < 0.0000001);
    }

    @Test
    public void testLinear() {
        Parametric linear = new Linear(new Vector2d(0, 0), 1);
        assertTrue(linear.getValue(0).equals(new Vector2d(0, 0)));
        assertTrue(linear.getValue(5).equals(new Vector2d(5, 0)));
        assertFalse(linear.getValue(-1).equals(new Vector2d(0, 0)));
    }

    @Test
    public void testSinusoid() {
        Parametric sinusoid = new Sinusoid(new Vector2d(0, 0), 1, 1);
        assertTrue(sinusoid.getValue(0).equals(new Vector2d(0, 0)));
        assertTrue(sinusoid.getValue(Math.PI / 2).equals(new Vector2d(Math.PI / 2, 1)));
        assertFalse(sinusoid.getValue(1).equals(new Vector2d(1, 1)));
    }

    @Test
    public void testSpiral() {
        Parametric spiral = new Spiral(new Vector2d(0, 0), 1, 1);
        assertTrue(spiral.getValue(0).equals(new Vector2d(0, 0)));
        assertTrue(spiral.getValue(1).equals(new Vector2d(Math.cos(1), Math.sin(1))));
    }

    @Test
    public void testBezier() {
        Parametric bezier = new Bezier(new Vector2d(0, 0), new Vector2d[]{
                new Vector2d(0, 0), new Vector2d(100, 100), new Vector2d(100, 0)
        });
        assertTrue(bezier.getValue(0).equals(new Vector2d(0, 0)));
    }


}
