package angrybirds;

import angrybirds.graphics.objects.Bird;
import angrybirds.graphics.objects.Obstacle;
import angrybirds.structures.Constants;
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
 * Cette classe représente le jeu.
 *
 * @author Quentin Brault
 * @author Florent Marcaille
 * @author Maxime Catteau
 */
public class Game extends BasicGameState {

    /**
     * Générateur de nombres aléatoires
     */
    private static final Random rand = new Random();

    /**
     * Oiseau du jeu
     */
    private Bird bird;

    /**
     *  Liste d'obstacles
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
     * Y a-t-il déjà eu contact ce tour
     */
    private boolean touching;

    /**
     * Nombre de millisecondes avant le reset
     */
    private int resetTime;

    /**
     * Nombre de millisecondes avant le départ du vol de l'oiseau
     */
    private int resetting;

    /**
     * Création du jeu.
     * Initialisation des courbes de l'oiseau et des obstacles.
     */
    public Game() {
        birdStart = new Vector2d(50, 650);
        parametrics = new Parametric[]{
                new Linear(birdStart, 17), new Sinusoid(birdStart, 50, 50), new Spiral(birdStart, 20, 5), new Bezier(birdStart, new Vector2d[]{
                birdStart, new Vector2d(200, 100), new Vector2d(500, 250), new Vector2d(600, 350)
        }), new Bezier(birdStart, new Vector2d[]{
                birdStart, new Vector2d(200, 20), new Vector2d(500, 200), new Vector2d(600, 350)
        }), new Bezier(birdStart, new Vector2d[]{
                birdStart, new Vector2d(200, 500), new Vector2d(500, 300), new Vector2d(600, 400)
        }), new Bezier(birdStart, new Vector2d[]{
                birdStart, new Vector2d(200, 100), new Vector2d(500, 250), new Vector2d(500, 350), new Vector2d(800, 550)
        }), new Bezier(birdStart, new Vector2d[]{
                birdStart, new Vector2d(200, 600), new Vector2d(500, 150), new Vector2d(600, 650)
        }), new Bezier(birdStart, new Vector2d[]{
                birdStart, new Vector2d(700, 400), new Vector2d(400, 250), new Vector2d(800, 350)
        }), new Bezier(birdStart, new Vector2d[]{
                birdStart, new Vector2d(200, 100), new Vector2d(500, 100), new Vector2d(900, 0)
        })
        };
        reset();
        obstacles = new ArrayList<>();

        for (int i = 0; i < 5 + rand.nextInt(5); i++) {
            obstacles.add(new Obstacle(new Vector2d(850 + rand.nextInt(100), 50 + i * (50 + rand.nextInt(100))), 10 + rand.nextInt(30)));
        }
    }

    /**
     * Placement de l'oiseau à sa position initiale et reset des variables
     */
    private void reset() {
        bird = new Bird(birdStart, parametrics[currentParam]);
        currentParam = (currentParam + 1) % parametrics.length;
        resetting = 1000;
        touching = false;
        resetTime = 15000;
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
        if (resetting <= 0) {
            if (resetTime > 0) {
                bird.update(gameContainer, stateBasedGame, delta);
                for (Obstacle obstacle : obstacles) {
                    obstacle.update(gameContainer, stateBasedGame, delta);
                }
                Obstacle obstacle = obstacleTouch();
                if (obstacle != null) {
                    if (touching) {
                        if (resetTime <= 1000) {
                            obstacles.remove(obstacle);
                            reset();
                        }
                    } else {
                        bird.hit();
                        obstacle.hit();
                        touching = true;
                        resetTime = 3000;
                    }
                }
                if (outOfScreen()) {
                    reset();
                }
                resetTime -= delta;
            }
            else {
                reset();
            }
        }
        else {
            resetting -= delta;
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
     *
     * @return L'obstacle avec lequel l'oiseau est entré en collision, ou null si aucun
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
     *
     * @return True quand l'oiseau touche un bord de l'écran
     */
    public boolean outOfScreen() {
        if (this.bird.getPosition().x + this.bird.getRadius() >= Constants.SCREEN_WIDTH ||
                this.bird.getPosition().y + this.bird.getRadius() >= Constants.SCREEN_HEIGHT ||
                this.bird.getPosition().x + this.bird.getRadius() <= 0 || this.bird.getPosition().y + this.bird.getRadius() <= 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int getID() {
        return 0;
    }

}
