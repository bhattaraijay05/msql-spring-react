package com.javamysql.backend.model;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "trailer")
public class Trailer {

    @Id
    @Column(name = "trailerId", unique = true, nullable = false, length = 40)
    private Integer trailerId;

    @Column(name = "trailerUrl", nullable = false, length = 200)
    private String trailerUrl;

    @JsonBackReference
    @OneToMany(mappedBy = "trailer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Movie> movie;

    public Trailer() {

    }

    public Trailer(Integer trailerId, String trailerUrl) {
        this.trailerId = trailerId;
        this.trailerUrl = trailerUrl;
    }

    /**
     * @return Integer return the trailerId
     */
    public Integer getTrailerId() {
        return trailerId;
    }

    /**
     * @param trailerId the trailerId to set
     */
    public void setTrailerId(Integer trailerId) {
        this.trailerId = trailerId;
    }

    /**
     * @return String return the trailerUrl
     */
    public String getTrailerUrl() {
        return trailerUrl;
    }

    /**
     * @param trailerUrl the trailerUrl to set
     */
    public void setTrailerUrl(String trailerUrl) {
        this.trailerUrl = trailerUrl;
    }

    /**
     * @return Set<Movie> return the movie
     */
    public Set<Movie> getMovie() {
        return movie;
    }

    /**
     * @param movie the movie to set
     */
    public void setMovie(Set<Movie> movie) {
        this.movie = movie;
    }

}
