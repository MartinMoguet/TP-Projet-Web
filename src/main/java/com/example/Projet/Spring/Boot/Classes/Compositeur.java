package com.example.Projet.Spring.Boot.Classes;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
public class Compositeur implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    public String nomCompositeur;
    public String prenomCompositeur;
    public String dateDeNaissance;
    public String dateDeMort;
    public String nationalite;
    public String mouvement;
    public String biographie;

    @OneToMany(mappedBy = "compositeur", fetch = FetchType.EAGER)
    private Collection<Morceau> morceauList = new ArrayList<>();


    public Compositeur(String nomCompositeur, String prenomCompositeur, String dateDeNaissance, String dateDeMort, String nationalite, String mouvement, String biographie) {
        this.nomCompositeur = nomCompositeur;
        this.prenomCompositeur = prenomCompositeur;
        this.dateDeNaissance = dateDeNaissance;
        this.dateDeMort = dateDeMort;
        this.nationalite = nationalite;
        this.mouvement = mouvement;
        this.biographie = biographie;
    }

    public Compositeur() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomCompositeur() {
        return nomCompositeur;
    }

    public void setNomCompositeur(String nomCompositeur) {
        this.nomCompositeur = nomCompositeur;
    }

    public String getPrenomCompositeur() {
        return prenomCompositeur;
    }

    public void setPrenomCompositeur(String prenomCompositeur) {
        this.prenomCompositeur = prenomCompositeur;
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

    public Collection<Morceau> getMorceauList() {
        return morceauList;
    }

    public void setMorceauList(Collection<Morceau> morceauList) {
        this.morceauList = morceauList;
    }
}


