package com.example.Projet.Spring.Boot.Repositories;

import com.example.Projet.Spring.Boot.Classes.Morceau;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MorceauRepository extends JpaRepository<Morceau, Long> {
    Morceau findMorceauByNom(String nom);
    List<Morceau> findAllByCompositeur_Mouvement(String mouvement);





}
