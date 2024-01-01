package com.example.Order_Management_SWE2.MessageTemplate.Canclletion;

import com.example.Order_Management_SWE2.order.CompundOrder.CompoundOrder;
import com.example.Order_Management_SWE2.order.SimpleOrder.SimpleOrder;
import com.example.Order_Management_SWE2.order.model.Order;

import java.util.List;
import java.util.Map;

public class ArCancel extends CancelMessage{
    @Override
    public String createMessages(Order order) { //cancel order
        String orderID = Integer.toString(order.getId());
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
            for(Order order1 : orders){
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
    public  String createShipmentMessage(Order order){
        String orderID = Integer.toString(order.getId());
        String customerName = order.getUsername();
        String msg;
        msg = "عزيزي, " + customerName + "شحن طلبك الذي رقمه التعريفي: " + orderID + " تم الغاءه";
        return msg;
    }
}
