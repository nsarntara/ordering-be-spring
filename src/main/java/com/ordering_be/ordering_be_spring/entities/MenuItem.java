package com.ordering_be.ordering_be_spring.entities;

import jakarta.persistence.*;
import java.math.BigDecimal;

/**
 * Represents a single menu item that can be ordered (e.g., Pizza, Burger).
 */
@Entity
public class MenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private BigDecimal price;

    // Constructors
    public MenuItem() {}

    public MenuItem(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    // Getters and Setters

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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
