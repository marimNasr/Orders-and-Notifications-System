package com.example.Order_Management_SWE2.Notification;

import com.example.Order_Management_SWE2.Customer.model.Customer;
import com.example.Order_Management_SWE2.DataBase.DatabaseController;
import com.example.Order_Management_SWE2.MessageTemplate.Canclletion.CancelMessage;
import com.example.Order_Management_SWE2.order.model.Order;
import com.example.Order_Management_SWE2.order.model.OrderState;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.sql.Struct;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class NotificationController {

    DatabaseController databaseController;
    Queue<String> queue;
    private final ScheduledExecutorService scheduler;
    public NotificationController(){
        databaseController = new DatabaseController();
        queue = new LinkedList<>();
        scheduler = Executors.newScheduledThreadPool(1);

        // Schedule the task to poll messages from the queue every 5 seconds (adjust as needed)
        scheduler.scheduleAtFixedRate(this::processQueue, 0, 5, TimeUnit.SECONDS);
    }
    public String sendNotification(Order order){
        Notification notification;
        String message="";
        Customer customer = databaseController.getUser(order.getUsername());
        if(customer.getNotificationType().equals("SMS")){
            notification = new SMSNotification();
            message= "From :- order system \n to :- "+ customer.getPhoneNum()+ "\n" +notification.getMessage(order);
            queue.add(message);
            System.out.println(message);
            Timer timer = new Timer(true);
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    String msg= "From :- order system \n to :- "+ customer.getPhoneNum()+ "\n" +notification.getMessage(order);
                    queue.add(msg);
                    timer.cancel();
                    System.out.println(msg);
                }
            }, 3000);


            return queue.poll();
        }
        else if(customer.getNotificationType().equals("Email")){
            notification = new EmailNotification();
            return "From :- order system \n to :- "+customer.getEmail() +"\n"+notification.getMessage(order);
        }
        return "Error";
    }

    @Scheduled(fixedRate = 5000) // Adjust the rate as needed (milliseconds)
    public void processQueue() {
        if (!queue.isEmpty()) {
            // Process the next message in the queue
            String nextMessage = queue.poll();
            // Perform any additional processing or logging as needed
//            System.out.println("Processing message: " + nextMessage);
        }
    }

}
