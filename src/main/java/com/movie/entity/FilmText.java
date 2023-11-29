package com.movie.entity;

import java.io.Serializable;
import jakarta.persistence.*;

@Entity
@Table(name = "film_text", schema = "movie")
public class FilmText implements Serializable {
    @Id
    @OneToOne
    @JoinColumn(name = "film_id")
    private Film film;

    @Column(name="title", nullable=false)
    private String title;

    @Column(name="description")
    private String description;

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
