package Classes;

public class Musée {
    public String nomMusée;
    public String Ville;

    public Musée(String nomMusée, String ville) {
        this.nomMusée = nomMusée;
        Ville = ville;
    }

    public String getNomMusée() {
        return nomMusée;
    }

    public void setNomMusée(String nomMusée) {
        this.nomMusée = nomMusée;
    }

    public String getVille() {
        return Ville;
    }

    public void setVille(String ville) {
        Ville = ville;
    }
}
