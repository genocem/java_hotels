public class Anomalie extends Exception{
    public Anomalie(int choix){
        switch (choix) {
            case 0:
                System.out.println("Reservation existe deja !");
                break;
        
            default:
                break;
        }
    }
}
