package com.example.Order_Management_SWE2.MessageTemplate;

import com.example.Order_Management_SWE2.Product.model.Product;
import com.example.Order_Management_SWE2.order.model.Order;

import java.util.List;

public interface MessageTemplate {
    public String SendM(Order order);
}


