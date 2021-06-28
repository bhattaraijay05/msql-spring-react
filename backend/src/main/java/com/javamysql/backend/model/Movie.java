package com.javamysql.backend.model;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "movie")
public class Movie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "movieId", nullable = false, unique = true, length = 40)
    private Integer movieId;

    @Column(name = "title", nullable = false, length = 40)
    private String name;

    @Column(name = "description", nullable = false, length = 500)
    private String description;

    @Column(name = "releaseDate", nullable = false, length = 64)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String releaseDate;

    @ManyToOne(optional = false)
    @JoinColumn(name = "studioId", nullable = false)
    @JsonManagedReference
    private Studio studio;

    @ManyToOne(optional = false)
    @JoinColumn(name = "trailerId", nullable = false)
    @JsonManagedReference
    private Trailer trailer;

    @ManyToOne(optional = false)
    @JoinColumn(name = "posterId", nullable = false)
    @JsonManagedReference
    private Poster poster;

    public Movie() {
    }

    public Movie(Integer movieId, String name, String description, String releaseDate, Studio studio, Trailer trailer,
            Poster poster) {
        this.movieId = movieId;
        this.name = name;
        this.description = description;
        this.releaseDate = releaseDate;
        this.studio = studio;
        this.trailer = trailer;
        this.poster = poster;
    }

    /**
     * @return Integer return the movieId
     */
    public Integer getMovieId() {
        return movieId;
    }

    /**
     * @param movieId the movieId to set
     */
    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    /**
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return String return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return String return the releaseDate
     */
    public String getReleaseDate() {
        return releaseDate;
    }

    /**
     * @param releaseDate the releaseDate to set
     */
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    /**
     * @return Studio return the studio
     */
    public Studio getStudio() {
        return studio;
    }

    /**
     * @param studio the studio to set
     */
    public void setStudio(Studio studio) {
        this.studio = studio;
    }

    /**
     * @return Trailer return the trailer
     */
    public Trailer getTrailer() {
        return trailer;
    }

    /**
     * @param trailer the trailer to set
     */
    public void setTrailer(Trailer trailer) {
        this.trailer = trailer;
    }

    /**
     * @return Poster return the poster
     */
    public Poster getPoster() {
        return poster;
    }

    /**
     * @param poster the poster to set
     */
    public void setPoster(Poster poster) {
        this.poster = poster;
    }

}
