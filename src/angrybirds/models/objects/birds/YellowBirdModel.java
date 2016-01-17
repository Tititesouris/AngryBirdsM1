package angrybirds.models.objects.birds;

import angrybirds.models.LevelModel;
import angrybirds.notifications.updates.actions.BirdUpdateAction;
import angrybirds.utils.Vector2d;

/**
 * Cette classe représente les données et actions d'un oiseau jaune.
 *
 * @author Quentin Brault
 * @since  2013/10/01
 */
public class YellowBirdModel extends BirdModel {

    public YellowBirdModel(LevelModel level, Vector2d position) {
        super(level, position, new Vector2d(40), 0.01f);
    }

    @Override
    public void useAbility() {
        if (!usedAbility) {
            accelerate(velocity.product(2));
            usedAbility = true;
            notifyObservers(new BirdUpdateAction.UseAbility());
        }
    }

}
