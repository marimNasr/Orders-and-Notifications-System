package com.example.Order_Management_SWE2.MessageTemplate.shippment;

import com.example.Order_Management_SWE2.order.model.Order;

public class EnShipMessage extends ShipmentMessage{
    @Override
    public String createMessages(Order order) {
        double total_price = order.getPrice()+order.getFees();
        getThings(order);
        this.msg ="";
        msg+="Dear"+order.getUsername();
        msg+="Your order with ID :"+order.getId() +" is shipping'\n'";
        msg+="and the total cost for the order is" +total_price;
        return msg;
    }
}
