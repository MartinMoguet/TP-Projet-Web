package com.example.Projet.Spring.Boot.Controllers;

import com.example.Projet.Spring.Boot.Classes.Compositeur;
import com.example.Projet.Spring.Boot.Classes.Morceau;
import com.example.Projet.Spring.Boot.Repositories.CompositeurRepository;
import com.example.Projet.Spring.Boot.Repositories.MorceauRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Path("morceau")
public class MorceauController {
    @Autowired
    public MorceauRepository morceauRepository;

    @Autowired
    public CompositeurRepository compositeurRepository;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void addMorceau(Morceau m){
        List<Compositeur> compositeurList = compositeurRepository.findAll();
        morceauRepository.save(m);
        compositeurList.forEach(compositeur -> {
            if (m.getCompositeur().getNomCompositeur().equals(compositeur.getNomCompositeur()) && m.getCompositeur().getPrenomCompositeur().equals(compositeur.getPrenomCompositeur()) ) {
                Compositeur compositeurAEnlever = m.getCompositeur();
                m.setCompositeur(compositeur);
                compositeur.getMorceauList().add(m.getNom());
                morceauRepository.save(m);
                compositeurRepository.deleteById(compositeurAEnlever.getId());
            }});
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Morceau> getAllMorceau(){ return (List<Morceau>) morceauRepository.findAll();}

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Optional<Morceau> getMorceauById(@PathParam("id") long id){return morceauRepository.findById(id);}

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/ajoutMultipleMorceaux")
    public void ajouteMorceauxMultiples(List<Morceau> morceauList){
        List<Compositeur> compositeurList = compositeurRepository.findAll();
        morceauList.forEach(m ->{
        morceauRepository.save(m);
        compositeurList.forEach(compositeur -> {
            if (m.getCompositeur().getNomCompositeur().equals(compositeur.getNomCompositeur()) && m.getCompositeur().getPrenomCompositeur().equals(compositeur.getPrenomCompositeur()) ) {
                Compositeur compositeurAEnlever = m.getCompositeur();
                m.setCompositeur(compositeur);
                compositeur.getMorceauList().add(m.getNom());
                morceauRepository.save(m);
                compositeurRepository.deleteById(compositeurAEnlever.getId());
            }}); });
    }

    @DELETE
    @Path("/{removeAllMorceau}")
    public void removeAllMorceau(){ morceauRepository.deleteAll();}

    @GET
    @Produces(MediaType.TEXT_HTML)
    @Path("nom/{nom}")
    public String getMoceauByNom(@PathParam("nom") String nom){return morceauRepository.findMorceauByNom(nom).getNom() ;}

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("liste")
    public List<String> getAllMorceauNom(){
        List<Morceau> morceauList = morceauRepository.findAll();
        List<String> nomMorceauList = new ArrayList<>();
        morceauList.forEach(morceau -> {
            nomMorceauList.add(morceau.getNom());
        });
        return nomMorceauList;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("liste/{mouvement}")
    public List<String> getAllMorceauByMouvement(@PathParam("mouvement") String mouvement){
        List<Morceau> morceauList = morceauRepository.findAllByCompositeur_Mouvement(mouvement);
        List<String> nomMorceauList = new ArrayList<>();
        morceauList.forEach(morceau -> {
            nomMorceauList.add(morceau.getNom());
        });
        return nomMorceauList;

    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("compositeur/{nom}")
    public String getMorceauCompositeur(@PathParam("nom") String nom){
        Morceau m = morceauRepository.findMorceauByNom(nom);
        return m.getCompositeur().prenomCompositeur + " " +m.getCompositeur().getNomCompositeur();
    }

}
