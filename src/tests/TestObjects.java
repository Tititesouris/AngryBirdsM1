package tests;

import angrybirds.models.LevelModel;
import angrybirds.models.objects.ObjectModel;
import angrybirds.utils.Vector2d;
import org.junit.Before;
import org.junit.Test;

/**
 * Cette classe de test vérifie les propriétés et méthodes de la classe modèle ObjectModel.
 * @see angrybirds.models.objects.ObjectModel
 *
 * @author Quentin Brault
 * @author Florent Marcaille
 * @since  2016/10/01
 */
public class TestObjects {

    private static class TestLevelModel extends LevelModel {
        public TestLevelModel() {
            super("Test", 0);
        }
    }

    private static class TestObjectModel extends ObjectModel {

        /**
         * Créé un nouvel objet de test.
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
        public TestObjectModel(Vector2d position, Vector2d velocity, Vector2d acceleration, Vector2d size, float density, float rotation, float angularSpeed, boolean gravity) {
            super(new TestLevelModel(), position, velocity, acceleration, size, density, rotation, angularSpeed, gravity);
        }

        @Override
        public boolean collidesWith(ObjectModel object) {
            return false;
        }

        @Override
        public float getSurface() {
            return 0;
        }

    }

    private static TestObjectModel object;

    @Before
    public void setUp() {
        object = new TestObjectModel(Vector2d.ZERO, Vector2d.ZERO, Vector2d.ZERO, Vector2d.ONE, 1, 0, 0, false);
    }

    @Test
    public void testCreation() {
        // Vérifier que la valeur des champs correspond à ce qui a été passé au constructeur.
    }

    @Test
    public void testPosition() {
        // Test 1: Vérifier que la position avant et après un appel à update(1) est identique.
        // Test 2: Mettre une vélocité de (1, 0). Vérifier que la position avant l'appel à update(1) est à un mètre de la position après update(1).
        // Test 3: Au moins 3 tests
    }

    @Test
    public void testVelocity() {
        // Test 1: Vérifier que la vélocité avant et après un appel à update est identique.
        // Test 2: Mettre une accélération de (1, 0. Vérifier que la vélocité avant l'appel a update(1) est à un metre/seconde de apres update(1)
        // Test 3: Au moins 3 tests
    }

    @Test
    public void testRotation() {
        // Test 1: Vérifier que la rotation est pareil avant et apres appel a update
        // Test 2: mettre une vitesse de rotation, vérifier que ca change, tu connais la chanson...
        // Test 3: Au moins 3 tests
    }

    @Test
    public void testGravity() {
        // Test 1: Vérifier que la position avant et apres un appel à update(1) est identique.
        // Test 2: Activer la gravité de l'objet. Vérifier que sa position à changée après un appel à update(1).
        // Test 3: Au moins 3 tests
    }

    @Test
    public void testMass() {
        // Au moins 3 tests pour vérifier que la masse est caculée correctement.
    }

}
