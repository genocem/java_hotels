import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Hotel {
    private String nom;
    private Adresse adresse;
    private LocalTime temp_ouveture;
    private LocalTime temp_fermeture;
    private String categorie;
    private List<Chambre> chambrelist=new ArrayList<Chambre>();
    private List<Client> client_list=new ArrayList<Client>();

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

    public Chambre get_chambre(int num_chambre) {
        for (Chambre chambre : chambrelist) {
            if (chambre.getNum_ch() == num_chambre) {
                return chambre;
            }
        }
        return null;
    }

    public void ajouter_client(Client client) {
        client_list.add(client);
    }

    public void afficher_menu() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1-ajouter chambre\n");
            System.out.println("2-afficher chambre\n");
            System.out.println("3-ajouter client\n");
            System.out.println("4-afficher client\n");
            System.out.println("0-quitter\n");
            int choix = sc.nextInt();
            switch (choix) {
                case 0:
                    return;
                case 1:
                    String bain;
                    do {
                        System.out.println("il y a un baingnouire? O/N");
                        bain = sc.next();
                    } while (!(bain.equals("O") || bain.equals("N") || bain.equals("o") || bain.equals("n")) );
                    String douche;
                    do {
                        System.out.println("il y a une douche? O/N");
                        douche = sc.next();
                    } while (!(douche.equals("O") || douche.equals("N") || douche.equals("o") || douche.equals("n")));
                    String tele;
                    do {
                        System.out.println("il y a une tele? O/N");
                        tele = sc.next();
                    } while (!(tele.equals("O") || tele.equals("N") || tele.equals("o") || tele.equals("n")));
                    int nombre_lits;
                    do {
                        System.out.println("entrer le nombre de lits");
                        nombre_lits = 1;
                        try {
                            nombre_lits = sc.nextInt();
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. vous devez entrer un nombre.");
                            continue;
                        }
                    } while (nombre_lits <= 0);
                    double prix;
                    do {
                        System.out.println("entrer le prix");
                        prix = 1;
                        try {
                            prix = sc.nextDouble();
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. vous devez entrer un nombre.");
                            continue;
                        }
                    } while (prix <= 0);
                    Categorie categ = new Categorie(bain.equals("O") || bain.equals("o"), douche.equals("O") || douche.equals("o"), tele.equals("O") || tele.equals("o"), nombre_lits,
                            prix);

                    System.out.println("entrer l'etage");
                    int etage = 0;
                    try {
                        etage = sc.nextInt();
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. vous devez entrer un nombre.");
                        continue;
                    }
                    ajouter_chambre(categ, etage);
                    break;
                case 2:
                    afficher_chambre();
                    break;
                case 3:
                    System.out.println("entrer le nom du client");
                    String nom = sc.next();
                    System.out.println("entrer le prenom du client");
                    String prenom = sc.next();
                    Adresse adresse = Organisme.donner_adresse();
                    ajouter_client(new Client(nom, prenom, adresse));
                    break;
                case 4:
                    afficher_client();
                    break;
                default:
                    break;
            }
        }
    }

    public void afficher_chambre() {
        for (Chambre chambre : chambrelist) {
            System.out.println(chambre.getNum_ch());
        }
    }

    public void afficher_client() {
        while (true) {
            for (int i = 0; i < client_list.size(); i++) {
                System.out.println(i+1 + "-" + client_list.get(i).getNom());
            }
            System.out.println("0-retour");
            Scanner sc = new Scanner(System.in);
            int choix = 0;
            try {
                sc.nextInt();
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. vous devez entrer un nombre.");
                continue;
            }
            if (choix == 0) {
                return;
            }
            choix--;
            if (choix >= 0 && choix <= client_list.size()) {
                client_list.get(choix).afficher_menu(this);
            }
        }
    }

}