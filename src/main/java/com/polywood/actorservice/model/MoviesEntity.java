package com.polywood.actorservice.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "movies", schema = "polywood", catalog = "")
public class MoviesEntity {
    private String movieid;
    private String title;
    private Integer releaseyear;
    private String releasedate;
    private String genre;
    private String writers;
    private String actors;
    private String directors;
    private Collection<CastingEntity> castingsByMovieid;

    @Id
    @Column(name = "movieid", nullable = false, length = 9, insertable = false, updatable = false)
    public String getMovieid() {
        return movieid;
    }

    public void setMovieid(String movieid) {
        this.movieid = movieid;
    }

    @Basic
    @Column(name = "title", nullable = true, length = 70)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "releaseyear", nullable = true)
    public Integer getReleaseyear() {
        return releaseyear;
    }

    public void setReleaseyear(Integer releaseyear) {
        this.releaseyear = releaseyear;
    }

    @Basic
    @Column(name = "releasedate", nullable = true, length = 11)
    public String getReleasedate() {
        return releasedate;
    }

    public void setReleasedate(String releasedate) {
        this.releasedate = releasedate;
    }

    @Basic
    @Column(name = "genre", nullable = true, length = 100)
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Basic
    @Column(name = "writers", nullable = true, length = 500)
    public String getWriters() {
        return writers;
    }

    public void setWriters(String writers) {
        this.writers = writers;
    }

    @Basic
    @Column(name = "actors", nullable = true, length = 250)
    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    @Basic
    @Column(name = "directors", nullable = true, length = 250)
    public String getDirectors() {
        return directors;
    }

    public void setDirectors(String directors) {
        this.directors = directors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MoviesEntity that = (MoviesEntity) o;
        return Objects.equals(movieid, that.movieid) &&
                Objects.equals(title, that.title) &&
                Objects.equals(releaseyear, that.releaseyear) &&
                Objects.equals(releasedate, that.releasedate) &&
                Objects.equals(genre, that.genre) &&
                Objects.equals(writers, that.writers) &&
                Objects.equals(actors, that.actors) &&
                Objects.equals(directors, that.directors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movieid, title, releaseyear, releasedate, genre, writers, actors, directors);
    }

    @OneToMany(mappedBy = "moviesByMovieid")
    @JsonManagedReference
    public Collection<CastingEntity> getCastingsByMovieid() {
        return castingsByMovieid;
    }

    public void setCastingsByMovieid(Collection<CastingEntity> castingsByMovieid) {
        this.castingsByMovieid = castingsByMovieid;
    }

}
