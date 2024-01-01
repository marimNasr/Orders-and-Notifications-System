package com.example.Order_Management_SWE2.Notification;

import com.example.Order_Management_SWE2.order.SimpleOrder.SimpleOrder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class NotificationController {

    NotificationBSL notificationBSL= new NotificationBSL();

    @PostMapping("/sendNotification")
    public String sendNotification() {

        return notificationBSL.sendNotification();
    }

    @GetMapping("/GetNotifications")
    public String getNotifications() {

        return notificationBSL.getNotifications();
    }
}
