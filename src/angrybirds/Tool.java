package angrybirds;

import org.newdawn.slick.Image;

import java.io.File;

/**
 * Created by Tititesouris on 27/09/2015.
 */
public class Tool extends Image {

    public static Image getImage(String url) {
        try {
            return new Image(new File(url).getPath());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
