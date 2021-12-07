package com.example.Projet.Spring.Boot.Controllers;

import com.example.Projet.Spring.Boot.Classes.Auteur;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;


@Path("auteur")
public class AuteurController {

    private static final List<Auteur> auteurList = new ArrayList<>();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Auteur> getAllAuteur() {
        //auteurList.add(n);
        return auteurList;
    }
}
