package observateur;

import horloge.StockageHeure;

public class MiseAJourHeure implements observateur {
    private StockageHeure stockageHeure;
    private String heures;
    private String minutes;
    private String secondes;

    public MiseAJourHeure(StockageHeure stockageHeure) {
        this.stockageHeure = stockageHeure;
    }

    @Override
    public void actualiser() {
        int heures = stockageHeure.getHeures();
        int minutes = stockageHeure.getMinutes();
        int secondes = stockageHeure.getSecondes();
    }

    // Autres méthodes et logique spécifique au cas d'utilisation
}