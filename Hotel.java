import java.time.LocalTime;
import java.util.List;

public class Hotel {
    private String nom;
    private Adresse adresse;
    private LocalTime temp_ouveture;
    private LocalTime temp_fermeture;
    private String categorie;
    private List<Chambre> chambrelist;

    // add exceptions for temp d'ouverture and temp de fermeture if opening is after
    // closing then exceptionnnn
    public Hotel(String nom, Adresse adresse, LocalTime temp_ouveture, LocalTime temp_fermeture, String categorie) {
        try {
            if (temp_ouveture.compareTo(temp_fermeture) > 0) {
                throw new Anomalie(3);
            }
            this.nom = nom;
            this.adresse = adresse;
            this.temp_ouveture = temp_ouveture;
            this.temp_fermeture = temp_fermeture;
            this.categorie = categorie;
        } catch (Anomalie e) {
            System.out.println(e);
        }
    }

    public LocalTime getTemp_ouveture() {
        return temp_ouveture;
    }

    public void setTemp_ouveture(LocalTime temp_ouveture) {
        this.temp_ouveture = temp_ouveture;
    }

    public LocalTime getTemp_fermeture() {
        return temp_fermeture;
    }

    public void setTemp_fermeture(LocalTime temp_fermeture) {
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

    public void ajouter_chambre(Categorie categ, int etage) {
        try {
            if (etage < 0) {
                throw new Anomalie(1);
            }
            getChambrelist().add(new Chambre(categ, etage));
        } catch (Anomalie e) {
            System.out.println(e);
        }

    }

}