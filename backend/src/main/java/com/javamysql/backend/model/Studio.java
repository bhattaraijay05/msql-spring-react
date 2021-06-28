package com.javamysql.backend.model;

import java.util.Set;

import javax.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "studio")
public class Studio {
    @Id
    @Column(name = "studioId", unique = true, nullable = false, length = 40)
    private Integer studioId;

    @Column(name = "studioName", nullable = false, length = 40)
    private String studioName;

    @OneToMany(mappedBy = "studio", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Movie> movie;

    public Studio() {

    }

    public Studio(Integer studioId, String studioName) {
        this.studioId = studioId;
        this.studioName = studioName;
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
