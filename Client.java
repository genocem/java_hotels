import java.time.LocalTime;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Client {
    private static int total_Clients = 0;
    private int idClient;
    private String nom;
    private String prenom;
    private Adresse adresse;
    private List<Reservation> reservations = new ArrayList<Reservation>();
    private List<Consommation> consommations = new ArrayList<Consommation>();

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

    public void ajouter_Reservation_process(LocalDate date_res, LocalDate deb_res, LocalDate fin_res, Chambre chambre,
            Client client, int index) {
        Reservation nouv_res = new Reservation(date_res, deb_res, fin_res, chambre, client);
        reservations.add(nouv_res);
        chambre.inserer_res(index, nouv_res);
        if (date_res == deb_res) {
            chambre.setOccuper(true);
        }
    }

    public boolean ajouter_Reservation_using_chambre_Object(Hotel hotel, LocalDate date_res, LocalDate deb_res,
            LocalDate fin_res,
            Chambre chambre,
            Client client) {
        // Chambre chambre=hotel.get_chambre(num_chambre);
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

    public void ajouter_Reservation_chambre(Hotel hotel, LocalDate date_res, LocalDate deb_res, LocalDate fin_res,
            int num_chambre,
            Client client) {
        Chambre chambre = hotel.get_chambre(num_chambre);
        ajouter_Reservation_using_chambre_Object(hotel, date_res, deb_res, fin_res, chambre, client);
    }

    public void ajouter_Reservation_categorie(Hotel hotel, LocalDate date_res, LocalDate deb_res, LocalDate fin_res,
            int num_categorie,
            Client client) {

        List<Chambre> liste_Chambre = hotel.getChambrelist();
        try {

            for (Chambre chambre : liste_Chambre) {
                if (chambre.getCategorie().getNum_categ() == (num_categorie)) {
                    boolean res = ajouter_Reservation_using_chambre_Object(hotel, date_res, deb_res, fin_res, chambre,
                            client);
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

    public void ajouter_Service(String type, double prix, LocalDate date, LocalTime heure, boolean isForfaitaire) {
        consommations.add(new Service(type, prix, date, heure, isForfaitaire));
    }

    public void ajouter_Communication_telephonique(String type, double prix_minute, LocalDate date, LocalTime heure,
            int duree_minute,
            String destination, double facteur_destination) {
        consommations.add(new Communication_telephonique(type, prix_minute, date, heure, duree_minute,
                destination, facteur_destination));
    }

    public void ajouter_MiniBar(String type, double prix, LocalDate date, LocalTime heure, String nom_article) {
        consommations.add(new MiniBar(type, prix, date, heure, nom_article));
    }

    public void ajouter_petit_dejeuner(String type, double prix, LocalDate date, LocalTime heure, String category) {
        consommations.add(new petit_dejeuner(type, prix, date, heure, category));
    }

    public int get_facture() {
        int somme = 0;
        for (Consommation consommation : consommations) {
            somme += consommation.getPrix();
        }
        return somme;
    }

    public LocalDate donner_date() {
        Scanner sc = new Scanner(System.in);
        System.out.println("entrer la date de reservation");
        int annee;
        do {
            System.out.println("entrer l'annee");
            annee = sc.nextInt();
        } while (annee < 0);
        int mois;
        do {
            System.out.println("entrer le mois");
            mois = sc.nextInt();
            if (mois < 0 || mois > 12) {
                System.out.println("mois invalide");
            } else {
                break;
            }
        } while (true);
        int jour;
        do {
            System.out.println("entrer le jour");
            jour = sc.nextInt();
            if (jour < 0 || jour > 31) {
                System.out.println("jour invalide");
            } else {
                break;
            }
        } while (true);
        return LocalDate.of(annee, mois, jour);
    }

    public LocalTime donner_temp() {
        Scanner sc = new Scanner(System.in);
        int heure;
        do {
            System.out.println("entrer l'heure");
            heure = sc.nextInt();
            if (heure < 0 || heure > 23) {
                System.out.println("heure invalide");
            } else {
                break;
            }
        } while (true);
        int minute;
        do {
            System.out.println("entrer les minutes");
            minute = sc.nextInt();
            if (minute < 0 || minute > 59) {
                System.out.println("minute invalide");
            } else {
                break;
            }
        } while (true);
        return LocalTime.of(heure, minute);
    }

    public void afficher_menu(Hotel hotel) {
        while (true) {
            System.out.println("1-ajouter reservation chambre\n");
            System.out.println("2-ajouter reservation categorie\n");
            System.out.println("3-supprimer reservation\n");
            System.out.println("4-ajouter service\n");
            System.out.println("5-ajouter communication telephonique\n");
            System.out.println("6-ajouter mini bar\n");
            System.out.println("7-ajouter petit dejeuner\n");
            System.out.println("8-afficher facture\n");
            System.out.println("0-retour\n");
            Scanner sc = new Scanner(System.in);
            int choix = sc.nextInt();
            switch (choix) {
                case 0:
                    return;
                case 1:
                    int num_chambre;
                    do {
                        System.out.println("entrer le numero de la chambre");
                        num_chambre = sc.nextInt();
                        if (hotel.get_chambre(num_chambre) == null) {
                            System.out.println("numero de chambre invalide");
                        } else if (hotel.get_chambre(num_chambre).isOccuper()) {
                            System.out.println("chambre deja occuper");
                        } else {
                            break;
                        }

                    } while (true);

                    LocalDate date_res = donner_date();
                    LocalDate deb_res = donner_date();
                    LocalDate fin_res = donner_date();
                    ajouter_Reservation_chambre(hotel, date_res, deb_res, fin_res, num_chambre, this);
                    break;
                case 2:
                    System.out.println("entrer le numero de la categorie");
                    int num_categorie = sc.nextInt();

                    date_res = donner_date();
                    deb_res = donner_date();
                    fin_res = donner_date();
                    ajouter_Reservation_categorie(hotel, date_res, deb_res, fin_res, num_categorie, this);
                    break;
                case 3:
                    int num_res;
                    do {
                        System.out.println("entrer le numero de la reservation");
                        num_res = sc.nextInt();
                        if (getReservations().get(num_res) == null) {
                            System.out.println("numero de reservation invalide");
                        } else {
                            break;
                        }
                    } while (true);
                    supprimer_reservation(num_res);
                    break;
                case 4:
                    System.out.println("entrer le type de service");
                    String type = sc.next();
                    System.out.println("entrer le prix");
                    double prix = sc.nextDouble();
                    LocalDate date = donner_date();
                    LocalTime heure1 = donner_temp();
                    System.out.println("entrer si le service est forfaitaire");
                    boolean isForfaitaire = sc.nextBoolean();
                    ajouter_Service(type, prix, date, heure1, isForfaitaire);
                    break;
                case 5:
                    System.out.println("entrer le type de communication telephonique");
                    type = sc.next();
                    System.out.println("entrer le prix par minute");
                    prix = sc.nextDouble();
                    date = donner_date();
                    heure1 = donner_temp();
                    System.out.println("entrer la duree en minute");
                    int duree_minute = sc.nextInt();
                    System.out.println("entrer la destination");
                    String destination = sc.next();
                    System.out.println("entrer le facteur de destination");
                    double facteur_destination = sc.nextDouble();
                    ajouter_Communication_telephonique(type, prix, date, heure1, duree_minute, destination,
                            facteur_destination);
                    break;
                case 6:
                    System.out.println("entrer le type de mini bar");
                    type = sc.next();
                    System.out.println("entrer le prix");
                    prix = sc.nextDouble();

                    date = donner_date();

                    heure1 = donner_temp();
                    System.out.println("entrer le nom de l'article");
                    String nom_article = sc.next();
                    ajouter_MiniBar(type, prix, date, heure1, nom_article);
                    break;
                case 7:
                    System.out.println("entrer le type de petit dejeuner");
                    type = sc.next();
                    System.out.println("entrer le prix");
                    prix = sc.nextDouble();

                    date = donner_date();
                    heure1 = donner_temp();
                    System.out.println("entrer la categorie");
                    String category = sc.next();
                    ajouter_petit_dejeuner(type, prix, date, heure1, category);
                    break;
                case 8:
                    System.out.println("la facture est de " + get_facture());
                    break;
                default:
                    System.out.println("numero invalide");
                    break;
            }

        }

    }
}