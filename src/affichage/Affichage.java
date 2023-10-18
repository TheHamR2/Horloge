package affichage;

public class Affichage {

    public void afficherHeureUniverselle(int heures, int minutes) {
        String heuresFormattees = (heures < 10) ? "0" + heures : String.valueOf(heures);
        String minutesFormattees = (minutes < 10) ? "0" + minutes : String.valueOf(minutes);

        System.out.println(heuresFormattees + "h" + minutesFormattees);
    }

    public void afficherHeureAngloSaxon(int heures, int minutes, int secondes) {
        String amPm = (heures < 12) ? "AM" : "PM";
        heures = (heures > 12) ? heures - 12 : heures;

        String minutesFormattees = (minutes < 10) ? "0" + minutes : String.valueOf(minutes);
        String secondesFormattees = (secondes < 10) ? "0" + secondes : String.valueOf(secondes);

        System.out.println(heures + amPm + ":" + minutesFormattees + " " + secondesFormattees + "s");
    }

    // Ajoutez d'autres méthodes d'affichage si nécessaire
}