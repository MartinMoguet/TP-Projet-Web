package Classes;

public class Auteur {

    public String nomAuteur;
    public String prenomAuteur;
    public String dateDeNaissance;
    public String dateDeMort;
    public String nationalite;
    public String mouvement;
    public String biographie;

    public Auteur(String nomAuteur, String prenomAuteur, String dateDeNaissance, String dateDeMort, String nationalite, String mouvement, String biographie)
    {
        this.nomAuteur = nomAuteur;
        this.prenomAuteur = prenomAuteur;
        this.dateDeNaissance = dateDeNaissance;
        this.dateDeMort = dateDeMort;
        this.nationalite = nationalite;
        this.mouvement = mouvement;
        this.biographie = biographie;
    }

    public String getNomAuteur() {
        return nomAuteur;
    }

    public void setNomAuteur(String nomAuteur) {
        this.nomAuteur = nomAuteur;
    }

    public String getPrenomAuteur() {
        return prenomAuteur;
    }

    public void setPrenomAuteur(String prenomAuteur) {
        this.prenomAuteur = prenomAuteur;
    }

    public String getDateDeNaissance() {
        return dateDeNaissance;
    }

    public void setDateDeNaissance(String dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }

    public String getDateDeMort() {
        return dateDeMort;
    }

    public void setDateDeMort(String dateDeMort) {
        this.dateDeMort = dateDeMort;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public String getMouvement() {
        return mouvement;
    }

    public void setMouvement(String mouvement) {
        this.mouvement = mouvement;
    }

    public String getBiographie() {
        return biographie;
    }

    public void setBiographie(String biographie) {
        this.biographie = biographie;
    }
}
