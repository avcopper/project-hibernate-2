package com.movie.entity;

import java.util.Set;
import java.util.HashSet;
import java.io.Serializable;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "category", schema = "movie")
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="category_id", nullable=false)
    private Long id;

    @Column(name="name", length=25, nullable=false)
    private String name;

    @Column(name="last_update", nullable=false)
    private LocalDateTime lastUpdate;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="film_category",
            joinColumns=@JoinColumn(name="category_id", referencedColumnName="category_id"),
            inverseJoinColumns=@JoinColumn(name="film_id", referencedColumnName="film_id"))
    private Set<Film> films = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Set<Film> getFilms() {
        return films;
    }

    public void setFilms(Set<Film> films) {
        this.films = films;
    }
}
