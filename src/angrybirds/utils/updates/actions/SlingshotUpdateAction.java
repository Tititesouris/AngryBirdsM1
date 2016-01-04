package angrybirds.utils.updates.actions;

import angrybirds.models.Model;
import angrybirds.utils.Vector2d;

/**
 * TODO: Description
 *
 * @author Quentin Brault
 */
public class SlingshotUpdateAction implements UpdateAction {

    public static class Stretch extends SlingshotUpdateAction {

        private Vector2d position;

        public Stretch(Vector2d position) {
            this.position = position;
        }

        public Vector2d getPosition() {
            return position;
        }

    }

}
