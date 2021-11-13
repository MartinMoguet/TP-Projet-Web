package Classes;

public class Musee {
    public String nomMusee;
    public String Ville;

    public Musee(String nomMusee, String ville) {
        this.nomMusee = nomMusee;
        Ville = ville;
    }

    public String getNomMusee() {
        return nomMusee;
    }

    public void setNomMusee(String nomMusee) {
        this.nomMusee = nomMusee;
    }

    public String getVille() {
        return Ville;
    }

    public void setVille(String ville) {
        Ville = ville;
    }
}
