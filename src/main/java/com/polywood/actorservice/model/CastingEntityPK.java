package com.polywood.actorservice.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class CastingEntityPK implements Serializable {
    private String movieid;
    private Integer actorid;

    @Column(name = "movieid", nullable = false, length = 9, insertable = false, updatable = false)
    @Id
    public String getMovieid() {
        return movieid;
    }

    public void setMovieid(String movieid) {
        this.movieid = movieid;
    }

    @Column(name = "actorid", nullable = false, insertable = false, updatable = false)
    @Id
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
        CastingEntityPK that = (CastingEntityPK) o;
        return Objects.equals(movieid, that.movieid) &&
                Objects.equals(actorid, that.actorid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movieid, actorid);
    }
}
