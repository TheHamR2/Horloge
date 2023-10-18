package horloge;

import observateur.observateur;
import strategie.AffichageFormatUniversel;
import strategie.StrategieAffichage;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Horloge implements Sujet {
    private List<observateur> observateurs;
    private StrategieAffichage strategieAffichage;
    private Timer timer;
    private RecuperateurHeure recuperateur;
    private StockageHeure stockageHeure;
    private long intervalleSynchronisation;

    public Horloge() {
        this.observateurs = new ArrayList<>();
        // Initialiser la stratégie d'affichage par défaut
        this.strategieAffichage = new AffichageFormatUniversel();
        this.timer = new Timer();
        this.recuperateur = new RecuperateurHeure();
        this.stockageHeure = new StockageHeure();
        this.intervalleSynchronisation = 3600000; // 1 heure en millisecondes (1000 ms * 60 s * 60 min)
        planifierSynchronisationPeriodique();
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
        int heures = recuperateur.recupererHeure();
        int minutes = recuperateur.recupererMinutes();
        int secondes = recuperateur.recupererSecondes();

        // Mettre à jour les heures, minutes et secondes dans le StockageHeure
        stockageHeure.mettreHeure(heures, minutes, secondes);

        // Notifier les observateurs après la synchronisation
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

    private void planifierSynchronisationPeriodique() {
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                synchroniser();
            }
        }, 0, intervalleSynchronisation);
    }
}