package com.example.Projet.Spring.Boot.Classes;

public class Oeuvre {

    String nom;
    String description;
    Musee musee;
    Auteur auteur;
    String dateExposition;
    String dateCreation;

    public Oeuvre(String nom, String description, Musee musee, Auteur auteur, String dateExposition, String dateCreation) {
        this.nom = nom;
        this.description = description;
        this.musee = musee;
        this.auteur = auteur;
        this.dateExposition = dateExposition;
        this.dateCreation = dateCreation;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Musee getMusee() {
        return musee;
    }

    public void setMusee(Musee musee) {
        this.musee = musee;
    }

    public Auteur getAuteur() {
        return auteur;
    }

    public void setAuteur(Auteur auteur) {
        this.auteur = auteur;
    }

    public String getDateExposition() {
        return dateExposition;
    }

    public void setDateExposition(String dateExposition) {
        this.dateExposition = dateExposition;
    }

    public String getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }
}
