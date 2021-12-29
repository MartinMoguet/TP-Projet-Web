package com.example.Projet.Spring.Boot.Classes;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Entity
public class Morceau implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nom;
    private String duree;
    private String description;
    private String dateCreation;
    private String url;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Compositeur compositeur;

    @OneToMany(mappedBy = "morceau",fetch = FetchType.EAGER)
    private Collection<Commentaire> commentaireList = new ArrayList<>();

    public Morceau(String nom, String duree, String description, String dateCreation, Compositeur compositeur, String url) {
        this.nom = nom;
        this.duree = duree;
        this.description = description;
        this.dateCreation = dateCreation;
        this.compositeur = compositeur;
        this.url = url;

    }

    public Morceau(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Compositeur getCompositeur() {
        return compositeur;
    }

    public void setCompositeur(Compositeur compositeur) {
        this.compositeur = compositeur; //.orElse(null);
    }

    public List<String> getCommentaireList() {
        List<String> commentaires = new ArrayList<>();
        commentaireList.forEach(commentaire -> commentaires.add(commentaire.getContenu()));
        return commentaires;
    }

    public void setCommentaireList(Collection<Commentaire> commentaireList) {
        this.commentaireList = commentaireList;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
