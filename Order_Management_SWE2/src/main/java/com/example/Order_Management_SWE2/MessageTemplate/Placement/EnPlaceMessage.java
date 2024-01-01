package com.example.Order_Management_SWE2.MessageTemplate.Placement;

import com.example.Order_Management_SWE2.order.CompundOrder.CompoundOrder;
import com.example.Order_Management_SWE2.order.model.Order;

import java.util.*;

public class EnPlaceMessage extends PlaceMessage {
    @Override
    public String createMessages(Order order) {
        msg ="";
        msg = msg + "Dear ' " + order.getUsername() + " '\nYour booking of the Item (s) : {\n";
        String products = "";
        Map<String, Integer> items = order.getProducts();

        for (Map.Entry<String, Integer> item : items.entrySet()) {
            products = products + item.getKey() + " Product which you purchased " + Integer.toString(item.getValue()) + " Pieces of it \n";
        }
        msg = msg + products + "}  Have been confirmed";
        return msg;
    }



}
