package com.example.Order_Management_SWE2.order.SimpleOrder;

import com.example.Order_Management_SWE2.order.model.Order;

import java.util.HashMap;

public class SimpleOrder extends Order {
    public SimpleOrder() {}

    public SimpleOrder(String username, HashMap<String, Integer> products, float price, String state, float fees) {
        super(username, products, price, state, fees);
    }

}
