package com.example.Order_Management_SWE2.MessageTemplate.Placement;

import com.example.Order_Management_SWE2.Product.model.Product;
import com.example.Order_Management_SWE2.order.CompundOrder.CompoundOrder;
import com.example.Order_Management_SWE2.order.model.Order;

import java.security.Key;
import java.util.*;

public class EnPlaceMessage extends PlaceMessage {



//    public String SendM(Order order) {
//        String Temp = "";
//        msg = "";
//        msg = msg + "Dear ' " + order.getUsername() + " '\nYour booking of the Item (s) : {\n";
//        String products = "";
//        Map<String, Integer> items = order.getProducts();
//
//        for(Map.Entry<String, Integer> item : items.entrySet()){
//            products = products + item.getKey() + " Product which you purchased "+ Integer.toString(item.getValue()) + " Pieces of it \n";
//        }
//        msg = msg + products + "}  Have been confirmed";
//        if(order instanceof CompoundOrder){
//            for(Order o : ((CompoundOrder) order).getOrders()){
//                SendM(o);
//            }
//        }
//        return msg;
//
//    }

    public String SendM(Order order) {
        String Temp = "";
        msg = "";
        msg = msg + "Dear ' " + order.getUsername() + " '\nYour booking of the Item (s) : {\n";
        String products = "";
        Map<String, Integer> items = order.getProducts();

        for (Map.Entry<String, Integer> item : items.entrySet()) {
            products = products + item.getKey() + " Product which you purchased " + Integer.toString(item.getValue()) + " Pieces of it \n";
        }
        msg = msg + products + "}  Have been confirmed";

        if (order instanceof CompoundOrder) {
            for (Order o : ((CompoundOrder) order).getOrders()) {
                msg += "\n" + SendM(o);
            }
        }

        return msg;
    }
}
