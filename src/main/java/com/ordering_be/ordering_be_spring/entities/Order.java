package com.ordering_be.ordering_be_spring.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "`Order`")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
    @OneToMany
    @JoinTable
    private List<Menu> menus ;
    private float total ;
    private int tableNo;
    private LocalDateTime dateTime ;
}
