package com.example.Order_Management_SWE2.MessageTemplate.Canclletion;

import com.example.Order_Management_SWE2.order.CompundOrder.CompoundOrder;
import com.example.Order_Management_SWE2.order.SimpleOrder.SimpleOrder;
import com.example.Order_Management_SWE2.order.model.Order;

import java.util.List;
import java.util.Map;

public class EnCancel extends CancelMessage{
    @Override
    public String createMessages(Order order){ //cancel order
        String orderID = Integer.toString(order.getId());
        String customerName = order.getUsername();
        String products = "";
        Map<String, Integer> items = order.getProducts();

        for(Map.Entry<String, Integer> item : items.entrySet()){
            products = products + item.getKey() + " product, of which you purchased "
                    + Integer.toString(item.getValue()) + " Pieces \n";
        }

        if(order instanceof CompoundOrder) {
            List<SimpleOrder> orders = ((CompoundOrder) order).getOrders();
            String otherCustomerName;
            for(SimpleOrder order1 : orders){
                otherCustomerName = order1.getUsername();
                products = products + " and " + otherCustomerName + "'s order and its products:\n";

                for(Map.Entry<String, Integer> item : items.entrySet()){
                    products = products + item.getKey() + " product, of which you purchased "
                            + Integer.toString(item.getValue()) + " Pieces \n";
                }
            }
        }
        msg = "Dear " + customerName + ", your order with ID: " + orderID + " and its products:\n"
                + products + " is canceled";
        return msg;
    }

    public String SendMShipment(Order order){
        String orderID = Integer.toString(order.getId());
        String customerName = order.getUsername();

        msg = "Dear " + customerName + ", your order shipment with ID: " + orderID + " is canceled";
        return msg;
    }
}
