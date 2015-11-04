package tests;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

import angrybirds.Game;
import org.junit.Before;
import org.junit.Test;

import angrybirds.graphics.objects.*;
import angrybirds.structures.*;

public class TestCollision {

	private Bird bird;
	private List<Obstacle> obstacles;
	private static final Random rand = new Random();
	
	@Before
	public void init(){
		bird = new Bird(new Vector2d(0,100));
		obstacles = new ArrayList<>();
		
		for (int i = 0; i < 5; i++) {
            obstacles.add(new Obstacle(new Vector2d(900, 100 + i * 150), 25 + rand.nextInt(50)));
        }
		
		for(Obstacle obs : obstacles){
			
		}
	}

	@Test
	public void testCollisionCentered(){
		Bird bird = new Bird(new Vector2d(900,100));
		Obstacle obstacle = new Obstacle(new Vector2d(900,100), bird.getRadius());

		//Game game = new Game();
		//game.obstacleTouch();

		/*if(obstacleTouch() != null){
			// probleme recuperation du this.bird
			// nb : calculer de tete la position du bird et le mettre direct en contact
		}*/
	}
}
