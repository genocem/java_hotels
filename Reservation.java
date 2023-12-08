import java.time.LocalDate;

public class Reservation {
    private static int num_res_total=0;
    private int num_res;
    private LocalDate date_res;
    private LocalDate deb_res;
    private LocalDate fin_res;
    private Chambre chambre;
    private Client client;

    public Reservation(LocalDate date_res, LocalDate deb_res, LocalDate fin_res, Chambre chambre, Client client) {
        try {
            if (deb_res.compareTo(fin_res)>0) {
                throw new Anomalie(3);
            }
            if (date_res.compareTo(deb_res)>0) {
                throw new Anomalie(3);
            }
            num_res=num_res_total;
            num_res_total++;
            this.date_res = date_res;
            this.deb_res = deb_res;
            this.fin_res = fin_res;
            this.chambre = chambre;
            this.client = client;
            
        } catch (Anomalie e) {
            System.out.println(e);
        }
    }

    public LocalDate getDeb_res() {
        return deb_res;
    }

    public void setDeb_res(LocalDate deb_res) {
        this.deb_res = deb_res;
    }

    public LocalDate getFin_res() {
        return fin_res;
    }

    public Chambre getChambre() {
        return chambre;
    }

    public void setChambre(Chambre chambre) {
        this.chambre = chambre;
    }

    public int getnum_res_total() {
        return num_res_total;
    }

    public LocalDate getDate_res() {
        return date_res;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    public boolean deja_reserve(LocalDate resDate){
            if(resDate.compareTo(deb_res)>=0 && resDate.compareTo(fin_res)<=0)
                return true;
            return false;   
    }

    public static int getNum_res_total() {
        return num_res_total;
    }

    public int getNum_res() {
        return num_res;
    }
    
}
