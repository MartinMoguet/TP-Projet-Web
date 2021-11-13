package Classes;

public class Commentaire {
    public int id;
    public String contenu;
    public String date;
    public Oeuvre oeuvre;

    public Commentaire(int id, String contenu, String date, Oeuvre oeuvre) {
        this.id = id;
        this.contenu = contenu;
        this.date = date;
        this.oeuvre = oeuvre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Oeuvre getOeuvre() {
        return oeuvre;
    }

    public void setOeuvre(Oeuvre oeuvre) {
        this.oeuvre = oeuvre;
    }
}
