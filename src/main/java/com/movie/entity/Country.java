package com.movie.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "country", schema = "movie")
public class Country implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="country_id", nullable=false)
    private Long id;

    @Column(name="country", length=50, nullable=false)
    private String country;

    @Column(name="last_update", nullable=false)
    private LocalDateTime lastUpdate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
