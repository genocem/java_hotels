import java.util.List;
import java.util.Scanner;
import java.time.LocalTime;
import java.util.ArrayList;
public class Organisme {
    List<Hotel> hotel_list;

    Organisme() {
        hotel_list = new ArrayList<Hotel>();
    }

    public void ajouter_hotel_unique(Hotel hotel) {
        //on va ajouter un hotel ou son nom n'existe pas deja
        for (int i = 0; i < hotel_list.size(); i++) {
            if (hotel_list.get(i).getNom().equals(hotel.getNom())) {
                System.out.println("hotel deja existant");
                return;
            }
        }
        hotel_list.add(hotel);
    }



    public void afficher_hotel() {
        System.out.println("liste des hotels:\n");
        while (true) {
            for (int i = 0; i < hotel_list.size(); i++) {
                System.out.println(i+1 + "-" + hotel_list.get(i).getNom());
            }
            System.out.println("0-retour");
            Scanner sc = new Scanner(System.in);
            int choix = sc.nextInt();
            if (choix == 0) {
                return;
            }
            choix--;
            if (choix >=0 && choix <= hotel_list.size()) {
                hotel_list.get(choix).afficher_menu();
            }
        }
    }

    public void afficher_menu_organisme() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1-ajouter hotel\n");
            System.out.println("2-afficher hotel\n");
            System.out.println("0-quitter\n");
            int choix = sc.nextInt();
            switch (choix) {
                case 0:
                    return;
                case 1:
                    System.out.println("entrer le nom de l'hotel");
                    String nom = sc.nextLine()+sc.nextLine();
                    Adresse adresse = donner_adresse();

                    int heure_ouverture;
                    int heure_fermeture;
                    do {
                        System.out.println("entrer l'heure d'ouverture");
                        heure_ouverture = sc.nextInt();
                    } while (heure_ouverture < 0 || heure_ouverture > 23);
                    do {
                        System.out.println("entrer l'heure de fermeture");
                        heure_fermeture = sc.nextInt();
                    } while (heure_fermeture < 0 || heure_fermeture > 23);

                    int minute_ouverture;
                    int minute_fermeture ;
                    do {
                        System.out.println("entrer les minutes d'ouverture");
                        minute_ouverture = sc.nextInt();
                    } while (minute_ouverture < 0 || minute_ouverture > 59);
                    do {
                        System.out.println("entrer les minutes de fermeture");
                        minute_fermeture = sc.nextInt();
                    } while (minute_fermeture < 0 || minute_fermeture > 59);
                    System.out.println("entrer la categorie");
                    String categorie = sc.next();
                    Hotel hotel = new Hotel(nom, adresse, LocalTime.of(heure_ouverture, minute_ouverture),
                            LocalTime.of(heure_fermeture, minute_fermeture), categorie);
                    if (hotel!=null) {
                        ajouter_hotel(hotel);
                    }
                    break;
                case 2:
                    afficher_hotel();
                    break;
                default:
                    System.out.println("choix invalide");
                    sc.close();
                    break;
            }
        }

    }

    public static Adresse donner_adresse() {
        Scanner sc = new Scanner(System.in);

        System.out.println("entrer le nom de la rue");
        String nom_rue = sc.nextLine();
        System.out.println("entrer le numero de l'immeuble");
        int num_immeuble = sc.nextInt();
        System.out.println("entrer le nom de la commune");
        String nom_de_commune = sc.nextLine()+sc.nextLine();
        System.out.println("entrer le code postal");
        int code_postal = sc.nextInt();
        System.out.println("entrer le pays");
        String pays = sc.nextLine()+sc.nextLine();
        return new Adresse(nom_rue, num_immeuble, nom_de_commune, code_postal, pays);
    }

}
