package com.example.Projet.Spring.Boot.Classes;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Optional;

@Entity
public class Commentaire implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;
    public String contenu;
    public String date;

    @ManyToOne( cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Morceau morceau;

    @ManyToOne( cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Utilisateur utilisateur;



    public Commentaire(String contenu, String date, Morceau morceau, Utilisateur utilisateur) {
        this.contenu = contenu;
        this.date = date;
        this.morceau = morceau;
        this.utilisateur = utilisateur;
    }

    public Commentaire() {

    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
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

    public String getMorceau() {
        return morceau.getNom();
    }

    public void setMorceau(Morceau morceau) {
        this.morceau = morceau;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Morceau getRealMorceau(){return  morceau;}


}
