package com.polywood.actorservice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "casting", schema = "polywood", catalog = "")
@IdClass(com.polywood.actorservice.model.CastingEntityPK.class)
public class CastingEntity {
    private String movieid;
    private Integer actorid;
    private MoviesEntity moviesByMovieid;
    private ActorsEntity actorsByActorid;

    @Id
    @Column(name = "movieid", nullable = false, length = 9, insertable = false, updatable = false)
    public String getMovieid() {
        return movieid;
    }

    public void setMovieid(String movieid) {
        this.movieid = movieid;
    }

    @Id
    @Column(name = "actorid", nullable = false, insertable = false, updatable = false)
    public Integer getActorid() {
        return actorid;
    }

    public void setActorid(Integer actorid) {
        this.actorid = actorid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CastingEntity that = (CastingEntity) o;
        return Objects.equals(movieid, that.movieid) &&
                Objects.equals(actorid, that.actorid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movieid, actorid);
    }

    @ManyToOne
    @JoinColumn(name = "movieid", referencedColumnName = "movieid", nullable = false, insertable = false, updatable = false)
    @JsonBackReference
    public MoviesEntity getMoviesByMovieid() {
        return moviesByMovieid;
    }

    public void setMoviesByMovieid(MoviesEntity moviesByMovieid) {
        this.moviesByMovieid = moviesByMovieid;
    }

    @ManyToOne
    @JoinColumn(name = "actorid", referencedColumnName = "actorid", nullable = false, insertable = false, updatable = false)
    @JsonBackReference
    public ActorsEntity getActorsByActorid() {
        return actorsByActorid;
    }

    public void setActorsByActorid(ActorsEntity actorsByActorid) {
        this.actorsByActorid = actorsByActorid;
    }

}
