import java.sql.Date;

public class Consommation {
        private Date date;
        private int heure;
        private int quantité;
        private String nom;
        public Consommation(Date date, int heure, int quantité, String nom) {
            this.date = date;
            this.heure = heure;
            this.quantité = quantité;
            this.nom = nom;
        }
        
        public Consommation(Date date, int heure, String nom) {
            this.date = date;
            this.heure = heure;
            this.nom = nom;
            quantité=0;
        }

        public Date getDate() {
            return date;
        }
        public void setDate(Date date) {
            this.date = date;
        }
        public int getHeure() {
            return heure;
        }
        public void setHeure(int heure) {
            this.heure = heure;
        }
        public int getQuantité() {
            return quantité;
        }
        public void setQuantité(int quantité) {
            this.quantité = quantité;
        }
        public String getNom() {
            return nom;
        }
        public void setNom(String nom) {
            this.nom = nom;
        }
        
}
