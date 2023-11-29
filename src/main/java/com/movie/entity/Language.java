package com.movie.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "language", schema = "movie")
public class Language implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="language_id", nullable=false)
    private Long id;

    @Column(name="name", length=20, nullable=false)
    private String name;

    @Column(name="last_update", nullable=false)
    private LocalDateTime lastUpdate;

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
}
