public class Anomalie extends Exception{
    public Anomalie(int choix){
        switch (choix) {
            case 0:
                System.out.println("Deja reservée !");
                break;
            case 1:
                System.out.println("Il faut que le nombre soit positive!");
                break;
            case 2:
                System.out.println("Date donné invalide");
                break;
            default:
                break;
        }
    }
}
