package com.example.Order_Management_SWE2.Notification;

import com.example.Order_Management_SWE2.Customer.model.Customer;
import com.example.Order_Management_SWE2.DataBase.DatabaseController;
import com.example.Order_Management_SWE2.Notification.model.EmailNotification;
import com.example.Order_Management_SWE2.Notification.model.Notification;
import com.example.Order_Management_SWE2.Notification.model.SMSNotification;
import com.example.Order_Management_SWE2.order.model.Order;

import java.util.*;


public class NotificationBSL {

    DatabaseController databaseController;
    static LinkedList<String> queue;
    public NotificationBSL(){
        databaseController = new DatabaseController();
        queue = new LinkedList<>();
    }

    public void addNotification(Order order){
        Notification notification;
        String message="";
        Customer customer = databaseController.getUser(order.getUsername());
        if(customer.getNotificationType().equals("SMS")){
            notification = new SMSNotification();
            message= "From :- order system \n to :- "+ customer.getPhoneNum()+ "\n" +notification.getMessage(order);

        }
        else if(customer.getNotificationType().equals("Email")){
            notification = new EmailNotification();
            message= "From :- order system \n to :- "+customer.getEmail() +"\n"+notification.getMessage(order);
        }

        queue.addLast(message);
    }

    public String sendNotification(){
     return queue.poll();
    }

    public String getNotifications(){
        String notifications="";
        for( String s :queue){
            notifications+=s+"\n\n";
        }
        return notifications;
    }
}
