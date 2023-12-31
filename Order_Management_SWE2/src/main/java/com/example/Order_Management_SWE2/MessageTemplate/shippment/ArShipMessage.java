package com.example.Order_Management_SWE2.MessageTemplate.shippment;

import com.example.Order_Management_SWE2.order.model.Order;

public class ArShipMessage extends ShipmentMessage{
    @Override
    public String SendM(Order order) {
        getThings(order);
        double total_price = order.getPrice()+order.getFees();
        this.msg=" ";
        msg+="عميلنا العزيز" + order.getUsername();
        msg+=" طلبك الذى يحمل الرقم التعريفى '\n'  "+order.getId() ;
        msg+="تم شحنه وتكلفة الطلب هى "+ total_price;


        return msg;
    }
}
