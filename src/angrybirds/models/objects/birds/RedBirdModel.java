package angrybirds.models.objects.birds;

import angrybirds.models.LevelModel;
import angrybirds.models.objects.ObjectModel;
import angrybirds.utils.Vector2d;

/**
 * Cette classe représente les données et actions d'un oiseau rouge.
 *
 * @author Quentin Brault
 * @since  2013/10/01
 */
public class RedBirdModel extends BirdModel {

    public RedBirdModel(LevelModel level, Vector2d position) {
        super(level, position, new Vector2d(30), 0.03f);
    }

    @Override
    public boolean collidesWith(ObjectModel object) {
        return false;
    }

    @Override
    public float getSurface() {
        return (float) (Math.PI * (size.x / 2) * (size.y / 2));
    }

}