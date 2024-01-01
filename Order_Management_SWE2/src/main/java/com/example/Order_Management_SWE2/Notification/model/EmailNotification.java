package com.example.Order_Management_SWE2.Notification.model;

import com.example.Order_Management_SWE2.MessageTemplate.Canclletion.ArCancel;
import com.example.Order_Management_SWE2.MessageTemplate.Canclletion.CancelMessage;
import com.example.Order_Management_SWE2.MessageTemplate.Canclletion.EnCancel;
import com.example.Order_Management_SWE2.order.model.Order;
import com.example.Order_Management_SWE2.order.model.OrderState;

public class EmailNotification extends Notification{
    @Override
    public String getMessage(Order o){
        determineType(o);
        if((msg instanceof ArCancel || msg instanceof EnCancel) && o.getState() == OrderState.placementcancelled){
            return msg.createMessages(o);
        }
        else if((msg instanceof ArCancel || msg instanceof EnCancel) && o.getState() == OrderState.shippingcancelled){
            return ((CancelMessage) msg).createShipmentMessage(o);
        }
        return msg.createMessages(o);
    }


}
