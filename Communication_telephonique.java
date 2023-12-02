import java.time.LocalTime;
import java.util.Date;

class Communication_telephonique extends Consommation {
    private String destination;
    private double facteur_destination;

    public Communication_telephonique(String type, double prix_minute, Date date, LocalTime heure, int duree_minute,
            String destination, double facteur_destination) {
        super(type, prix_minute * facteur_destination, date, heure, duree_minute);
        this.destination = destination;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public double getFacteur_destination() {
        return facteur_destination;
    }

    public void setFacteur_destination(double facteur_destination) {
        this.facteur_destination = facteur_destination;
    }

}