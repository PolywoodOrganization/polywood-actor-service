package com.polywood.actorservice.repositories;


import com.polywood.actorservice.model.MoviesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EntityMovieRepository extends JpaRepository<MoviesEntity, Integer> {

    public List<MoviesEntity> findAll();
    public MoviesEntity findByImdbId(String imdbId);
}

