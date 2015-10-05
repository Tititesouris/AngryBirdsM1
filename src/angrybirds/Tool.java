package angrybirds;

import org.newdawn.slick.Image;

/**
 * Created by Tititesouris on 27/09/2015.
 */
public class Tool extends Image {

    public static Image getImage(String url) {
        try {
            return new Image(Tool.class.getClassLoader().getResourceAsStream(url), url, false);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
