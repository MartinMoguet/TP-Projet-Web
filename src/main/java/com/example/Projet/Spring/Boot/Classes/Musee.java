package com.example.Projet.Spring.Boot.Classes;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Musee {

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
