import java.util.Date;
import java.time.LocalTime;

class Consommation {
    private String type;
    private double prix;
    private Date date;
    private LocalTime heure;
    private int quantite;

    public Consommation(String type, double prix, Date date, LocalTime heure) {
        try {
            if (prix <= 0) {
                throw new Anomalie(1);
            }
            this.type = type;
            this.prix = prix;
            this.date = date;
            this.heure = heure;
            quantite = 1;
        } catch (Anomalie e) {
            System.out.println(e);
        }
    }

    public Consommation(String type, double prix, Date date, LocalTime heure, int quantite) {
        try {
            if (prix <= 0 || quantite <= 0) {
                throw new Anomalie(1);
            }
            this.type = type;
            this.prix = prix;
            this.date = date;
            this.heure = heure;
            this.quantite = quantite;

        } catch (Anomalie e) {
            System.out.println(e);
        }
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrix() {
        return prix*quantite;
    }

    public void setPrix(double prix) {
        try {
            if (prix <= 0) {
                throw new Anomalie(1);
            }
            this.prix = prix;
        } catch (Anomalie e) {
            System.out.println(e);
        }
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public LocalTime getHeure() {
        return heure;
    }

    public void setHeure(LocalTime heure) {
        this.heure = heure;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        try {
            if (quantite <= 0) {
                throw new Anomalie(1);
            }
            this.quantite = quantite;
        } catch (Anomalie e) {
            System.out.println(e);
        }
    }

}
