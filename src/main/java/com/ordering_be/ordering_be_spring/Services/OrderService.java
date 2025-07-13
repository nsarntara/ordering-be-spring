package com.ordering_be.ordering_be_spring.Services;

import com.ordering_be.ordering_be_spring.Models.NewMenuItemRequest;
import com.ordering_be.ordering_be_spring.Models.NewOrderRequest;
import com.ordering_be.ordering_be_spring.Repository.MenuRepository;
import com.ordering_be.ordering_be_spring.Repository.OrderRepository;
import com.ordering_be.ordering_be_spring.entities.Menu;
import com.ordering_be.ordering_be_spring.entities.MenuItem;
import com.ordering_be.ordering_be_spring.entities.Order;
import com.ordering_be.ordering_be_spring.entities.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private OrderRepository orderRepository;


    public Order createOrder(NewOrderRequest request) {
        Order o =   new Order();
        o.tableNo = request.tableNo;
        o.menus = request.items.stream().map(i -> new MenuItem(i)).collect(Collectors.toList());
        Order menu = orderRepository.saveAndFlush(o);

    return null;   }
}