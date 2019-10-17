package com.polywood.actorservice.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "movieactors", schema = "bolywood", catalog = "")
public class MovieactorsEntity {
    private String movieId;
    private String actor;

    @Basic
    @Id
    @Column(name = "movieId")
    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    @Basic
    @Column(name = "actor")
    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieactorsEntity that = (MovieactorsEntity) o;
        return Objects.equals(movieId, that.movieId) &&
                Objects.equals(actor, that.actor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movieId, actor);
    }
}
