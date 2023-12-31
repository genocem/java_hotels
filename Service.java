import java.time.LocalTime;
import java.time.LocalDate;

public class Service extends Consommation {
    private boolean isForfaitaire;



    public Service(String type, double prix, LocalDate date, LocalTime heure, boolean isForfaitaire) {
        super(type, prix, date, heure);
        this.isForfaitaire = isForfaitaire;
    }

    public boolean isForfaitaire() {
        return isForfaitaire;
    }

    public void setForfaitaire(boolean isForfaitaire) {
        this.isForfaitaire = isForfaitaire;
    } 
    public void setPrix_service(double prix){
        if (!isForfaitaire) {
            setPrix(prix);
        }
    }
}
