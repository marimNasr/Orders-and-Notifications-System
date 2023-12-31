package com.example.Order_Management_SWE2.MessageTemplate;

import com.example.Order_Management_SWE2.Notification.Notification;
import com.example.Order_Management_SWE2.order.model.Order;

public abstract class MessageTemplate {
    public String msg="";
    public Notification notification;
    public abstract String createMessages(Order order);
}


