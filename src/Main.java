import observateur.MiseAJourHeure;
import horloge.Horloge;
import strategie.AffichageFormatUniversel;

public class Main {
    public static void main(String[] args) {
        Horloge horloge = new Horloge();
        horloge.ajouterObservateur(new MiseAJourHeure());
        horloge.setStrategieAffichage(new AffichageFormatUniversel());

        // Logique de l'application...
    }
}
