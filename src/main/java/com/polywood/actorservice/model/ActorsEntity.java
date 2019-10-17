package com.polywood.actorservice.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "actors", schema = "bolywood", catalog = "")
public class ActorsEntity {
    private Integer actorId;
    private String actorName;
    private Integer movieCount;
    private Integer ratingSum;
    private String normalizedMovieRank;
    private Integer googleHits;
    private String normalizedGoogleRank;
    private Integer normalizedRating;

    @Id
    @Column(name = "actorId")
    public Integer getActorId() {
        return actorId;
    }

    public void setActorId(Integer actorId) {
        this.actorId = actorId;
    }

    @Basic
    @Column(name = "actorName")
    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    @Basic
    @Column(name = "movieCount")
    public Integer getMovieCount() {
        return movieCount;
    }

    public void setMovieCount(Integer movieCount) {
        this.movieCount = movieCount;
    }

    @Basic
    @Column(name = "ratingSum")
    public Integer getRatingSum() {
        return ratingSum;
    }

    public void setRatingSum(Integer ratingSum) {
        this.ratingSum = ratingSum;
    }

    @Basic
    @Column(name = "normalizedMovieRank")
    public String getNormalizedMovieRank() {
        return normalizedMovieRank;
    }

    public void setNormalizedMovieRank(String normalizedMovieRank) {
        this.normalizedMovieRank = normalizedMovieRank;
    }

    @Basic
    @Column(name = "googleHits")
    public Integer getGoogleHits() {
        return googleHits;
    }

    public void setGoogleHits(Integer googleHits) {
        this.googleHits = googleHits;
    }

    @Basic
    @Column(name = "normalizedGoogleRank")
    public String getNormalizedGoogleRank() {
        return normalizedGoogleRank;
    }

    public void setNormalizedGoogleRank(String normalizedGoogleRank) {
        this.normalizedGoogleRank = normalizedGoogleRank;
    }

    @Basic
    @Column(name = "normalizedRating")
    public Integer getNormalizedRating() {
        return normalizedRating;
    }

    public void setNormalizedRating(Integer normalizedRating) {
        this.normalizedRating = normalizedRating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActorsEntity that = (ActorsEntity) o;
        return Objects.equals(actorId, that.actorId) &&
                Objects.equals(actorName, that.actorName) &&
                Objects.equals(movieCount, that.movieCount) &&
                Objects.equals(ratingSum, that.ratingSum) &&
                Objects.equals(normalizedMovieRank, that.normalizedMovieRank) &&
                Objects.equals(googleHits, that.googleHits) &&
                Objects.equals(normalizedGoogleRank, that.normalizedGoogleRank) &&
                Objects.equals(normalizedRating, that.normalizedRating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(actorId, actorName, movieCount, ratingSum, normalizedMovieRank, googleHits, normalizedGoogleRank, normalizedRating);
    }
}
