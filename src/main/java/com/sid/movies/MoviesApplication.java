package com.sid.movies;

import com.sid.movies.entities.Film;
import com.sid.movies.entities.Salle;
import com.sid.movies.entities.Ticket;
import com.sid.movies.service.ImoviesInitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class MoviesApplication implements CommandLineRunner {
@Autowired
private ImoviesInitService cinemaInitService;
@Autowired
private RepositoryRestConfiguration restConfiguration;


public static void main(String[] args) {
SpringApplication.run(MoviesApplication.class, args);
}
@Override
public void run(String... args) throws Exception {

restConfiguration.exposeIdsFor(Film.class,Salle.class,Ticket.class);
cinemaInitService.initVilles(); 
cinemaInitService.initCinemas();
cinemaInitService.initSalles();
cinemaInitService.initPalces();
cinemaInitService.initSeances();
cinemaInitService.initCategories();
cinemaInitService.initFilms();
cinemaInitService.initProjections();
cinemaInitService.initTickets();
}
}