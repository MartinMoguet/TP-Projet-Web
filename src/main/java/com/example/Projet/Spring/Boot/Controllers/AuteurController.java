package com.example.Projet.Spring.Boot.Controllers;

import com.example.Projet.Spring.Boot.Classes.Auteur;
import com.example.Projet.Spring.Boot.Repositories.AuteurRepository;
import com.fasterxml.jackson.databind.jsontype.impl.ClassNameIdResolver;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Path("auteur")
public class AuteurController {

    public AuteurRepository auteurRepository;
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Auteur> getAllAuteur() {
        return (List<Auteur>) auteurRepository.findAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addAuteur(Auteur a) {
        auteurRepository.save(a);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Optional<Auteur> getAuteurById(@PathParam("id") long id){return auteurRepository.findById(id);}

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{ajoutMultiple}")
    public void ajouteAuteurMultiples(List<Auteur> auteurList){ auteurList.forEach(auteur -> auteurRepository.save(auteur));}

    @DELETE
    @Path("/{removeAll:}")
    public void removeAllAuteur(){ auteurRepository.deleteAll();}
}
