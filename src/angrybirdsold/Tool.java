package angrybirdsold;

import org.newdawn.slick.Image;

/**
 * Cette classe utilitaire permet de facilité certaines opérations.
 *
 * @author Quentin Brault
 */
public class Tool {

    /**
     * Retourne l'image dont le chemin est spécifié
     *
     * @param url   Chemin de l'image à charger
     * @return      Image chargée
     */
    public static Image getImage(String url) {
        try {
            return new Image(url);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
