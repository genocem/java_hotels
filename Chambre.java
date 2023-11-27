import java.util.List;

public class Chambre {
    private int num_ch;
    private Categorie categorie;
    private boolean occuper = false;
    private int etage;
    private List<Reservation> reservations;     


    public Chambre(int num_ch, Categorie categorie, int etage) {
        this.num_ch = num_ch;
        this.categorie = categorie;
        this.etage = etage;
    }

    public int getNum_ch() {
        return num_ch;
    }

    public void setNum_ch(int num_ch) {
        this.num_ch = num_ch;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public boolean isOccuper() {
        return occuper;
    }

    public void setOccuper(boolean occuper) {
        this.occuper = occuper;
    }

    public int getEtage() {
        return etage;
    }

    public void setEtage(int etage) {
        this.etage = etage;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
    public void inserer_res(int index,Reservation nouv_res){
        reservations.add(index,nouv_res);
    }
}
