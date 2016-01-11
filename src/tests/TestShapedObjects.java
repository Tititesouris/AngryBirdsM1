package tests;

import angrybirds.models.objects.CircularObjectModel;
import angrybirds.models.objects.RectangularObjectModel;
import angrybirds.utils.Vector2d;
import org.junit.Before;
import org.junit.Test;

/**
 * Cette classe de test vérifie les propriétés et méthodes des classes modèles RectangularObjectModel et CircularObjectModel.
 * @see angrybirds.models.objects.RectangularObjectModel
 * @see angrybirds.models.objects.CircularObjectModel
 *
 * @author Quentin Brault
 * @author Florent Marcaille
 * @since  2016/10/01
 */
public class TestShapedObjects {

    private static class TestRectangularObjectModel extends RectangularObjectModel {

        /**
         * Créé un nouvel objet de test rectangulaire.
         *
         * @param position     Position de l'objet en m.
         * @param velocity     Vélocité de l'objet en m/s.
         * @param acceleration Accélération de l'objet en m/s^2.
         * @param size         Taille de l'objet en m.
         * @param density      Densité (ou masse surfacique) de l'objet en kg/m^2.
         * @param rotation     Rotation de l'objet en radians par rapport au 0 du cercle trigonométrique.
         * @param angularSpeed Vitesse de rotation de l'objet en rad/s
         * @param gravity      True si l'objet est soumis à la pesanteur, false sinon.
         */
        public TestRectangularObjectModel(Vector2d position, Vector2d velocity, Vector2d acceleration, Vector2d size, float density, float rotation, float angularSpeed, boolean gravity) {
            super(position, velocity, acceleration, size, density, rotation, angularSpeed, gravity);
        }

    }

    private static class TestCircularObjectModel extends CircularObjectModel {

        /**
         * Créé un nouvel objet de test rectangulaire.
         *
         * @param position     Position de l'objet en m.
         * @param velocity     Vélocité de l'objet en m/s.
         * @param acceleration Accélération de l'objet en m/s^2.
         * @param size         Taille de l'objet en m.
         * @param density      Densité (ou masse surfacique) de l'objet en kg/m^2.
         * @param rotation     Rotation de l'objet en radians par rapport au 0 du cercle trigonométrique.
         * @param angularSpeed Vitesse de rotation de l'objet en rad/s
         * @param gravity      True si l'objet est soumis à la pesanteur, false sinon.
         */
        public TestCircularObjectModel(Vector2d position, Vector2d velocity, Vector2d acceleration, Vector2d size, float density, float rotation, float angularSpeed, boolean gravity) {
            super(position, velocity, acceleration, size, density, rotation, angularSpeed, gravity);
        }

    }

    private static RectangularObjectModel rectangularObject;

    private static CircularObjectModel circularObject;

    @Before
    public void setUp() {
        rectangularObject = new TestRectangularObjectModel(Vector2d.ZERO, Vector2d.ZERO, Vector2d.ZERO, Vector2d.ONE, 1, 0, 0, false);
        circularObject = new TestCircularObjectModel(Vector2d.ZERO, Vector2d.ZERO, Vector2d.ZERO, Vector2d.ONE, 1, 0, 0, false);
    }

    @Test
    public void testSurface() {
        // Test 1: Vérifier que la surface de l'objet rectangulaire est correcte.
        // Test 2: Vérifier que la surface de l'objet circulaire est correcte.
        // Test 3: Au moins 3 tests
    }

    @Test
    public void testCollision() {
        // Test 1: Vérifier qu'il y a collision.
        // Test 2: Déplacer les objet, vérifier qu'il n'y a pas collision
        // Test 3: Placer les objets pour que leurs bords se touchent, vérifier collision.
        // Test 4: Au moins 5 tests
        // Test 5: Au moins 5 tests
    }

}
