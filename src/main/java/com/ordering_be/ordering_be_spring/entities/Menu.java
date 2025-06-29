package com.ordering_be.ordering_be_spring.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
//@Getter @Setter @NoArgsConstructor
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;
    @NonNull
    private String name;
    @NonNull
    private String description;
    @NonNull

    private float price;


}
