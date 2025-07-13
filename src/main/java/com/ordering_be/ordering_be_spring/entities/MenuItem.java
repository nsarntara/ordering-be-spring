package com.ordering_be.ordering_be_spring.entities;

import jakarta.persistence.*;


@Entity
@Table(name = "order_item")

public class MenuItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int quantity;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "menu_id")
    private Menu menu;
}
