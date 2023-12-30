package com.example.Order_Management_SWE2.order.CompundOrder;

import com.example.Order_Management_SWE2.order.SimpleOrder.SimpleOrder;
import com.example.Order_Management_SWE2.order.model.Order;

import java.util.HashMap;
import java.util.List;

public class CompoundOrder extends Order {
    public List<SimpleOrder> orders;

    public CompoundOrder(List<SimpleOrder> orders){
            this.orders = orders;

    }

}
