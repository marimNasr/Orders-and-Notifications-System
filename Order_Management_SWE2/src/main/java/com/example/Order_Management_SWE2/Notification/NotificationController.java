package com.example.Order_Management_SWE2.Notification;

import com.example.Order_Management_SWE2.MessageTemplate.Canclletion.CancelMessage;
import com.example.Order_Management_SWE2.order.model.Order;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class NotificationController {
//    CancelMessage cancelMessage;

    @PostMapping("/placeOrder")
    public String placeOrder(){
        return "";
    }

    @PostMapping("/shipOrder")
    public String shipOrder(){
        return "";
    }

    @PostMapping("cancelOrder")
    public String cancelOrder(){
        return "";
    }

    @PostMapping("/cancelShipment")
    public String cancelShipment(){
        return "";
    }

}
