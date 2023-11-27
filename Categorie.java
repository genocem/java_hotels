public class Categorie {
    private boolean bain, douche, tele;
    private int nombre_lits, prix;

    public Categorie(boolean bain, boolean douche, boolean tele, int nombre_lits) {
        this.bain = bain;
        this.douche = douche;
        this.tele = tele;
        this.nombre_lits = nombre_lits;

    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public boolean hasBain() {
        return bain;
    }

    public void setBain(boolean bain) {
        this.bain = bain;
    }

    public boolean hasDouche() {
        return douche;
    }

    public void setDouche(boolean douche) {
        this.douche = douche;
    }

    public boolean hasTele() {
        return tele;
    }

    public void setTele(boolean tele) {
        this.tele = tele;
    }

    public int getNombre_lits() {
        return nombre_lits;
    }

    public void setNombre_lits(int nombre_lits) {
        this.nombre_lits = nombre_lits;
    }

}
