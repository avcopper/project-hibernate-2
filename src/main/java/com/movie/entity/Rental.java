package com.movie.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "rental", schema = "movie")
public class Rental implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="rental_id", nullable=false)
    private Long id;

    @Column(name="rental_date", nullable=false)
    private LocalDateTime rentalDate;

    @Column(name="return_date")
    private LocalDateTime returnDate;

    @Column(name="last_update", nullable=false)
    private LocalDateTime lastUpdate;

    @ManyToOne
    @JoinColumn(name = "inventory_id", nullable=false)
    private Inventory inventory;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable=false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "staff_id", nullable=false)
    private Staff staff;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(LocalDateTime rentalDate) {
        this.rentalDate = rentalDate;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }
}
