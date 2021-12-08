package com.example.Projet.Spring.Boot.Classes;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@Entity

public class Oeuvre implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    private String description;

    private String dateExposition;
    private String dateCreation;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Auteur auteur;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Musee musee;

    @OneToMany(mappedBy = "Oeuvre", fetch = FetchType.EAGER)
    private Collection<Commentaire> commentaireList = new ArrayList<>();


    public Oeuvre(String nom, String description, Musee musee, Auteur auteur, String dateExposition, String dateCreation) {
        this.nom = nom;
        this.description = description;
        this.musee = musee;
        this.auteur = auteur;
        this.dateExposition = dateExposition;
        this.dateCreation = dateCreation;
    }

    public Oeuvre() {

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Collection<Commentaire> getCommentaireList() {
        return commentaireList;
    }

    public void setCommentaireList(Collection<Commentaire> commentaireList) {
        this.commentaireList = commentaireList;
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
