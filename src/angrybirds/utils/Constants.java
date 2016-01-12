package angrybirds.utils;

/**
 * Cette interface regroupe toutes les constantes du jeu d'accès global.
 *
 * @author Quentin Brault
 * @since  2016/10/01
 */
public interface Constants {

    /**
     * True si le jeu est en mode débug, false sinon.
     * Le mode débug affiche plus d'informations et avec plus de précision.
     */
    boolean DEBUG = true;

    /**
     * Temps minimum avec lequel le moteur de jeu travaille en ms.
     * Deux InputAction ne peuvent pas être envoyées plus vite que ce temps.
     * Deux appels à update() ne peuvent pas être effectués plus vite que ce temps, de même pour display().
     */
    int MIN_ENGINE_DELAY = 10;

    /**
     * Nombre d'images par secondes maximum du jeu.
     */
    int FPS = 60;

    /**
     * Largeur de la fenêtre de jeu.
     */
    int WINDOW_WIDTH = 1080;

    /**
     * Hauteur de la fenêtre de jeu.
     */
    int WINDOW_HEIGHT = 720;

    /**
     * Force de pesanteur.
     */
    Vector2d GRAVITY = new Vector2d(0, 0.00005f);

    /**
     * Force de friction.
     */
    Vector2d FRICTION = new Vector2d(-0.0001f, -0.0001f);

    /**
     * Puissance de tir du lance-oiseau.
     */
    float SLING_STRENGTH = 0.007f;

}
