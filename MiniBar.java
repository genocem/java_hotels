import java.time.LocalTime;
import java.time.LocalDate;

public class MiniBar extends Consommation {
    String nom_article;

    public MiniBar(String type, double prix, LocalDate date, LocalTime heure, String nom_article) {
        super(type, prix, date, heure);
        this.nom_article = nom_article;
    }

    public String getNom_article() {
        return nom_article;
    }

    public void setNom_article(String nom_article) {
        this.nom_article = nom_article;
    }
    
}
