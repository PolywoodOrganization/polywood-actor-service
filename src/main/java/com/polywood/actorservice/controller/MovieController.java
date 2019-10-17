package com.polywood.actorservice.controller;

import com.polywood.actorservice.model.MoviesEntity;
import com.polywood.actorservice.repositories.EntityMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/movies")
public class MovieController {

    private EntityMovieRepository anEntityMovieRepository;

    @Autowired
    public MovieController(EntityMovieRepository entityMovieRepository){
        this.anEntityMovieRepository = entityMovieRepository;
    }

    @GetMapping("/getMovies")
    public List<MoviesEntity> findAllMovies() {
        List<MoviesEntity> movies = null;
        try {
            movies = anEntityMovieRepository.findAll();
        } catch (Exception e) {

            ResponseEntity.notFound().build();
        }
        return movies;
    }

    @GetMapping("/getMovie/{id}")
    public MoviesEntity getMovieById(@PathVariable(value = "id") String id) {
        return anEntityMovieRepository.findByImdbId(id);
    }

}