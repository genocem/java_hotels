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
        try {
            if (prix <= 0) {
                throw new Anomalie(1);
            }
        } catch (Anomalie e) {
            System.out.println(e);
        }
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
        try {
            if (prix <= 0) {
                throw new Anomalie(1);
            }
            this.nombre_lits = nombre_lits;
        } catch (Anomalie e) {
            System.out.println(e);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Categorie other = (Categorie) obj;
        if (bain != other.bain)
            return false;
        if (douche != other.douche)
            return false;
        if (tele != other.tele)
            return false;
        if (nombre_lits != other.nombre_lits)
            return false;
        if (prix != other.prix)
            return false;
        return true;
    }

}
