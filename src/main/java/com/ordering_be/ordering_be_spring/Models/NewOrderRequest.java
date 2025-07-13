package com.ordering_be.ordering_be_spring.Models;

import java.util.List;

public class NewOrderRequest {
    public int tableNo;
    private String customerName;
    private List<OrderItemRequest> items;

    // Getters and Setters
    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }
    public List<OrderItemRequest> getItems() { return items; }
    public void setItems(List<OrderItemRequest> items) { this.items = items; }
}
