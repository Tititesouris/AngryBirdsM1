package angrybirds.models;

import angrybirds.notifications.updates.UpdateObservable;

/**
 * Cette classe représente un modèle.
 * Un modèle possède les données (champs) et actions (méthodes) qui représente un élément du jeu.
 * C'est dans le modèle que se trouve toute la logique et physique du jeu.
 * Chaque modèle possède un identifiant unique ce qui permet de les identifier et des les retrouver sans avoir à passer leur référence.
 *
 * @author Quentin Brault
 * @since  2013/10/01
 */
public abstract class Model extends UpdateObservable {

    /**
     * Nombre de modèles créés.
     */
    private static int idCount = 0;

    /**
     * Identifiant unique du modèle.
     */
    private final int id;

    /**
     * Créé un nouveau modèle avec un identifiant unique.
     */
    public Model() {
        id = idCount++;
    }

    /**
     * Cette méthode est appellée à chaque tick du jeu.
     * Elle doit être implémentée pour effectuer des modifications au modèle.
     *
     * @param delta Temps écoulé depuis le dernier appel à update() en ms.
     */
    public abstract void update(int delta);

    /**
     * Retourne l'identifiant unique du modèle.
     *
     * @return Identifiant unique du modèle.
     */
    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object object) {
        return object instanceof Model && this.id == ((Model) object).id;
    }

}
