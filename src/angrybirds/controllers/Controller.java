package angrybirds.controllers;

import angrybirds.models.Model;
import angrybirds.utils.ModelViewPair;
import angrybirds.notifications.inputs.InputObserver;
import angrybirds.views.View;

import java.util.*;

/**
 * Cette classe représente un controlleur, elle doit être héritée par tous les controlleurs.
 * C'est le controlleur qui s'occupe de créer les modèles et vues des objets décrits dans le fichier de description du jeu.
 * Le controlleur observe ses vues pour des InputAction.
 * Il y a 1 controlleur pour le jeu, 1 controlleur pour les niveaux, 1 controlleur par niveau pour les oiseaux,
 * 1 controlleur par niveau pour les obstacles, 1 controlleur par niveau pour les cochons et 1 controlleur par niveau pour le lance-oiseau.
 *
 * @author Quentin Brault
 * @since  2013/10/01
 */
public abstract class Controller implements InputObserver {

    /**
     * Liste des modèles de ce controlleur et de leur vue associée
     */
    private List<ModelViewPair> modelViewPairs;

    /**
     * Créé un nouveau controlleur.
     */
    public Controller() {
        modelViewPairs = new ArrayList<>();
    }

    /**
     * Ajoute un nouveau modèle et sa vue au controlleur.
     * Met la vue en observateur du modèle, et met le controlleur en observateur de la vue.
     *
     * @param modelViewPair Modèle à ajouter et sa vue associée.
     * @return True si j'ajout a réussit, false sinon.
     */
    protected boolean addModelViewPair(ModelViewPair modelViewPair) {
        modelViewPair.model.addObserver(modelViewPair.view);
        modelViewPair.view.addObserver(this);
        return modelViewPairs.add(modelViewPair);
    }

    /**
     * Retourne une map ordonnée des modèles du controlleur.
     *
     * @param <T> Type du modèle.
     * @return Map ordonnée des modèles du controlleur.
     */
    protected <T extends Model> SortedMap<Integer, T> getModels() {
        SortedMap<Integer, T> models = new TreeMap<>();
        for (ModelViewPair modelViewPair : modelViewPairs) {
            models.put(modelViewPair.model.getId(), (T) modelViewPair.model);
        }
        return models;
    }

    /**
     * Retourne une map ordonnée des vues du controlleur.
     *
     * @param <T> Type de la vue.
     * @return Map ordonnée des vues du controlleur.
     */
    protected <T extends View> SortedMap<Integer, T> getViews() {
        SortedMap<Integer, T> views = new TreeMap<>();
        for (ModelViewPair modelViewPair : modelViewPairs) {
            views.put(modelViewPair.view.getId(), (T) modelViewPair.view);
        }
        return views;
    }

    /**
     * Retourne la liste des modèles et de leur vue associée.
     *
     * @return Liste des modèles et de leur vue associée.
     */
    public List<ModelViewPair> getModelViewPairs() {
        return modelViewPairs;
    }

}
