package com.example.Projet.Spring.Boot.Repositories;

import com.example.Projet.Spring.Boot.Classes.Commentaire;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface CommentaireRepository extends JpaRepository<Commentaire, Long> {

    void deleteAllByMorceau_Nom(String nom);
    List<Commentaire> findAllByMorceau_Nom(String nom);

}
