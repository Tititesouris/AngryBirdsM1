package tests;

import angrybirds.utils.Vector2d;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Cette classe de test vérifie les propriétés et méthodes de la classe utilitaire Vector2d.
 * @see angrybirds.utils.Vector2d
 *
 * @author Quentin Brault
 * @author Florent Marcaille
 * @since  2016/10/01
 */
public class TestVectors {

    @Test
    public void testEquals() {
        assertTrue(new Vector2d(5, 5).equals(new Vector2d(5, 5)));
        assertFalse(new Vector2d(4, 5).equals(new Vector2d(5, 5)));
        assertTrue(new Vector2d(-4.2f, 5).equals(new Vector2d(-4.2f, 5)));
    }

    @Test
    public void testConstants() {
        assertEquals(Vector2d.ZERO, new Vector2d(0, 0));
        assertEquals(Vector2d.ONE, new Vector2d(1, 1));
        assertEquals(Vector2d.X, new Vector2d(1, 0));
        assertEquals(Vector2d.Y, new Vector2d(0, 1));
        assertEquals(Vector2d.INVERSE, new Vector2d(-1, -1));
    }

    @Test
    public void testSum() {
        assertEquals(new Vector2d(5), Vector2d.ONE.sum(4));
        assertEquals(new Vector2d(2, 3), Vector2d.ZERO.sum(2).sum(new Vector2d(0, 1)));
        assertEquals(new Vector2d(-1, 2.3f), Vector2d.INVERSE.sum(new Vector2d(0, 3.3f)));
    }

    @Test
    public void testDifference() {
        assertEquals(new Vector2d(5), Vector2d.ZERO.difference(-5));
        assertEquals(new Vector2d(-5), Vector2d.ZERO.difference(5));
        assertEquals(Vector2d.X, new Vector2d(-2.2f, 7.7f).difference(new Vector2d(-3.2f, 7.7f)));
    }

    @Test
    public void testProduct() {
        assertEquals(new Vector2d(5), Vector2d.ONE.product(5));
        assertEquals(new Vector2d(10, -5), new Vector2d(5).product(new Vector2d(2, -1)));
        assertEquals(new Vector2d(-3.3f), Vector2d.ONE.product(-3.3f));
    }

    @Test
    public void testHypotenuse() {
        assertTrue(1 == new Vector2d(1, 0).hypotenuse());
        assertTrue(5 == new Vector2d(4, 3).hypotenuse());
        assertFalse(-1 == new Vector2d(-1, 0).hypotenuse());
    }

    @Test
    public void testNormalized() {
        assertEquals(Vector2d.X, new Vector2d(10.5f, 0).normalized());
        assertEquals(Vector2d.Y.product(-1), new Vector2d(0, -4.2f).normalized());
        assertEquals(new Vector2d((float) Math.sqrt(2) / 2), Vector2d.ONE.normalized());
        assertEquals(new Vector2d((float) Math.sqrt(2) / -2), Vector2d.INVERSE.product(3.7f).normalized());
    }

    @Test
    public void testAngle() {
        assertTrue(0 == Vector2d.X.angle());
        assertTrue((float)(-Math.PI * 0.5) == Vector2d.Y.angle());
        assertTrue((float)(Math.PI) == Vector2d.X.product(-1).angle());
        assertTrue((float)(Math.PI * 0.75) == Vector2d.INVERSE.angle());
    }

}
