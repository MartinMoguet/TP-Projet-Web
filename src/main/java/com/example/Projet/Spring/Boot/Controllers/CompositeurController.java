package com.example.Projet.Spring.Boot.Controllers;

import com.example.Projet.Spring.Boot.Classes.Compositeur;
import com.example.Projet.Spring.Boot.Repositories.CompositeurRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;


@Path("compositeur")
public class CompositeurController {

    @Autowired
    public CompositeurRepository compositeurRepository;
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Compositeur> getAllCompositeur() {
        return compositeurRepository.findAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addCompositeur(Compositeur a) {
        compositeurRepository.save(a);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Optional<Compositeur> getCompositeurById(@PathParam("id") long id){return compositeurRepository.findById(id);}

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{ajoutMultipleCompositeur}")
    public void ajouteCompositeurMultiples(List<Compositeur> compositeurList){ compositeurList.forEach(auteur -> compositeurRepository.save(auteur));}

    @DELETE
    @Path("/{removeAllCompositeur}")
    public void removeAllCompositeur(){ compositeurRepository.deleteAll();}

    @GET
    @Produces(MediaType.TEXT_HTML)
    @Path("nom/{nom}")
    public String getMoceauByNomPrenomCompositeur(@PathParam("nom") String nom){return compositeurRepository.findCompositeurByNomCompositeur(nom).getPrenomCompositeur()+" "+ compositeurRepository.findCompositeurByNomCompositeur(nom).getNomCompositeur();}
}
