import java.time.LocalTime;
import java.time.LocalDate;

class petit_dejeuner extends Consommation {
    private String category;

    public petit_dejeuner(String type, double prix, LocalDate date, LocalTime heure, String category) {
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