package com.javamysql.backend.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "movie")
public class Movie {

}
