package com.ordering_be.ordering_be_spring.Models;

import java.util.List;

public class NewOrderRequest {
    public int tableNo;
    public List<NewMenuItemRequest> items;
}