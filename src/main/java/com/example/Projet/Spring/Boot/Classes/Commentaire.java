package com.example.Projet.Spring.Boot.Classes;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
public class Commentaire implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;
    public String contenu;

    @CreatedDate
    private java.sql.Date date= new java.sql.Date(new Date().getTime());

    @ManyToOne( cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Morceau morceau;

    @ManyToOne( cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Utilisateur utilisateur;



    public Commentaire(String contenu, Morceau morceau, Utilisateur utilisateur) {
        this.contenu = contenu;
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

    public Date getDate() {
        return date;
    }

    public void setDate(java.sql.Date date) {
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
