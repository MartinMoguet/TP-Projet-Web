package com.example.Projet.Spring.Boot.Controllers;
import com.example.Projet.Spring.Boot.Classes.Compositeur;
import com.example.Projet.Spring.Boot.Classes.Utilisateur;

import com.example.Projet.Spring.Boot.Repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;

@Path("utilisateur")
public class UtilisateurController {
    @Autowired
    public UtilisateurRepository utilisateurRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Utilisateur> getAllUtilisateur() {
        return utilisateurRepository.findAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addUtilisateur(Utilisateur u) {
        utilisateurRepository.save(u);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Optional<Utilisateur> getUtilisateurById(@PathParam("id") long id){return utilisateurRepository.findById(id);}

    @DELETE
    @Path("/{id}")
    public void deleteUtilisateurById(@PathParam("id") long id){utilisateurRepository.deleteById(id);}

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/ajoutMultipleUtilisateur")
    public void ajouteUtilisateurMultiples(List<Utilisateur> utilisateurList){ utilisateurList.forEach(utilisateur -> utilisateurRepository.save(utilisateur));}

    @DELETE
    @Path("/removeAllUtilisateur")
    public void removeAllUtilisateur(){ utilisateurRepository.deleteAll();}

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("user/{username}/{password}")
    public Utilisateur getUserPasswordAndUsername(@PathParam("username") String username, @PathParam("password") String password){
        return utilisateurRepository.findUtilisateurByUsernameAndPassword(username, password);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("user/{username}/{password}")
    public void addUserPasswordAndUsername(@PathParam("username") String username, @PathParam("password") String password){
        Utilisateur utilisateur = new Utilisateur(username, password);
        utilisateurRepository.save(utilisateur);
    }



}
