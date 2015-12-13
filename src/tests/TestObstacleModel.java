package tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.newdawn.slick.SlickException;

import angrybirds.Window;
import angrybirds.models.CircularObstacleModel;
import angrybirds.models.RectangularObstacleModel;
import angrybirds.structures.Vector2d;

/**
 * @author Maxime Catteau
 */
public class TestObstacleModel {

	@Test
	public void testUpdateCircular() throws SlickException {
		CircularObstacleModel obstacle = new CircularObstacleModel(new Vector2d(0,0),
				new Vector2d(1,1), new Vector2d(1,1), 1000);
		
		obstacle.update(Window.getWindow().getContainer(), Window.getWindow(),1);
		
		assertTrue(obstacle.getPosition().equals(new Vector2d(1,1)));
		assertFalse(obstacle.getPosition().equals(new Vector2d(1,2)));
	}

	@Test
	public void testUpdateRectangular() throws SlickException{
		RectangularObstacleModel obstacle = new RectangularObstacleModel(new Vector2d(0,0),
				new Vector2d(1,1), new Vector2d(1,1), 1000);
		
		obstacle.update(Window.getWindow().getContainer(), Window.getWindow(),1);
		
		assertTrue(obstacle.getPosition().equals(new Vector2d(1,1)));
		assertFalse(obstacle.getPosition().equals(new Vector2d(1,2)));
	}
}
