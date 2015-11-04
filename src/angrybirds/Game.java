package angrybirds;

import angrybirds.graphics.objects.Bird;
import angrybirds.graphics.objects.Obstacle;
import angrybirds.structures.Vector2d;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * Created by Quentin Brault on 24/09/2015.
 */
public class Game extends BasicGameState {

    /**
     * Générateur de nombres aléatoires
     */
    private static final Random rand = new Random();

    /**
     * variable de l'oiseau
     */
    private Bird bird;

    /**
     *  liste d'obstacles
     */
    private List<Obstacle> obstacles;

    /**
     * Lancement du jeu
     * L'oiseau est à sa position de départ
     * Les obstacles sont à leurs positions de départ
     */
    public Game() {
        reset();
        obstacles = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            obstacles.add(new Obstacle(new Vector2d(900, 100 + i * 150), 25 + rand.nextInt(50)));
        }
    }

    /**
     * Placement de l'oiseau à sa position initiale
     */
    private void reset() {
        bird = new Bird(new Vector2d(0, 100));
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        bird.init(gameContainer, stateBasedGame);
        for (Obstacle obstacle : obstacles) {
            obstacle.init(gameContainer, stateBasedGame);
        }
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException {
        bird.update(gameContainer, stateBasedGame, delta);
        for (Obstacle obstacle : obstacles) {
            obstacle.update(gameContainer, stateBasedGame, delta);
        }
        Obstacle obstacle = obstacleTouch();
        if (obstacle != null) {
            obstacles.remove(obstacle);
            reset();
        }
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        bird.render(gameContainer, stateBasedGame, graphics);
        for (Obstacle obstacle : obstacles) {
            obstacle.render(gameContainer, stateBasedGame, graphics);
        }
    }

    /**
     * Determine la collision entre l'oiseau et l'obstacle
     * Calcul de la collision par le rapport à la distance entre l'hypothénuse des centres de l'oiseau et des obstacles et leurs rayons
     * @return l'obstacle avec lequel l'oiseau est entré en collision
     */
    public Obstacle obstacleTouch(){
    	double obstacleY;
    	double obstacleX;	
    	double birdX = this.bird.getPosition().x;
    	double birdY = this.bird.getPosition().y;
    	double x;
    	double y;
    	double hypo;
    	
    	for(Obstacle obstacle : obstacles){
    		obstacleX = obstacle.getPosition().x;
    		obstacleY = obstacle.getPosition().y;
    		
    		x = obstacleX - birdX;
    		y = obstacleY - birdY;
    		
    		hypo = Math.sqrt((x*x) + (y*y));
    		
    		if(hypo <= this.bird.getRadius() + obstacle.getRadius()){
    			return obstacle;
    		}
    	}
		return null;
    }

    @Override
    public int getID() {
        return 0;
    }

}
