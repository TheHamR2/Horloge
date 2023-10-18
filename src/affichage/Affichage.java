package affichage;

public class Affichage {

    public void afficherHeureUniverselle(int heures, int minutes) {
        System.out.println("Heure universelle : " + heures + "h" + minutes);
    }

    public void afficherHeureAngloSaxon(int heures, int minutes, int secondes) {
        String amPm = (heures < 12) ? "AM" : "PM";
        heures = (heures > 12) ? heures - 12 : heures;
        System.out.println("Heure anglo-saxon : " + heures + amPm + ":" + minutes + " " + secondes + "s");
    }

    // Ajoutez d'autres méthodes d'affichage si nécessaire
}
