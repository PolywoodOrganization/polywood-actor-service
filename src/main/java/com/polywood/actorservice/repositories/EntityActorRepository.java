package com.polywood.actorservice.repositories;

import com.polywood.actorservice.model.ActorsEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntityActorRepository extends PagingAndSortingRepository<ActorsEntity, Integer> {

    public Page<ActorsEntity> findAll(Pageable pageable);

    public List<ActorsEntity> findActorsEntitiesByActorid(Integer actorid);

    public ActorsEntity findByActorid(Integer actorid);
    
    @Query(
            value = "SELECT * FROM actors a WHERE a.name LIKE CONCAT('%',:name,'%')",
            nativeQuery = true)
    public Page<ActorsEntity> findActorsByName(@Param("name") String name, Pageable pageable);
}
