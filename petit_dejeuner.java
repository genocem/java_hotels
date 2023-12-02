import java.time.LocalTime;
import java.util.Date;

class petit_dejeuner extends Consommation {
    private String category;

    public petit_dejeuner(String type, double prix, Date date, LocalTime heure, String category) {
        super(type, prix, date, heure);
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }    
    
}