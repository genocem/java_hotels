import java.util.Date;

public class Reservation {
    private static int num_res=0;
    private Date date_res;
    private Date deb_res;
    private Date fin_res;
    private Chambre chambre;
    private Client client;

    public Reservation(Date date_res, Date deb_res, Date fin_res, Chambre chambre, Client client) {
        num_res++;
        this.date_res = date_res;
        this.deb_res = deb_res;
        this.fin_res = fin_res;
        this.chambre = chambre;
        this.client = client;
    }

    public Date getDeb_res() {
        return deb_res;
    }

    public void setDeb_res(Date deb_res) {
        this.deb_res = deb_res;
    }

    public Date getFin_res() {
        return fin_res;
    }

    public void setFin_res(Date fin_res) {
        this.fin_res = fin_res;
    }

    public Chambre getChambre() {
        return chambre;
    }

    public void setChambre(Chambre chambre) {
        this.chambre = chambre;
    }

    public int getNum_res() {
        return num_res;
    }

    public Date getDate_res() {
        return date_res;
    }

    public void setDate_res(Date date_res) {
        this.date_res = date_res;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    public boolean deja_reserve(Date resDate){
            if(resDate.compareTo(deb_res)>=0 && resDate.compareTo(fin_res)<=0)
                return true;
            return false;   
    }
}
