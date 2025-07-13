package com.ordering_be.ordering_be_spring.Controllers;

import com.ordering_be.ordering_be_spring.Models.NewOrderRequest;
import com.ordering_be.ordering_be_spring.Services.OrderService;
import com.ordering_be.ordering_be_spring.entities.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    // ดึงรายการออเดอร์ทั้งหมด
//    @GetMapping
//    public List<Order> getAllOrders() {
//        return orderService.getAllOrders();
//    }

//    // ดึงออเดอร์ตาม id
//    @GetMapping("/{id}")
//    public Order getOrderById(@PathVariable long id) {
//        return orderService.getOrderById(id)
//                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Order not found"));
//    }

    // สร้างออเดอร์ใหม่
    @PostMapping
    public Order createOrder(@RequestBody NewOrderRequest newOrderRequest) {
        return orderService.createOrder(newOrderRequest);
    }
}