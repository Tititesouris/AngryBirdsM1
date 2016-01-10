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
     * Le temps minimum avec lequel le moteur de jeu travaille en ms.
     * Deux InputAction ne peuvent pas être envoyées plus vite que ce temps.
     * Deux appels à update() ne peuvent pas être effectués plus vite que ce temps, de même pour display().
     */
    int MIN_ENGINE_DELAY = 10;

    /**
     * La largeur de la fenêtre de jeu.
     */
    int WINDOW_WIDTH = 1080;

    /**
     * La hauteur de la fenêtre de jeu.
     */
    int WINDOW_HEIGHT = 720;

    /**
     * La force de pesanteur.
     */
    Vector2d GRAVITY = new Vector2d(0, 0.00005f);

    /**
     * La puissance de tir du lance-oiseau.
     */
    float SLING_STRENGTH = 0.007f;

}
