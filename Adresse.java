public class Adresse {
    private String nom_rue;
    private int num_immeuble;
    private String nom_de_commune;
    private int code_postal;
    private String pays;
    // facultatifs:
    private int num_tel;
    private String email;
    private String adresse_web;

    public Adresse(String nom_rue, int num_immeuble, String nom_de_commune, int code_postal, String pays) {
        try {
            if (code_postal < 0 || num_immeuble<0) {
                throw new IllegalArgumentException("idClient must be non-negative");
            }
            this.nom_rue = nom_rue;
            this.num_immeuble = num_immeuble;
            this.nom_de_commune = nom_de_commune;
            this.code_postal = code_postal;
            this.pays = pays;
            num_tel = 0;
            email = null;
            adresse_web = null;

        } catch (IllegalArgumentException e) {
            System.out.println("code postal invalide");
        }
    }

    public String getNom_rue() {
        return nom_rue;
    }

    public void setNom_rue(String nom_rue) {
        this.nom_rue = nom_rue;
    }

    public int getNum_immeuble() {
        return num_immeuble;
    }

    public void setNum_immeuble(int num_immeuble) {
        try {
            if (num_immeuble < 0)
                throw new IllegalArgumentException("idClient must be non-negative");
            this.num_immeuble = num_immeuble;
        } catch (IllegalArgumentException e) {
            System.out.println("numero d'immeuble invalide");
        }
    }

    public String getNom_de_commune() {
        return nom_de_commune;
    }

    public void setNom_de_commune(String nom_de_commune) {
        this.nom_de_commune = nom_de_commune;
    }

    public int getCode_postal() {
        return code_postal;
    }

    public void setCode_postal(int code_postal) {
        try {
            if (code_postal < 0)
                throw new IllegalArgumentException("idClient must be non-negative");
            this.code_postal = code_postal;
        } catch (IllegalArgumentException e) {
            System.out.println("code postal invalide");
        }
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public int getNum_tel() {
        return num_tel;
    }

    public void setNum_tel(int num_tel) {
        this.num_tel = num_tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresse_web() {
        return adresse_web;
    }

    public void setAdresse_web(String adresse_web) {
        this.adresse_web = adresse_web;
    }

    public String toString() {
        String facultative = "";
        if (num_tel != 0)
            facultative += "num tel: " + num_tel;
        if (email != null)
            facultative += "email: " + email;
        if (adresse_web != null)
            facultative += "adresse web: " + adresse_web;
        return "num rue: " + nom_rue + "num immeuble: " + num_immeuble + "nom de commune: " + nom_de_commune
                + "code postal: " + code_postal + "pays: " + pays + facultative;
    }
}
// 
