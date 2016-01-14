package angrybirds.utils;

import angrybirds.models.Model;
import angrybirds.views.View;

/**
 * Cette classe permet d'associer une vue à un modèle et vice-versa dans le controlleur afin de faciliter l'initialisation du jeu.
 *
 * @author Quentin Brault
 * @since  2016/10/01
 */
public class ModelViewPair<M extends Model, V extends View> {

    /**
     * Modèle.
     */
    public final M model;

    /**
     * Vue.
     */
    public final V view;

    /**
     * Créé une nouvelle paire de modèle-vue.
     *
     * @param model Modèle.
     * @param view  Vue.
     */
    public ModelViewPair(M model, V view) {
        this.model = model;
        this.view = view;
    }

}
