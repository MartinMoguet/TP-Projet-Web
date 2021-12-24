package com.example.Projet.Spring.Boot.Controllers;

import com.example.Projet.Spring.Boot.Classes.Morceau;
import com.example.Projet.Spring.Boot.Repositories.MorceauRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;

@Path("morceau")
public class MorceauController {
    @Autowired
    public MorceauRepository morceauRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Morceau> getAllMorceau(){ return (List<Morceau>) morceauRepository.findAll();}

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Optional<Morceau> getMorceauById(@PathParam("id") long id){return morceauRepository.findById(id);}

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{ajoutMultipleMorceaux}")
    public void ajouteMorceauxMultiples(List<Morceau> morceauList){ morceauList.forEach(morceau -> morceauRepository.save(morceau));}

    @DELETE
    @Path("/{removeAllMorceau}")
    public void removeAllMorceau(){ morceauRepository.deleteAll();}
}
