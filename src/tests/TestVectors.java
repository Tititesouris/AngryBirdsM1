package tests;

import angrybirds.structures.Vector2d;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Quentin Brault on 02/10/2015.
 */
public class TestVectors {

    @Test
    public void testEquals() {
        assertTrue(new Vector2d(5, 5).equals(new Vector2d(5, 5)));
        assertFalse(new Vector2d(4, 5).equals(new Vector2d(5, 5)));
    }

}
