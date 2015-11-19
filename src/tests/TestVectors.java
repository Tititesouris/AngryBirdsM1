package tests;

import angrybirds.structures.Vector2d;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Quentin Brault
 * @author Florent Marcaille
 */
public class TestVectors {

    @Test
    public void testEquals() {
        assertTrue(new Vector2d(5, 5).equals(new Vector2d(5, 5)));
        assertFalse(new Vector2d(4, 5).equals(new Vector2d(5, 5)));
    }

    @Test
    public void testAdd() {
        assertTrue(new Vector2d(5, 5).add(new Vector2d(5, 5)).equals(new Vector2d(10, 10)));
        assertTrue(new Vector2d(6.3, 5.2).add(new Vector2d(5, 3.2)).equals(new Vector2d(11.3, 8.4)));
        assertFalse(new Vector2d(6.3, 5).add(new Vector2d(5, 3.2)).equals(new Vector2d(10, 10)));
    }

    @Test
    public void testProduct() {
        assertTrue(new Vector2d(1.5, 3).product(2).equals(new Vector2d(3, 6)));
        assertTrue(new Vector2d(1.5, -3).product(-2).equals(new Vector2d(-3, 6)));
        assertTrue(new Vector2d(1.5, 3).product(0.5).equals(new Vector2d(0.75, 1.5)));
        assertFalse(new Vector2d(5, 3).product(0.5).equals(new Vector2d(5, 5)));
    }

    @Test
    public void testHypotenuse() {
        assertEquals(5, new Vector2d(3, 4).getHypotenuse(), 0.00001);
        assertEquals(4.24264068, new Vector2d(3, 3).getHypotenuse(), 0.00001);
        assertEquals(4.24264068, new Vector2d(-3, 3).getHypotenuse(), 0.00001);
    }

    @Test
    public void testNormalize() {
        assertTrue(new Vector2d(0, 5).normalize().equals(new Vector2d(0, 1)));
        assertTrue(new Vector2d(1, 0).normalize().equals(new Vector2d(1, 0)));
        assertTrue(new Vector2d(-7.1, 0).normalize().equals(new Vector2d(-1, 0)));
        assertFalse(new Vector2d(5, 5).normalize().equals(new Vector2d(0.5, 0.5)));
    }

}
