package com.javamysql.backend.model;

import java.util.Set;

import javax.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "poster")
public class Poster {

    @Id
    @Column(name = "posterId", unique = true, nullable = false, length = 40)
    private Integer posterId;

    @Column(name = "posterUrl", nullable = false, length = 200)
    private String posterUrl;

    @OneToMany(mappedBy = "poster", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Movie> movie;

    public Poster() {

    }

    public Poster(Integer posterId, String posterUrl) {
        this.posterId = posterId;
        this.posterUrl = posterUrl;
    }

    /**
     * @return Integer return the posterId
     */
    public Integer getPosterId() {
        return posterId;
    }

    /**
     * @param posterId the posterId to set
     */
    public void setPosterId(Integer posterId) {
        this.posterId = posterId;
    }

    /**
     * @return String return the posterUrl
     */
    public String getPosterUrl() {
        return posterUrl;
    }

    /**
     * @param posterUrl the posterUrl to set
     */
    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
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
