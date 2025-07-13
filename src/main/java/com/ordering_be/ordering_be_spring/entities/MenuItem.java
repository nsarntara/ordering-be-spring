package com.ordering_be.ordering_be_spring.entities;

import com.ordering_be.ordering_be_spring.Models.NewMenuItemRequest;
import com.ordering_be.ordering_be_spring.Repository.MenuRepository;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;


@Entity
@Table(name = "order_item")
@NoArgsConstructor


public class MenuItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int quantity;

    private long menuId;

  //  private long orderId;

//    @ManyToOne
//    @JoinColumn(name = "order_id")
//    private Order order;
//
//
//    @ManyToOne
//    @JoinColumn(name = "menu_id")
//    private Menu menu;

    @Autowired
    private MenuRepository menuRepository;
   public MenuItem(NewMenuItemRequest request){
       this.quantity = request.quantity;
       this.menuId = request.menuId;;
      //menuRepository.findById(request.menuId);
   }
}
