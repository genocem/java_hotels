import java.sql.Time;
import java.util.List;

public class Hotel {
    private String nom;
    private Adresse adresse;
    private Time temp_ouveture;
    private Time temp_fermeture;
    private String categorie;
    private List<Chambre> chambrelist;

// add exceptions for temp d'ouverture and temp de fermeture if opening is after closing then exceptionnnn
    public Hotel(String nom, Adresse adresse, Time temp_ouveture, Time temp_fermeture, String categorie) {
        this.nom = nom;
        this.adresse = adresse;
        this.temp_ouveture = temp_ouveture;
        this.temp_fermeture = temp_fermeture;
        this.categorie = categorie;
    }

    public Time getTemp_ouveture() {
        return temp_ouveture;
    }

    public void setTemp_ouveture(Time temp_ouveture) {
        this.temp_ouveture = temp_ouveture;
    }

    public Time getTemp_fermeture() {
        return temp_fermeture;
    }

    public void setTemp_fermeture(Time temp_fermeture) {
        this.temp_fermeture = temp_fermeture;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public List<Chambre> getChambrelist() {
        return chambrelist;
    }
    public void ajouter_chambre(Categorie categ, int etage){
        try {
            if (etage<0) {
                throw new Anomalie(1);
            }
            getChambrelist().add(new Chambre(categ, etage));
        } catch (Anomalie e) {
            System.out.println(e);
        }

    }

}