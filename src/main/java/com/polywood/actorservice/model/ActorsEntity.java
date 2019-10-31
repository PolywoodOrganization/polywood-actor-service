package com.polywood.actorservice.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "actors", schema = "polywood", catalog = "")
public class ActorsEntity {
    private Integer actorid;
    private String name;
    private Integer moviecount;
    private Integer ratingsum;
    private Double normalizedmovierank;
    private Integer googlehits;
    private String normalizedgooglerank;
    private Integer normalizedrating;
    private Collection<com.polywood.actorservice.model.CastingEntity> castingsByActorid;

    @Id
    @Column(name = "actorid", nullable = false, insertable = false, updatable = false)
    public Integer getActorid() {
        return actorid;
    }

    public void setActorid(Integer actorid) {
        this.actorid = actorid;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 22)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "moviecount", nullable = true)
    public Integer getMoviecount() {
        return moviecount;
    }

    public void setMoviecount(Integer moviecount) {
        this.moviecount = moviecount;
    }

    @Basic
    @Column(name = "ratingsum", nullable = true)
    public Integer getRatingsum() {
        return ratingsum;
    }

    public void setRatingsum(Integer ratingsum) {
        this.ratingsum = ratingsum;
    }

    @Basic
    @Column(name = "normalizedmovierank", nullable = true, precision = 17)
    public Double getNormalizedmovierank() {
        return normalizedmovierank;
    }

    public void setNormalizedmovierank(Double normalizedmovierank) {
        this.normalizedmovierank = normalizedmovierank;
    }

    @Basic
    @Column(name = "googlehits", nullable = true)
    public Integer getGooglehits() {
        return googlehits;
    }

    public void setGooglehits(Integer googlehits) {
        this.googlehits = googlehits;
    }

    @Basic
    @Column(name = "normalizedgooglerank", nullable = true, length = 18)
    public String getNormalizedgooglerank() {
        return normalizedgooglerank;
    }

    public void setNormalizedgooglerank(String normalizedgooglerank) {
        this.normalizedgooglerank = normalizedgooglerank;
    }

    @Basic
    @Column(name = "normalizedrating", nullable = true)
    public Integer getNormalizedrating() {
        return normalizedrating;
    }

    public void setNormalizedrating(Integer normalizedrating) {
        this.normalizedrating = normalizedrating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActorsEntity that = (ActorsEntity) o;
        return Objects.equals(actorid, that.actorid) &&
                Objects.equals(name, that.name) &&
                Objects.equals(moviecount, that.moviecount) &&
                Objects.equals(ratingsum, that.ratingsum) &&
                Objects.equals(normalizedmovierank, that.normalizedmovierank) &&
                Objects.equals(googlehits, that.googlehits) &&
                Objects.equals(normalizedgooglerank, that.normalizedgooglerank) &&
                Objects.equals(normalizedrating, that.normalizedrating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(actorid, name, moviecount, ratingsum, normalizedmovierank, googlehits, normalizedgooglerank, normalizedrating);
    }

    @OneToMany(mappedBy = "actorsByActorid")
    @JsonManagedReference
    public Collection<com.polywood.actorservice.model.CastingEntity> getCastingsByActorid() {
        return castingsByActorid;
    }

    public void setCastingsByActorid(Collection<com.polywood.actorservice.model.CastingEntity> castingsByActorid) {
        this.castingsByActorid = castingsByActorid;
    }

}
