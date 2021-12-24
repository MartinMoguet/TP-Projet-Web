package com.example.Projet.Spring.Boot.Repositories;

import com.example.Projet.Spring.Boot.Classes.Morceau;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MorceauRepository extends JpaRepository<Morceau, Long> {
}