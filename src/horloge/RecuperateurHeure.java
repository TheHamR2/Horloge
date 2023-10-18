package horloge;

import org.apache.commons.net.ntp.NTPUDPClient;
import org.apache.commons.net.ntp.TimeInfo;

import java.net.InetAddress;

public class RecuperateurHeure {
    private long tempsServeurNTP; // Stocke le temps récupéré à partir du serveur NTP

    // Récupère le temps à partir d'un serveur NTP et stocke le temps en millisecondes
    public void recupererTempsNTP() {
        NTPUDPClient client = new NTPUDPClient();
        try {
            client.open();
            InetAddress hostAddr = InetAddress.getByName("pool.ntp.org"); // Serveur NTP public
            TimeInfo timeInfo = client.getTime(hostAddr);
            tempsServeurNTP = timeInfo.getMessage().getTransmitTimeStamp().getTime();
        } catch (Exception e) {
            e.printStackTrace();
            // En cas d'échec, gère l'erreur selon vos besoins
        } finally {
            client.close();
        }
    }

    // Récupère l'heure à partir du temps stocké en millisecondes depuis le serveur NTP
    public int recupererHeure() {
        return (int) ((tempsServeurNTP / (1000 * 60 * 60)) % 24);
    }

    // Récupère les minutes à partir du temps stocké en millisecondes depuis le serveur NTP
    public int recupererMinutes() {
        return (int) ((tempsServeurNTP / (1000 * 60)) % 60);
    }

    // Récupère les secondes à partir du temps stocké en millisecondes depuis le serveur NTP
    public int recupererSecondes() {
        return (int) ((tempsServeurNTP / 1000) % 60);
    }
}
