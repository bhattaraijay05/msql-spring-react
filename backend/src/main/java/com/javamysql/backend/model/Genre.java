package com.javamysql.backend.model;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "genre")
public class Genre {
    @Id
    @Column(name = "genreId", unique = true, nullable = false, length = 40)
    private Integer genreId;

    @Column(name = "genreName", nullable = false, length = 200)
    private String genreName;

    @JsonBackReference
    @OneToMany(mappedBy = "genre", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Studio> studio;

    public Genre() {
    }

    public Genre(Integer genreId, String genreName) {
        this.genreId = genreId;
        this.genreName = genreName;
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
     * @return String return the genreName
     */
    public String getGenreName() {
        return genreName;
    }

    /**
     * @param genreName the genreName to set
     */
    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    /**
     * @return Set<Studio> return the studio
     */
    public Set<Studio> getStudio() {
        return studio;
    }

    /**
     * @param studio the studio to set
     */
    public void setStudio(Set<Studio> studio) {
        this.studio = studio;
    }

}
