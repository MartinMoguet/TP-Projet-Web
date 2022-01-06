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

    @Autowired
    public MorceauRepository morceauRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Commentaire> getAllCommentaire(){ return commentaireRepository.findAll();}

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void addCommentaire(Commentaire c){
        List<Utilisateur> utilisateurList = utilisateurRepository.findAll();
        List<Morceau> morceauList = morceauRepository.findAll();
        commentaireRepository.save(c);
        utilisateurList.forEach(utilisateur -> {
            if (c.getUtilisateur().getUsername().equals(utilisateur.getUsername())) {
                Utilisateur utilisateurAEnlever = c.getUtilisateur();
                c.setUtilisateur(utilisateur);
                utilisateur.getCommentaireList().add(c.getContenu());
                commentaireRepository.save(c);
                utilisateurRepository.deleteById(utilisateurAEnlever.getId());
            }});
        morceauList.forEach(morceau -> {
            if (c.getMorceau().equals(morceau.getNom())) {
                Morceau morceauAEnlever = c.getRealMorceau();
                c.setMorceau(morceau);
                morceau.getCommentaireList().add(c.getContenu());
                commentaireRepository.save(c);
                morceauRepository.deleteById(morceauAEnlever.getId());

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
        List<Morceau> morceauList = morceauRepository.findAll();
        commentaireList.forEach( c -> {
        commentaireRepository.save(c);
        utilisateurList.forEach(utilisateur -> {
            if (c.getUtilisateur().getUsername().equals(utilisateur.getUsername())) {
                Utilisateur utilisateurAEnlever = c.getUtilisateur();
                c.setUtilisateur(utilisateur);
                utilisateur.getCommentaireList().add(c.getContenu());
                commentaireRepository.save(c);
                utilisateurRepository.deleteById(utilisateurAEnlever.getId());
            }});
            morceauList.forEach(morceau -> {
                if (c.getMorceau().equals(morceau.getNom())) {
                    String morceauAEnlever = c.getMorceau();
                    c.setMorceau(morceau);
                    morceau.getCommentaireList().add(c.getContenu());
                    commentaireRepository.save(c);
                    morceauRepository.deleteById(morceauRepository.findMorceauByNom(morceauAEnlever).getId());
                }});
        });
    }

    @DELETE
    @Path("removeAllCommentaire")
    public void removeAllCommentaire(){ commentaireRepository.deleteAll();}

    @DELETE
    @Path("remove/{morceau}")
    public void removeAllCommentaireByMorceau(@PathParam("morceau") String morceau){
        commentaireRepository.deleteAllByMorceau_Nom(morceau);
    }


    @GET
    @Path("liste/{morceau}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Commentaire> getAllCommentaireByMorceau(@PathParam("morceau") String morceau){
        return commentaireRepository.findAllByMorceau_Nom(morceau);
    }

    @POST
    @Path("ajouter/{morceau}/{contenu}/{user}/{password}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addComment(@PathParam("morceau") String morceau, @PathParam("contenu") String contenu, @PathParam("user")String user, @PathParam("password") String password){
        Utilisateur utilisateur = utilisateurRepository.findUtilisateurByUsernameAndPassword(user, password);
        Morceau morceau1 = morceauRepository.findMorceauByNom(morceau);
        Commentaire commentaire = new Commentaire(contenu, morceau1, utilisateur);
        commentaireRepository.save(commentaire);
    }
}
