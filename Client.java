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

    public void ajouter_Reservation(Hotel hotel, Date date_res, Date deb_res, Date fin_res, Chambre chambre,
            Client client) {
        int index;
        boolean succ_reservation = false;
        try {
            for (Chambre iChambre : hotel.getChambrelist()) {
                if (iChambre.getReservations().size() == 0) {
                    succ_reservation = true;
                    Reservation nouv_res = new Reservation(date_res, deb_res, fin_res, chambre, client);
                    reservations.add(nouv_res);
                    iChambre.getReservations().add(nouv_res);
                    if (date_res == deb_res) {
                        iChambre.setOccuper(succ_reservation);
                    }
                }
                index = 0;
                for (Reservation iReservation : iChambre.getReservations()) {
                    if (true) {
                        succ_reservation = true;
                        Reservation nouv_res = new Reservation(date_res, deb_res, fin_res, chambre, client);
                        reservations.add(nouv_res);
                        iChambre.inserer_res(index, nouv_res);
                        if (date_res == deb_res) {
                            iChambre.setOccuper(succ_reservation);
                        }
                    }
                    if (iReservation.getFin_res().compareTo(deb_res) <= 0
                            && iChambre.getReservations().get(index + 1).getDeb_res().compareTo(fin_res) >= 0) {
                        succ_reservation = true;
                        Reservation nouv_res = new Reservation(date_res, deb_res, fin_res, chambre, client);
                        reservations.add(nouv_res);
                        iChambre.inserer_res(index, nouv_res);
                        if (date_res == deb_res) {
                            iChambre.setOccuper(succ_reservation);
                        }
                        return;
                    }
                    index++;
                }
            }
            if (!succ_reservation) {
                throw new Anomalie(0);
            }
        } catch (Anomalie e) {
            System.out.println(e);
        }
    }
}