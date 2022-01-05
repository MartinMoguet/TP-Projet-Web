package com.example.Projet.Spring.Boot.Repositories;

import com.example.Projet.Spring.Boot.Classes.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur,Long> {
    public Utilisateur findUtilisateurByUsernameAndPassword(String username, String password);
}
