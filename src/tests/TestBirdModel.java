package tests;

/*
 * 
 * @author Maxime Catteau
 */

import static org.junit.Assert.*;

import org.junit.Test;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import angrybirds.Window;
import angrybirds.models.BirdModel;
import angrybirds.models.GraphicalObjectModel;
import angrybirds.models.VectorObjectModel;
import angrybirds.structures.Vector2d;

public class TestBirdModel {

	//Test de l'update du modele de l'oiseau
	@Test
	public void testUpdateBird() throws SlickException {
		BirdModel b = new BirdModel(0,0);
		b.setVelocity(1, 1);
		b.setAcceleration(0, 0);
		b.update(Window.getWindow().getContainer(),
				Window.getWindow(), 1);
		
		assertTrue(b.getPosition().equals(new Vector2d(1, 1)));
		assertFalse(b.getPosition().equals(new Vector2d(1, 2)));
	}

}
