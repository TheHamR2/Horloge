package horloge;

import observateur.observateur;
import strategie.AffichageFormatUniversel;
import strategie.StrategieAffichage;

import java.util.ArrayList;
import java.util.List;

public class Horloge implements Sujet {
    private List<observateur> observateurs;
    private StrategieAffichage strategieAffichage;

    public Horloge() {
        this.observateurs = new ArrayList<>();
        // Initialiser la stratégie d'affichage par défaut
        this.strategieAffichage = new AffichageFormatUniversel();
    }

    public void setStrategieAffichage(StrategieAffichage strategie) {
        this.strategieAffichage = strategie;
    }

    @Override
    public void ajouterObservateur(observateur observateur) {
        observateurs.add(observateur);
    }

    @Override
    public void retirerObservateur(observateur observateur) {
        observateurs.remove(observateur);
    }

    @Override
    public void notifierObservateurs() {
        for (observateur observateur : observateurs) {
            observateur.actualiser();
        }
    }

    public void synchroniser() {
        // Logique de synchronisation avec la source externe
        // Met à jour les heures, minutes et secondes
        // ...

        // Après la synchronisation, notifier les observateurs
        notifierObservateurs();
    }

    public void afficherHeure() {
        // Récupérer les heures, minutes et secondes
        int heures = 12; // Exemple
        int minutes = 30; // Exemple
        int secondes = 45; // Exemple

        // Utiliser la stratégie d'affichage pour afficher l'heure
        strategieAffichage.afficher(heures, minutes, secondes);
    }

    public void mettreAJourHeure() {
        // Logique pour mettre à jour l'heure
        // ...
    }
}