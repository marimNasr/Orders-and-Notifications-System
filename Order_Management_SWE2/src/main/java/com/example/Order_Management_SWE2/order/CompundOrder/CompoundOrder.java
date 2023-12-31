package com.example.Order_Management_SWE2.order.CompundOrder;

import com.example.Order_Management_SWE2.order.SimpleOrder.SimpleOrder;
import com.example.Order_Management_SWE2.order.model.Order;

import java.util.HashMap;
import java.util.List;

public class CompoundOrder extends Order {

    public List<SimpleOrder> orders;

    public CompoundOrder(String username, HashMap<String, Integer> products, float price, float fees, List<SimpleOrder> orders){
        super(username, products, price, fees);
        this.orders = orders;

    }

    public List<SimpleOrder> getOrders() {
        return orders;
    }
}
