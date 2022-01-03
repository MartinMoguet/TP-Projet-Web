package com.example.Projet.Spring.Boot;

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

        //register(AuteurRepository.class);
        register(CommentaireRepository.class);
        //register(MuseeRepository.class);
        //register(OeuvreRepository.class);
        register(UtilisateurRepository.class);
        register(CorsFilter.class);
    }

}