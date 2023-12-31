package com.example.Order_Management_SWE2.MessageTemplate.Canclletion;

import com.example.Order_Management_SWE2.Customer.model.Customer;
import com.example.Order_Management_SWE2.order.CompundOrder.CompoundOrder;
import com.example.Order_Management_SWE2.order.SimpleOrder.SimpleOrder;
import com.example.Order_Management_SWE2.order.model.Order;

import java.util.List;
import java.util.Map;

public class ArCancel extends CancelMessage{
    @Override
    public String SendM(Order order) { //cancel order
        String orderID = Integer.toString(order.getID());
        String customerName = order.getUsername();
        String products = "";
        Map<String, Integer> items = order.getProducts();

        for(Map.Entry<String, Integer> item : items.entrySet()){
            products = products + item.getKey() + " الذي طلبته "
                    + Integer.toString(item.getValue()) + " مرات\n";
        }

        if(order instanceof CompoundOrder) {
            List<SimpleOrder> orders = ((CompoundOrder) order).getOrders();
            String otherCustomerName;
            for(SimpleOrder order1 : orders){
                otherCustomerName = order1.getUsername();
                products = products + " و طلب " + otherCustomerName + " مكوناته:\n";

                for(Map.Entry<String, Integer> item : items.entrySet()){
                    products = products + item.getKey() + " الذي طلبته "
                            + Integer.toString(item.getValue()) + " مرات\n";
                }
            }
        }

        String msg;
        msg = "عزيزي, " + customerName + "طلبك الذي رقمه التعريفي: " + orderID + " ومكوناته:\n"
                + products + " تم الغاءه";
        return msg;
    }
    public  String SendMShipment(Order order){
        String orderID = Integer.toString(order.getID());
        String customerName = order.getUsername();
        String msg;
        msg = "عزيزي, " + customerName + "شحن طلبك الذي رقمه التعريفي: " + orderID + " تم الغاءه";
        return msg;
    }
}