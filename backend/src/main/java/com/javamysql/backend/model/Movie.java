package com.javamysql.backend.model;

import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "movie")
public class Movie {

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
    private Date releaseDate;

    @Column(name = "genreId", nullable = false, length = 20)
    private Integer genreId;

    @Column(name = "rating", nullable = false, length = 20)
    private Integer rating;

    @Column(name = "posterId", nullable = false, length = 20)
    private Integer posterId;

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
     * @return Date return the releaseDate
     */
    public Date getReleaseDate() {
        return releaseDate;
    }

    /**
     * @param releaseDate the releaseDate to set
     */
    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    /**
     * @return Integer return the genreId
     */
    public Integer getGenreId() {
        return genreId;
    }

    /**
     * @param genreId the genreId to set
     */
    public void setGenreId(Integer genreId) {
        this.genreId = genreId;
    }

    /**
     * @return Integer return the rating
     */
    public Integer getRating() {
        return rating;
    }

    /**
     * @param rating the rating to set
     */
    public void setRating(Integer rating) {
        this.rating = rating;
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

}
