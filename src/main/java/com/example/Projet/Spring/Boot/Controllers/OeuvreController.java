package com.example.Projet.Spring.Boot.Controllers;

import com.example.Projet.Spring.Boot.Classes.Oeuvre;
import com.example.Projet.Spring.Boot.Repositories.AuteurRepository;
import com.example.Projet.Spring.Boot.Repositories.OeuvreRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;

@Path("oeuvre")
public class OeuvreController {

    @Autowired
    public OeuvreRepository oeuvreRepository;
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Oeuvre> getAllOeuvre() {
        return (List<Oeuvre>) oeuvreRepository.findAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addOeuvre(Oeuvre oeuvre) {
        oeuvreRepository.save(oeuvre);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Optional<Oeuvre> getOeuvreById(@PathParam("id") long id){return oeuvreRepository.findById(id);}

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{ajoutMultipleOeuvre}")
    public void ajouteOeuvresMultiples(List<Oeuvre> oeuvreList){ oeuvreList.forEach(oeuvre -> oeuvreRepository.save(oeuvre));}

    @DELETE
    @Path("/{removeAllOeuvre}")
    public void removeAllOeuvre(){ oeuvreRepository.deleteAll();}
}
