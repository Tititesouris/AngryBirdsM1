package angrybirds.utils;

import java.util.Random;

/**
 * TODO: Description
 *
 * @author Quentin Brault
 */
public interface Constants {

    boolean DEBUG = true;

    Random RAND = new Random();

    int WINDOW_WIDTH = 1080;

    int WINDOW_HEIGHT = 720;

    Vector2d GRAVITY = new Vector2d(0, 3f);

    float SLING_STRENGTH = 100;
}
