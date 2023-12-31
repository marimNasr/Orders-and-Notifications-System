package com.example.Order_Management_SWE2.order.SimpleOrder;

import com.example.Order_Management_SWE2.order.model.Order;

import java.util.HashMap;

public class SimpleOrder extends Order {
    public SimpleOrder() {}

    public SimpleOrder(int id,String username, HashMap<String, Integer> products, float price, float fees) {
        super(id,username, products, price, fees);
    }

}
