import observateur.MiseAJourHeure;
import horloge.Horloge;
import horloge.StockageHeure;

public class Main {

    public static void main(String[] args) {
        // Créez une instance de StockageHeure (simulez votre classe StockageHeure avec les méthodes getHeures(), getMinutes(), getSecondes())
        StockageHeure stockageHeure = new StockageHeure();

        // Créez une instance de MiseAJourHeure en lui passant le StockageHeure
        MiseAJourHeure miseAJourHeure = new MiseAJourHeure(stockageHeure);

        // Créez une instance d'Horloge et ajoutez l'observateur (MiseAJourHeure)
        Horloge horloge = new Horloge();
        horloge.ajouterObservateur(miseAJourHeure);

        // Simulez la mise à jour de l'heure (mettez à jour l'heure, les minutes et les secondes dans StockageHeure)
        stockageHeure.mettreHeure(12, 30, 45);

        // Appelez la méthode actualiser() de l'observateur pour voir le résultat
        miseAJourHeure.actualiser();
    }
}
