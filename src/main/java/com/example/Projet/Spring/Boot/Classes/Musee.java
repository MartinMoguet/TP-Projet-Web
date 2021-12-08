package com.example.Projet.Spring.Boot.Classes;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Musee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nomMusee;
    private String Ville;

    @OneToMany(mappedBy= "Musee", fetch = FetchType.EAGER)
    private Collection<Oeuvre> oeuvreList = new ArrayList<>();



    public Musee(String nomMusee, String ville) {
        this.nomMusee = nomMusee;
        Ville = ville;
    }

    public Musee() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Collection<Oeuvre> getOeuvreList() {
        return oeuvreList;
    }

    public void setOeuvreList(Collection<Oeuvre> oeuvreList) {
        this.oeuvreList = oeuvreList;
    }

    public String getNomMusee() {
        return nomMusee;
    }

    public void setNomMusee(String nomMusee) {
        this.nomMusee = nomMusee;
    }

    public String getVille() {
        return Ville;
    }

    public void setVille(String ville) {
        Ville = ville;
    }
}
