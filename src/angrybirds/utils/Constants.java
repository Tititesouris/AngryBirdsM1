package angrybirds.utils;

import java.util.Random;

/**
 * TODO: Description
 *
 * @author Quentin Brault
 */
public interface Constants {

    boolean DEBUG = true;

    /**
     * Le temps en millisecondes minimum avec lequel le moteur de jeu travaille.
     * Deux InputAction ne peuvent pas être envoyée plus vite que ce temps, de même pour UpdateAction.
     * Deux appels à update() ne peuvent pas être effectués plus vite que ce temps, de même pour display().
     */
    int MIN_ENGINE_DELAY = 10;

    Random RAND = new Random();

    int WINDOW_WIDTH = 1080;

    int WINDOW_HEIGHT = 720;

    Vector2d GRAVITY = new Vector2d(0, 3f);

    float SLING_STRENGTH = 100;
}
