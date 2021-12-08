package com.example.Projet.Spring.Boot.Classes;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Utilisateur implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String username;
    private String password;

    @ManyToMany( mappedBy = "Utilisateur", fetch = FetchType.EAGER)
    private Collection<Commentaire> commentaireList = new ArrayList<>();

    public Utilisateur(String username, String password){
        this.username = username;
        this.password = password;
    }

    public Utilisateur() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<Commentaire> getCommentaireList() {
        return commentaireList;
    }

    public void setCommentaireList(Collection<Commentaire> commentaireList) {
        this.commentaireList = commentaireList;
    }
}
