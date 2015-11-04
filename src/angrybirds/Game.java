package angrybirds;

import angrybirds.graphics.objects.Bird;
import angrybirds.graphics.objects.Obstacle;
import angrybirds.structures.Constantes;
import angrybirds.parametrics.*;
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
     * Position initiale de l'oiseau
     */
    private Vector2d birdStart;

    /**
     * Liste des courbes de l'oiseau
     */
    private Parametric[] parametrics;

    /**
     * Identifiant de la courbe actuelle de l'oiseau
     */
    private int currentParam;

    /**
     * Lancement du jeu
     * L'oiseau est à sa position de départ
     * Les obstacles sont à leurs positions de départ
     */
    public Game() {
        birdStart = new Vector2d(50, 650);
        parametrics = new Parametric[]{
                new Linear(birdStart, 17), new Sinusoid(birdStart, 50, 50), new Spiral(birdStart, 20, 5), new Bezier(birdStart, new Vector2d[]{
                birdStart, new Vector2d(200, 100), new Vector2d(500, 250), new Vector2d(600, 350)
        }), new Bezier(birdStart, new Vector2d[]{
                birdStart, new Vector2d(200, 20), new Vector2d(500, 600), new Vector2d(600, 350)
        }), new Bezier(birdStart, new Vector2d[]{
                birdStart, new Vector2d(200, 500), new Vector2d(500, 300), new Vector2d(600, 100)
        }), new Bezier(birdStart, new Vector2d[]{
                birdStart, new Vector2d(200, 100), new Vector2d(500, 250), new Vector2d(300, 350), new Vector2d(800, 150)
        }), new Bezier(birdStart, new Vector2d[]{
                birdStart, new Vector2d(200, 600), new Vector2d(500, 150), new Vector2d(600, 650)
        }), new Bezier(birdStart, new Vector2d[]{
                birdStart, new Vector2d(700, 400), new Vector2d(400, 150), new Vector2d(800, 350)
        }), new Bezier(birdStart, new Vector2d[]{
                birdStart, new Vector2d(200, 100), new Vector2d(500, 100), new Vector2d(600, 550)
        })
        };
        reset();
        obstacles = new ArrayList<>();

        for (int i = 0; i < 5 + rand.nextInt(5); i++) {
            obstacles.add(new Obstacle(new Vector2d(850 + rand.nextInt(100), 50 + i * (50 + rand.nextInt(100))), 10 + rand.nextInt(30)));
        }
    }

    /**
     * Placement de l'oiseau à sa position initiale
     */
    private void reset() {
        bird = new Bird(birdStart, parametrics[currentParam]);
        currentParam = (currentParam + 1) % parametrics.length;
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
        if(outOfScreen()){
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

    /**
     * Determine le passage de l'oiseau hors de l'ecran
     * @return true quand l'oiseau atteint le bord droit ou le sommet de l ecran
     */
    public boolean outOfScreen(){
        if(this.bird.getPosition().x+this.bird.getRadius() >= Constantes.SCREEN_LENGTH || this.bird.getPosition().y+this.bird.getRadius() >= Constantes.SCREEN_WIDTH){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public int getID() {
        return 0;
    }

}
