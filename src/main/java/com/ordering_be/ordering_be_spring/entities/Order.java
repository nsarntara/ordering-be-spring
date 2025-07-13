package com.ordering_be.ordering_be_spring.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "`Order`")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;

    public float total;

    public int tableNo;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    public List<MenuItem> menus;
}
