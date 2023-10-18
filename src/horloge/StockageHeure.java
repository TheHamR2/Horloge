package horloge;

public class StockageHeure {
    private int heures;
    private int minutes;
    private int secondes;

    public void mettreHeure(int heures, int minutes, int secondes) {
        this.heures = heures;
        this.minutes = minutes;
        this.secondes = secondes;
    }

    public int getHeures() {
        return heures;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSecondes() {
        return secondes;
    }
}
