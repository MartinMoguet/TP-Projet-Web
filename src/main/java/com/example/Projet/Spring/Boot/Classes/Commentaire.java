package com.example.Projet.Spring.Boot.Classes;

import javax.persistence.*;
import java.io.Serializable;

@Entity

public class Commentaire implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;
    public String contenu;
    public String date;

    @ManyToOne( cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Oeuvre oeuvre;



    public Commentaire(long id, String contenu, String date, Oeuvre oeuvre) {
        this.id = id;
        this.contenu = contenu;
        this.date = date;
        this.oeuvre = oeuvre;
    }

    public Commentaire() {

    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
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
