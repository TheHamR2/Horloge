package horloge;

import observateur.observateur;

public interface Sujet {
    void ajouterObservateur(observateur observateur);
    void retirerObservateur(observateur observateur);
    void notifierObservateurs();
}