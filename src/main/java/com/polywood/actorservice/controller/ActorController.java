package com.polywood.actorservice.controller;


import com.polywood.actorservice.model.ActorsEntity;
import com.polywood.actorservice.model.CastingEntity;
import com.polywood.actorservice.model.MoviesEntity;
import com.polywood.actorservice.repositories.EntityActorRepository;
import com.polywood.actorservice.repositories.EntityCastingRepository;
import com.polywood.actorservice.repositories.EntityMovieRepository;
import com.polywood.actorservice.tools.OffsetBasedPageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@CrossOrigin
@RequestMapping("/actors")
public class ActorController {

    private EntityMovieRepository anEntityMovieRepository;
    private EntityCastingRepository anEntityCastingRepository;
    private EntityActorRepository anEntityActorRepository;

    @Autowired
    public ActorController(EntityMovieRepository entityMovieRepository,
                           EntityCastingRepository entityCastingRepository,
                           EntityActorRepository entityActorRepository){
        this.anEntityMovieRepository = entityMovieRepository;
        this.anEntityCastingRepository = entityCastingRepository;
        this.anEntityActorRepository = entityActorRepository;
    }

    @RequestMapping(value = "", method = GET)
    @ResponseBody
    public List<ActorsEntity> findAllActorsPaged(
            @RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size, @RequestParam("sort") Optional<String> sort) {

        Pageable pageable =
                PageRequest.of(page.orElse(0), size.orElse(Integer.MAX_VALUE), Sort.by(sort.orElse("name")));

        Page<ActorsEntity> actors = null;

        try {
            actors = anEntityActorRepository.findAll(pageable);
        } catch (Exception e) {
            e.printStackTrace();
            ResponseEntity.notFound().build();
        }

        if (actors == null)
            ResponseEntity.notFound().build();
        System.out.println(actors);

        return Objects.requireNonNull(actors).getContent();
    }
    
    @RequestMapping(value = "/maxPage", method = GET)
    public int getAllActorsPages(@RequestParam("size") Optional<Integer> size) {
        Pageable pageable = PageRequest.of(0, size.orElse(Integer.MAX_VALUE));
        Page<ActorsEntity> actors = null;
        try {
            actors = anEntityActorRepository.findAll(pageable);
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        
        if(actors == null)
            ResponseEntity.notFound().build();
        
        return Objects.requireNonNull(actors).getTotalPages();
    }

    @GetMapping("/{id}")
    public ActorsEntity getActorById(@PathVariable(value = "id") Integer id) {
        return anEntityActorRepository.findByActorid(id);
    }

    @GetMapping("/filmography/{id}")
    public List<MoviesEntity> getFilmographyById(@PathVariable(value = "id") Integer id) {
        List<MoviesEntity> moviesEntities = new ArrayList<>();
        List<CastingEntity> castingEntities = anEntityCastingRepository.findCastingEntitiesByActorid(id);
        for (CastingEntity castingEntity : castingEntities) {
            moviesEntities.add(castingEntity.getMoviesByMovieid());
        }

        return moviesEntities;
    }
    
    @GetMapping("/name/{name}")
    public List<ActorsEntity> getActorsByName(@PathVariable(value = "name") String name,
                                               @RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size, @RequestParam("sort") Optional<String> sort) {
        Pageable pageable =
                PageRequest.of(page.orElse(0), size.orElse(Integer.MAX_VALUE), Sort.by(sort.orElse("name")));
        
        Page<ActorsEntity> actors = null;
        try {
            actors = anEntityActorRepository.findActorsByName(name.replace("+"," "), pageable);
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        
        if(actors == null)
            ResponseEntity.notFound().build();
        
        return Objects.requireNonNull(actors).getContent();
    }
}
