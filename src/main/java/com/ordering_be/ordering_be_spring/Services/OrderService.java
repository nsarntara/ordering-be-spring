package com.ordering_be.ordering_be_spring.Services;

import com.ordering_be.ordering_be_spring.Models.NewOrderRequest;
import com.ordering_be.ordering_be_spring.Models.OrderItemRequest;
import com.ordering_be.ordering_be_spring.Repository.MenuRepository;
import com.ordering_be.ordering_be_spring.Repository.OrderRepository;
import com.ordering_be.ordering_be_spring.entities.MenuItem;
import com.ordering_be.ordering_be_spring.entities.Order;
import com.ordering_be.ordering_be_spring.entities.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;


import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final MenuRepository menuItemRepository;

    public OrderService(OrderRepository orderRepository, MenuRepository menuItemRepository) {
        this.orderRepository = orderRepository;
        this.menuItemRepository = menuItemRepository;
    }

    /**
     * Creates a new order based on the request.
     * This method is transactional, meaning all database operations within it
     * will either succeed together or fail together.
     * @param request The DTO containing order details.
     * @return The newly created Order entity.
     */
    @Transactional
    public Order createOrder(NewOrderRequest request) {
        Order order = new Order();
        order.setCustomerName(request.getCustomerName());
        order.setOrderDate(LocalDateTime.now());

        BigDecimal totalPrice = BigDecimal.ZERO;

        // Process each item in the request
        for (var itemRequest : request.getItems()) {
            // Find the menu item in the database
            MenuItem menuItem = menuItemRepository.findById(itemRequest.getMenuItemId())
                    .orElseThrow(() -> new EntityNotFoundException("MenuItem not found with id: " + itemRequest.getMenuItemId()));

            // Create a new OrderItem
            OrderItem orderItem = new OrderItem();
            orderItem.setMenuItem(menuItem);
            orderItem.setQuantity(itemRequest.getQuantity());

            // Add the item to the order
            order.addOrderItem(orderItem);

            // Calculate the price for this line item and add it to the total
            BigDecimal itemPrice = menuItem.getPrice().multiply(BigDecimal.valueOf(itemRequest.getQuantity()));
            totalPrice = totalPrice.add(itemPrice);
        }

        order.setTotalPrice(totalPrice);

        // Save the order. Thanks to CascadeType.ALL, the associated orderItems will also be saved.
        return orderRepository.save(order);
    }

    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
