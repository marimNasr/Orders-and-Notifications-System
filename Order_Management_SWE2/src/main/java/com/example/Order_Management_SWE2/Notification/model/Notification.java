package com.example.Order_Management_SWE2.Notification.model;

import com.example.Order_Management_SWE2.Customer.model.Customer;
import com.example.Order_Management_SWE2.DataBase.DatabaseController;
import com.example.Order_Management_SWE2.MessageTemplate.Canclletion.ArCancel;
import com.example.Order_Management_SWE2.MessageTemplate.Canclletion.EnCancel;
import com.example.Order_Management_SWE2.MessageTemplate.MessageTemplate;
import com.example.Order_Management_SWE2.MessageTemplate.Placement.ArPlaceMessage;
import com.example.Order_Management_SWE2.MessageTemplate.Placement.EnPlaceMessage;
import com.example.Order_Management_SWE2.MessageTemplate.shippment.ArShipMessage;
import com.example.Order_Management_SWE2.MessageTemplate.shippment.EnShipMessage;
import com.example.Order_Management_SWE2.order.model.Order;
import com.example.Order_Management_SWE2.order.model.OrderState;

public abstract class Notification {
    public MessageTemplate msg;
    DatabaseController databaseController = new DatabaseController();
    public void determineType(Order order){
        Customer customer = databaseController.getUser(order.getUsername());
        if(order.getState()== OrderState.placed && customer.getLanguage().equals("En")){
            msg= new EnPlaceMessage();
        }else if (order.getState()==OrderState.placed && customer.getLanguage().equals("Ar")){
            msg = new ArPlaceMessage();
        }else if(order.getState()== OrderState.shipping&& customer.getLanguage().equals("En")){
            msg = new EnShipMessage();
        }else if (order.getState()== OrderState.shipping && customer.getLanguage().equals("Ar")){
            msg = new ArShipMessage();
        }
        else {
            if(customer.getLanguage().equals("Ar")){
                msg = new ArCancel();
            }else if(customer.getLanguage().equals("En")){
                msg = new EnCancel();
            }
        }

    }
    public abstract String getMessage(Order o);



}
