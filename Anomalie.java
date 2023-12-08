public class Anomalie extends Exception {
    String message = "Exception!!: ";

    public Anomalie(int choix) { // int choix =>String message
        // super(message);
        switch (choix) {
            case 0:
                message += "Deja reservée !\n";
                break;
            case 1:
                message += "Il faut que le nombre soit positive!\n";
                break;
            case 2:
                message += "Date donné invalide\n";
                break;
            case 3:
                message += "date de fin doit etre apres la date de debut\n";
                break;
            default:
                break;
        }
    }

    public String toString() {
        return message;
    }
}
