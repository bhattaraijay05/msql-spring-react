package com.javamysql.backend.model;

import java.util.Set;

import javax.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "trailer")
public class Trailer {

    @Id
    @Column(name = "trailerId", unique = true, nullable = false, length = 40)
    private Integer trailerId;

    @Column(name = "trailerUrl", nullable = false, length = 200)
    private String trailerUrl;

    @OneToMany(mappedBy = "trailer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Movie> movie;

    public Trailer() {

    }

    public Trailer(Integer trailerId, String trailerUrl) {
        this.trailerId = trailerId;
        this.trailerUrl = trailerUrl;
    }
}
