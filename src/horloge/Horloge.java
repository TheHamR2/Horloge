package horloge;

import observateur.observateur; // Importe l'interface Observateur
import strategie.AffichageFormatUniversel; // Importe la stratégie d'affichage par défaut
import strategie.StrategieAffichage;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

// La classe Horloge implémente l'interface Sujet
public class Horloge implements Sujet {
    // Liste pour stocker les observateurs
    private List<observateur> observateurs;
    // Stratégie d'affichage par défaut
    private StrategieAffichage strategieAffichage;
    // Timer pour la synchronisation périodique
    private Timer timer;
    // Récupérateur d'heure depuis la source externe
    private RecuperateurHeure recuperateur;
    // Stockage interne de l'heure
    private StockageHeure stockageHeure;
    // Intervalle de synchronisation en millisecondes (par défaut 1 heure)
    private long intervalleSynchronisation = 3600000;

    // Constructeur de la classe Horloge
    public Horloge() {
        // Initialisation de la liste des observateurs
        this.observateurs = new ArrayList<>();
        // Initialisation de la stratégie d'affichage par défaut
        this.strategieAffichage = new AffichageFormatUniversel();
        // Initialisation du timer
        this.timer = new Timer();
        // Initialisation du récupérateur d'heure
        this.recuperateur = new RecuperateurHeure();
        // Initialisation du stockage interne de l'heure
        this.stockageHeure = new StockageHeure();
        // Planifie la synchronisation périodique
        planifierSynchronisationPeriodique();
    }

    // Méthode pour définir la stratégie d'affichage
    public void setStrategieAffichage(StrategieAffichage strategie) {
        this.strategieAffichage = strategie;
    }

    // Méthode pour ajouter un observateur à la liste
    @Override
    public void ajouterObservateur(observateur observateur) {
        observateurs.add(observateur);
    }

    // Méthode pour retirer un observateur de la liste
    @Override
    public void retirerObservateur(observateur observateur) {
        observateurs.remove(observateur);
    }

    // Méthode pour notifier tous les observateurs
    @Override
    public void notifierObservateurs() {
        for (observateur observateur : observateurs) {
            observateur.actualiser();
        }
    }

    // Méthode de synchronisation appelée périodiquement par le timer
    public void synchroniser() {
        // Logique de synchronisation avec la source externe (exemple)
        int heures = recuperateur.recupererHeure();
        int minutes = recuperateur.recupererMinutes();
        int secondes = recuperateur.recupererSecondes();

        // Mettre à jour les heures, minutes et secondes dans le StockageHeure
        stockageHeure.mettreHeure(heures, minutes, secondes);

        // Notifier les observateurs après la synchronisation
        notifierObservateurs();
    }

    // Méthode pour afficher l'heure en utilisant la stratégie d'affichage
    public void afficherHeure() {
        // Récupérer les heures, minutes et secondes (exemple statique)
        int heures = 12; // Exemple
        int minutes = 30; // Exemple
        int secondes = 45; // Exemple

        // Utiliser la stratégie d'affichage pour afficher l'heure
        strategieAffichage.afficher(heures, minutes, secondes);
    }

    // Méthode privée pour planifier la synchronisation périodique
    private void planifierSynchronisationPeriodique() {
        // Utilisation du Timer pour planifier la synchronisation à intervalles réguliers
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                synchroniser();
            }
        }, 0, intervalleSynchronisation); // La synchronisation commence immédiatement et se répète à intervalles spécifiés
    }
}
