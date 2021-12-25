package com.example.Projet.Spring.Boot.Controllers;

import com.example.Projet.Spring.Boot.Classes.Compositeur;
import com.example.Projet.Spring.Boot.Classes.Morceau;
import com.example.Projet.Spring.Boot.Repositories.CompositeurRepository;
import com.example.Projet.Spring.Boot.Repositories.MorceauRepository;
import org.springframework.beans.factory.annotation.Autowired;

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
        String compo = String.valueOf(m.getCompositeur().getNomCompositeur());
        List<Compositeur> compositeurList = compositeurRepository.findAll();
        morceauRepository.save(m);
        /*System.out.println(compo);
        boolean test = compo.equals("Chopin");
        System.out.println(test);
        if ("Chopin" == "Chopin"){
        System.out.println(m.getCompositeur().getNomCompositeur());
        System.out.println(m.getCompositeur().getPrenomCompositeur());
        System.out.println(compositeurList.get(0).getNomCompositeur());
        System.out.println(compositeurList.get(0).getPrenomCompositeur());}*/

        compositeurList.forEach(compositeur -> {
                    /*System.out.println(compositeur.getPrenomCompositeur());
                    System.out.println(compositeur.getNomCompositeur());*/
                    if (m.getCompositeur().getNomCompositeur().equals(compositeur.getNomCompositeur()) && m.getCompositeur().getPrenomCompositeur().equals(compositeur.getPrenomCompositeur()) ) {
                        System.out.println(m.getCompositeur().getId());
                        Compositeur compositeurAEnlever = m.getCompositeur();
                        //compositeurRepository.delete(compositeurAEnlever);
                        m.setCompositeur(compositeur);
                        //morceauRepository.save(m);
                        compositeurRepository.deleteById(compositeurAEnlever.getId());
                        System.out.println(compositeurAEnlever.getId());
                        compositeur.getMorceauList().add(m.getNom());
                        morceauRepository.save(m);


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
    @Path("/{ajoutMultipleMorceaux}")
    public void ajouteMorceauxMultiples(List<Morceau> morceauList){ morceauList.forEach(morceau -> morceauRepository.save(morceau));}

    @DELETE
    @Path("/{removeAllMorceau}")
    public void removeAllMorceau(){ morceauRepository.deleteAll();}
}
