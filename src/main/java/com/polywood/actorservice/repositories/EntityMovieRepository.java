package com.polywood.actorservice.repositories;


import com.polywood.actorservice.model.MoviesEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EntityMovieRepository extends PagingAndSortingRepository<MoviesEntity, Integer> {

    public MoviesEntity findByMovieid(String movieid);

}

