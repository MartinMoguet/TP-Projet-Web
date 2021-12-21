package com.example.Projet.Spring.Boot.Controllers;

import com.example.Projet.Spring.Boot.Classes.Auteur;
import com.example.Projet.Spring.Boot.Classes.Musee;
import com.example.Projet.Spring.Boot.Repositories.MuseeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;

@Path("musee")

public class MuseeController {

    @Autowired
    public MuseeRepository museeRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Musee> getAllMusee(){ return (List<Musee>) museeRepository.findAll();}

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addMusee(Musee musee){ museeRepository.save(musee);}

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Optional<Musee> getMuseeById(@PathParam("id") long id){ return museeRepository.findById(id);}

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{ajoutMultipleMusee}")
    public void ajouteMuseeMultiples(List<Musee> museeList){ museeList.forEach(musee -> museeRepository.save(musee));}

    @DELETE
    @Path("/{removeAllMusee}")
    public void removeAllMusee(){ museeRepository.deleteAll();}
}
