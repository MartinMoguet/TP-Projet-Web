package com.example.Projet.Spring.Boot.Controllers;

import com.example.Projet.Spring.Boot.Classes.Commentaire;
import com.example.Projet.Spring.Boot.Classes.Compositeur;
import com.example.Projet.Spring.Boot.Classes.Morceau;
import com.example.Projet.Spring.Boot.Classes.Utilisateur;
import com.example.Projet.Spring.Boot.Repositories.CommentaireRepository;
import com.example.Projet.Spring.Boot.Repositories.CompositeurRepository;
import com.example.Projet.Spring.Boot.Repositories.MorceauRepository;
import com.example.Projet.Spring.Boot.Repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Path("commentaire")
public class CommentaireController {

    @Autowired
    public CommentaireRepository commentaireRepository;

    @Autowired
    public UtilisateurRepository utilisateurRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Commentaire> getAllCommentaire(){ return (List<Commentaire>) commentaireRepository.findAll();}

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void addCommentaire(Commentaire c){
        List<Utilisateur> utilisateurList = utilisateurRepository.findAll();
        commentaireRepository.save(c);
        utilisateurList.forEach(utilisateur -> {
            if (c.getUtilisateur().equals(utilisateur.getUsername())) {
                Utilisateur utilisateurAEnlever = c.getUtilisateur();
                c.setUtilisateur(utilisateur);
                utilisateur.getCommentaireList().add(c.getContenu());
                commentaireRepository.save(c);
                commentaireRepository.deleteById(utilisateurAEnlever.getId());
            }});
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Optional<Commentaire> getCommentaireById(@PathParam("id") long id){return commentaireRepository.findById(id);}

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("ajoutMultipleCommentaire")
    public void addCommentaire(List<Commentaire> commentaireList){
        List<Utilisateur> utilisateurList = utilisateurRepository.findAll();
        commentaireList.forEach( c -> {
        commentaireRepository.save(c);
        utilisateurList.forEach(utilisateur -> {
            if (c.getUtilisateur().equals(utilisateur.getUsername())) {
                Utilisateur utilisateurAEnlever = c.getUtilisateur();
                c.setUtilisateur(utilisateur);
                utilisateur.getCommentaireList().add(c.getContenu());
                commentaireRepository.save(c);
                commentaireRepository.deleteById(utilisateurAEnlever.getId());
            }});
        });
    }

    @DELETE
    @Path("/removeAllCommentaire")
    public void removeAllCommentaire(){ commentaireRepository.deleteAll();}
}
