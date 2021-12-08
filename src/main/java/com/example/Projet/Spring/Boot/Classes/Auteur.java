package com.example.Projet.Spring.Boot.Classes;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
public class Auteur implements Serializable{


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    public String nomAuteur;
    public String prenomAuteur;
    public String dateDeNaissance;
    public String dateDeMort;
    public String nationalite;
    public String mouvement;
    public String biographie;

    @OneToMany(mappedBy = "auteur", fetch = FetchType.EAGER)
    private Collection<Oeuvre> oeuvreList = new ArrayList<>();


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

    public Auteur() {

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
