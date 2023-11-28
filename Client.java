import java.util.Date;
import java.util.List;

public class Client {
    private static int total_Clients = 0;
    private int idClient;
    private String nom;
    private String prenom;
    private Adresse adresse;
    private List<Reservation> reservations;
    private List<Consommation> consommations;

    public Client(String nom, String prenom, Adresse adresse) {
        idClient = total_Clients;
        total_Clients++;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
    }

    public Client(String nom, String prenom, String nom_rue, int num_immeuble, String nom_de_commune, int code_postal,
            String pays) {
        idClient = total_Clients;
        total_Clients++;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = new Adresse(nom_rue, num_immeuble, nom_de_commune, code_postal, pays);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public List<Consommation> getConsommations() {
        return consommations;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public void ajouter_Reservation_process(Date date_res, Date deb_res, Date fin_res, Chambre chambre,
            Client client, int index) {
        Reservation nouv_res = new Reservation(date_res, deb_res, fin_res, chambre, client);
        reservations.add(nouv_res);
        chambre.inserer_res(index, nouv_res);
        if (date_res == deb_res) {
            chambre.setOccuper(true);
        }
    }

    public boolean ajouter_Reservation_chambre(Date date_res, Date deb_res, Date fin_res, Chambre chambre,
            Client client) {
        // boolean succ_reservation = false;
        List<Reservation> reserv_list = chambre.getReservations();
        int size_list = reserv_list.size();
        if (size_list == 0 || reserv_list.get(0).getDeb_res().compareTo(fin_res) >= 0) {
            ajouter_Reservation_process(date_res, deb_res, fin_res, chambre, client, 0);
            return true;

        } else if (reserv_list.get(size_list - 1).getFin_res().compareTo(deb_res) <= 0) {
            ajouter_Reservation_process(date_res, deb_res, fin_res, chambre, client, size_list - 1);
            return true;

        } else
            for (int index = 0; index < size_list - 1; index++) {
                // this will handle inserting between dates
                if (reserv_list.get(index).getFin_res().compareTo(deb_res) <= 0
                        && reserv_list.get(index + 1).getDeb_res().compareTo(fin_res) >= 0) {
                    ajouter_Reservation_process(date_res, deb_res, fin_res, chambre, client, index + 1);
                    return true;
                }
            }
        return false;
    }

    public void ajouter_Reservation_categorie(Hotel hotel, Date date_res, Date deb_res, Date fin_res,
            Categorie categorie,
            Client client) {
        List<Chambre> liste_Chambre = hotel.getChambrelist();
        try {

            for (Chambre chambre : liste_Chambre) {
                if (chambre.getCategorie() == categorie) {
                    boolean res = ajouter_Reservation_chambre(date_res, deb_res, fin_res, chambre, client);
                    if (res) {
                        return;
                    } else if (liste_Chambre.size() - 1 == liste_Chambre.indexOf(chambre)) {
                        throw new Anomalie(0);
                    }
                }
            }
        } catch (Anomalie e) {
            System.out.println(e);
        }
    }

    public void supprimer_reservation(int num_res) {
        for (Reservation reservation : getReservations()) {
            if (num_res == reservation.getNum_res()) {
                reservation.getChambre().setOccuper(false);
                reservation.getChambre().getReservations()
                        .remove(reservation.getChambre().getReservations().indexOf(reservation));
                getReservations().remove(getReservations().indexOf(reservation));
            }
        }
    }
}