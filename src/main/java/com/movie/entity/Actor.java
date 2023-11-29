package com.movie.entity;

import java.util.Set;
import java.util.HashSet;
import java.io.Serializable;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "actor", schema = "movie")
public class Actor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="actor_id", nullable=false)
    private Long id;

    @Column(name="first_name", length=45, nullable=false)
    private String firstName;

    @Column(name="last_name", length=45, nullable=false)
    private String lastName;

    @Column(name="last_update", nullable=false)
    private LocalDateTime lastUpdate;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="film_actor",
            joinColumns=@JoinColumn(name="actor_id", referencedColumnName="actor_id"),
            inverseJoinColumns=@JoinColumn(name="film_id", referencedColumnName="film_id"))
    private Set<Film> films = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Set<Film> getTasks() {
        return films;
    }

    public void setTasks(Set<Film> films) {
        this.films = films;
    }
}
