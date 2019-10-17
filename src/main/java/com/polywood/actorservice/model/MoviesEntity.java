package com.polywood.actorservice.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "movies", schema = "bolywood", catalog = "")
public class MoviesEntity {
    private String imdbId;
    private String title;
    private Integer releaseYear;
    private String releaseDate;
    private String genre;
    private String writers;
    private String actors;
    private String directors;

    @Basic
    @Id
    @Column(name = "imdbId")
    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "releaseYear")
    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    @Basic
    @Column(name = "releaseDate")
    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Basic
    @Column(name = "genre")
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Basic
    @Column(name = "writers")
    public String getWriters() {
        return writers;
    }

    public void setWriters(String writers) {
        this.writers = writers;
    }

    @Basic
    @Column(name = "actors")
    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    @Basic
    @Column(name = "directors")
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
        return Objects.equals(imdbId, that.imdbId) &&
                Objects.equals(title, that.title) &&
                Objects.equals(releaseYear, that.releaseYear) &&
                Objects.equals(releaseDate, that.releaseDate) &&
                Objects.equals(genre, that.genre) &&
                Objects.equals(writers, that.writers) &&
                Objects.equals(actors, that.actors) &&
                Objects.equals(directors, that.directors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imdbId, title, releaseYear, releaseDate, genre, writers, actors, directors);
    }
}
