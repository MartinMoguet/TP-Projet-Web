package com.example.Projet.Spring.Boot;

import com.example.Projet.Spring.Boot.Controllers.CommentaireController;
import com.example.Projet.Spring.Boot.Controllers.CompositeurController;
import com.example.Projet.Spring.Boot.Controllers.MorceauController;
import com.example.Projet.Spring.Boot.Controllers.UtilisateurController;
import com.example.Projet.Spring.Boot.Repositories.*;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


import javax.ws.rs.ApplicationPath;

@Component
@ApplicationPath("classic")
@Configuration
public class JerseyConfiguration extends ResourceConfig {

    public JerseyConfiguration() {


        register(CommentaireController.class);
        register(UtilisateurController.class);
        register(MorceauController.class);
        register(CompositeurController.class);
        register(CorsFilter.class);
    }

}