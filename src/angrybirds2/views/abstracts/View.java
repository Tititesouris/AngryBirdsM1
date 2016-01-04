package angrybirds2.views.abstracts;

import angrybirds2.datamodels.DataModel;
import angrybirds2.utils.InputObservable;

/**
 * TODO: Description
 *
 * @author Quentin Brault
 */
public abstract class View extends InputObservable {

    protected DataModel dataModel;

    public View(DataModel dataModel) {
        this.dataModel = dataModel;
    }

    public abstract void display();

    /**
     * Le but de cette méthode est de simplifier les opérations sur le modèle de données
     * Cette méthode doit être override par toutes les classes filles
     * et sa signature doit être changée pour retourner un Model du type
     * approprié à la classe fille.
     * i.e. La classe BirdView possède la méthode "public BirdDataModel getDataModel() { return (BirdDataModel) dataModel; }
     *
     * @return  Le modèle cast au type approprié
     */
    public abstract DataModel getDataModel();

}
