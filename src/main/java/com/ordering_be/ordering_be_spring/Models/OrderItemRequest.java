package com.ordering_be.ordering_be_spring.Models;

import java.util.List;

public class OrderItemRequest {
    private Long menuItemId;
    private int quantity;


    // Getters and Setters
    public Long getMenuItemId() { return menuItemId; }
    public void setMenuItemId(Long menuItemId) { this.menuItemId = menuItemId; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}