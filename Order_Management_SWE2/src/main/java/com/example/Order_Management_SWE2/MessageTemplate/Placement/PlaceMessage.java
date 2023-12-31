package com.example.Order_Management_SWE2.MessageTemplate.Placement;

import com.example.Order_Management_SWE2.Customer.CustomerController;
import com.example.Order_Management_SWE2.Customer.model.Customer;
import com.example.Order_Management_SWE2.MessageTemplate.MessageTemplate;
import com.example.Order_Management_SWE2.order.model.Order;

import java.security.PrivateKey;
import java.util.HashMap;

public abstract class PlaceMessage extends MessageTemplate {
    public abstract String createMessages(Order order);
}
