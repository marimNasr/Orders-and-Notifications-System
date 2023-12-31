package com.example.Order_Management_SWE2.MessageTemplate.Canclletion;

import com.example.Order_Management_SWE2.MessageTemplate.MessageTemplate;
import com.example.Order_Management_SWE2.order.model.Order;

public abstract class CancelMessage extends MessageTemplate {
    public abstract String createMessages(Order order);
    public abstract String SendMShipment(Order order);
}
