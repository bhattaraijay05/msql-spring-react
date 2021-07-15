package com.javamysql.backend.model;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "studio")
public class Studio {
    @Id
    @Column(name = "studioId", unique = true, nullable = false, length = 40)
    private Integer studioId;

    @Column(name = "studioName", nullable = false, length = 40)
    private String studioName;

    @ManyToOne(optional = false)
    @JoinColumn(name = "genreId", nullable = false)
    private Genre genre;

    @JsonBackReference
    @ManyToMany(mappedBy = "studio", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Movie> movie;

    public Studio() {
    }

    public Studio(Integer studioId, String studioName, Genre genre) {
        this.studioId = studioId;
        this.studioName = studioName;
        this.genre = genre;
    }

    /**
     * @return Integer return the studioId
     */
    public Integer getStudioId() {
        return studioId;
    }

    /**
     * @param studioId the studioId to set
     */
    public void setStudioId(Integer studioId) {
        this.studioId = studioId;
    }

    /**
     * @return String return the studioName
     */
    public String getStudioName() {
        return studioName;
    }

    /**
     * @param studioName the studioName to set
     */
    public void setStudioName(String studioName) {
        this.studioName = studioName;
    }

    /**
     * @return Genre return the genre
     */
    public Genre getGenre() {
        return genre;
    }

    /**
     * @param genre the genre to set
     */
    public void setGenre(Genre genre) {
        this.genre = genre;
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
