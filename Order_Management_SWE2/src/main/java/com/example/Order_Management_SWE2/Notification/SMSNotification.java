package com.example.Order_Management_SWE2.Notification;

import com.example.Order_Management_SWE2.order.model.Order;

public class SMSNotification extends Notification {
   @Override
    public String getMessage(Order o){
       determineType(o);
       return msg.createMessages(o);
    }

}
