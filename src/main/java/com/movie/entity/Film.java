package com.movie.entity;

import java.util.Set;
import java.util.HashSet;
import java.io.Serializable;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@org.hibernate.annotations.NamedQuery(
        name = "Film_Count",
        query = "select count(*) from Film"
)
@Entity
@Table(name = "film", schema = "movie")
public class Film implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="film_id", nullable=false)
    private Long id;

    @Column(name="title", length=128, nullable=false)
    private String title;

    @Column(name="description")
    private String description;

    @Column(name="release_year")
    private Integer releaseYear;

    @Column(name="rental_duration", nullable=false)
    private Integer rentalDuration;

    @Column(name="rental_rate", nullable=false)
    private Float rentalRate;

    @Column(name="length")
    private Integer length;

    @Column(name="replacement_cost", nullable=false)
    private Float replacementCost;

    @Column(name="last_update", nullable=false)
    private LocalDateTime lastUpdate;

    @Column(name="rating")
    //@Enumerated(EnumType.ORDINAL)
    private String rating;

    @Column(name="special_features")
    //@Enumerated(EnumType.ORDINAL)
    private String specialFeatures;

    @ManyToOne
    @JoinColumn(name = "language_id", nullable=false)
    private Language language;

    @ManyToOne
    @JoinColumn(name = "original_language_id")
    private Language originalLanguage;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="film_actor",
            joinColumns= @JoinColumn(name="film_id", referencedColumnName="film_id"),
            inverseJoinColumns=@JoinColumn(name="actor_id", referencedColumnName="actor_id"))
    private Set<Actor> actors = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="film_category",
            joinColumns=@JoinColumn(name="film_id", referencedColumnName="film_id"),
            inverseJoinColumns=@JoinColumn(name="category_id", referencedColumnName="category_id"))
    private Set<Category> categories = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Integer getRentalDuration() {
        return rentalDuration;
    }

    public void setRentalDuration(Integer rentalDuration) {
        this.rentalDuration = rentalDuration;
    }

    public Float getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(Float rentalRate) {
        this.rentalRate = rentalRate;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Float getReplacementCost() {
        return replacementCost;
    }

    public void setReplacementCost(Float replacementCost) {
        this.replacementCost = replacementCost;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getSpecialFeatures() {
        return specialFeatures;
    }

    public void setSpecialFeatures(String specialFeatures) {
        this.specialFeatures = specialFeatures;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public Language getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(Language originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public Set<Actor> getActors() {
        return actors;
    }

    public void setActors(Set<Actor> actors) {
        this.actors = actors;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
}
