package angrybirds.views.objects.birds;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Ellipse;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.particles.ConfigurableEmitter;
import org.newdawn.slick.particles.ParticleIO;
import org.newdawn.slick.particles.ParticleSystem;

import angrybirds.notifications.inputs.actions.BirdInputAction;
import angrybirds.notifications.updates.actions.BirdUpdateAction;
import angrybirds.notifications.updates.actions.UpdateAction;
import angrybirds.utils.Vector2d;
import angrybirds.views.objects.ObjectView;

/**
 * Cette classe représente une vue d'oiseau.
 *
 * @author Quentin Brault
 * A contribué : Maxime Catteau
 * @since  2013/10/01
 */
public abstract class BirdView extends ObjectView {

    /**
     * Liste des points parcouru par l'oiseau.
     */
    private List<Vector2d> trail;

    /**
     * True si l'oiseau est en vol, false sinon.
     */
    protected boolean flying;

    /**
     * Contient la position du dernier point placé
     */
    private Vector2d lastDot = position;

    /**
     * Couleur de l'oiseau.
     */
    protected Color color;
   
    /**
     * Systeme de particules
     */
    private ParticleSystem system;
    
    /**
     * Texture des particules représentées
     */
    private Image particleSprite;
    
    /**
     * Emetteur de particules
     */
    private ConfigurableEmitter emitter;
    
    /**
     * Regarde si le pouvoir a été utilisé
     */
    private boolean ability;

    /**
     * Créé une vue d'oiseau.
     *
     * @param id       Identifiant unique du modèle d'oiseau.
     * @param position Position de l'oiseau.
     * @param size     Taille de l'oiseau.
     * @param rotation Angle de rotation de l'oiseau.
     */
    public BirdView(int id, Vector2d position, Vector2d size, float rotation) {
        super(id, position, size, rotation);
        this.trail = new ArrayList<>();
    }
    
    @Override
    public void init() {
    	try {
			particleSprite = new Image("/res/sprites/particles/particle.png", false);
			//1000 représente le nombre de particules max par frame
			system = new ParticleSystem(particleSprite, 1000);

            File xmlFile = new File("res/sprites/particles/particle.xml");
			emitter = ParticleIO.loadEmitter(xmlFile);
			//emitter.setPosition((int) position.x - size.x / 2, (int) position.y - size.y / 2);
			system.addEmitter(emitter);
			
			system.setBlendingMode(ParticleSystem.BLEND_ADDITIVE);
			
		} catch (SlickException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @Override
    public void input(Input input) {
        if (flying && input.isKeyDown(Input.KEY_SPACE)) {
            notifyObservers(new BirdInputAction.UseAbility(id));
        }
    }

    @Override
    public void onUpdate(UpdateAction updateAction) {
        super.onUpdate(updateAction);
        if (updateAction instanceof BirdUpdateAction.Ready) {
            ready();
        } else if (updateAction instanceof BirdUpdateAction.Launch) {
            launch();
        } else if (updateAction instanceof BirdUpdateAction.UseAbility) {
            useAbility();
            ability = true;
        } else if (updateAction instanceof BirdUpdateAction.Die) {
            die();
        }
    }

    @Override
    public void display(Graphics graphics) {
        graphics.drawImage(sprite, position.x - size.x / 2, position.y - size.y / 2);
        if(flying && ability){
        	system.update(10);
        	system.render();
        	system.addEmitter(emitter);
        	emitter.setPosition(position.x/* - size.x / 2*/, position.y /*- size.y / 2*/);
        	
        }
    }

    @Override
    public void displayDebug(Graphics graphics) {
        Shape bird = new Ellipse(position.x, position.y, size.x / 2, size.y / 2);
        Shape beak = new Ellipse(position.x + 5, position.y, 10, 5);

        bird = getRotated(bird, rotation, 0, 0);
        beak = getRotated(beak, rotation, -5, 0);

        graphics.setColor(color);
        graphics.fill(bird);
        graphics.setColor(Color.black);
        graphics.fill(beak);

        graphics.setColor(Color.darkGray);

        for (Vector2d v : trail) {

            if (trail.indexOf(v) % 4 == 0) {
                graphics.fillOval(v.x, v.y, 5, 5);
            }

        }
    }

    /**
     * Cette méthode doit être appellée quand le modèle prévient que l'oiseau est prêt à être lancé.
     */
    private void ready() {
    }

    /**
     * Cette méthode doit être appellée quand le modèle prévient que l'oiseau a été lancé.
     */
    private void launch() {
        System.out.println("BIRD LAUNCHED");
        flying = true;
    }

    /**
     * Cette méthode doit être appellée quand le modèle prévient que l'oiseau vient d'utiliser son pouvoir.
     */
    private void useAbility() {
        System.out.println("ABILITY TRIGGERED");
    }

    /**
     * Cette méthode doit être appellée quand le modèle prévient que l'oiseau vient de mourir.
     */
    private void die() {
        System.out.println("BIRD DIED");
    }
    
    @Override
    protected void moveTo(Vector2d position) {
        super.moveTo(position);
        if (flying && !(this.hit) && position.difference(lastDot).hypotenuse() > 10) {
            trail.add(position);
            lastDot = position;
        }
    }

}
