package tests;

import angrybirds.parametrics.Linear;
import angrybirds.parametrics.Parametric;
import angrybirds.parametrics.Sinusoid;
import angrybirds.structures.Vector2d;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Quentin Brault on 02/10/2015.
 */
public class TestParametrics {

    @Test
    public void testlinear() {
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

}
