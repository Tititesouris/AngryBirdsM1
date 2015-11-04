package angrybirds;

import org.newdawn.slick.Image;

import java.io.File;

/**
 * Created by Tititesouris on 27/09/2015.
 */
public class Tool extends Image {

    /**
     * Retourne l'image dont l'URL est passée en paramètre
     * @param url chemin vers l'image
     * @return l'image dont l'URL est passée en paramètre
     */
    public static Image getImage(String url) {
        try {
            return new Image(url);
            //return new Image(System.class.getResource(url).openStream(), url, false); ---- DO NOT REMOVE ----
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
