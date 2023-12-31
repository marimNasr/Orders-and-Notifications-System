package com.example.Order_Management_SWE2.order.CompundOrder;
import java.util.Timer;
import java.util.TimerTask;
import com.example.Order_Management_SWE2.DataBase.DatabaseController;
import com.example.Order_Management_SWE2.Payment.PaymentBSL;
import com.example.Order_Management_SWE2.Product.ProductBSL;
import com.example.Order_Management_SWE2.order.SimpleOrder.SimpleOrder;
import com.example.Order_Management_SWE2.order.model.Order;
import com.example.Order_Management_SWE2.order.model.OrderState;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CompoundOrderBSL {
    DatabaseController DBController= new DatabaseController();
    ProductBSL productBSL = new ProductBSL();
    PaymentBSL paymentBSL = new PaymentBSL();
    HashMap<String, Integer> products = new HashMap<>();
    List<SimpleOrder> orders = new ArrayList<>();
    String friendsName = "";

    public String makeCompoundOrder(CompoundOrder order){//products,orders
       boolean myOrder = orderValidation(order);
        orders = order.getOrders();
        for(Order Order : orders) {
            if(!orderValidation(Order)){
                friendsName = friendsName + Order.getUsername() + "\n";
            }
        }
        if(myOrder && friendsName == ""){
            order.setState(OrderState.placed);
            DBController.addOrder(order);
//            order.setPlaceTime();
            Timer timer = new Timer(true);
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    // This code will be executed after 2 seconds
                    order.setState(OrderState.shipping);
                    order.setShipTime();
                    System.out.println("Order" + " has been shipped.");
                    // Additional logic can be added here if needed
                    timer.cancel(); // Cancel the timer after executing the task
                }
            }, 60000);
            for (SimpleOrder simOrder : orders) {
                simOrder.setState(OrderState.placed);
                DBController.addOrder(simOrder);
            }
            return "Order is done";
        }
       return friendsName + "Order(s) is not done";
    }
    public boolean orderValidation(Order order){
        boolean x = false;
        products = (HashMap<String, Integer>) order.getProducts();
        for(HashMap.Entry<String, Integer> entry : products.entrySet()) {
            boolean productEnough = productBSL.ifProductEnough(entry.getKey(), entry.getValue());
            boolean pay = paymentBSL.paySimpleOrder(order, order.getUsername(), DBController);
            if(productEnough && pay){
                x = true;
            }else{
                x = false;
                break;
            }
        }
        return x;
    }
//    public void cancelPlacement(Order order){
//
//    }
//
//
//    public String cancel(SimpleOrder order){
//        long currentTime = System.currentTimeMillis();
//        long elapsedTime = currentTime - order.getPlaceTime();
//        long placeCancellationTime = 120000; // 2 minute in milliseconds
//        if (elapsedTime <= placeCancellationTime) {
//            cancelPlacement(order);
//            return "Order Placement cancelled successfully";
//        }
//        if(order.getState().equals(OrderState.shipping)){
//            long elapsedTime2 = currentTime - order.getShipTime();
//            long shipCancellationTime = 60000; // 2 minute in milliseconds
//            if(elapsedTime2 <= shipCancellationTime){
//                cancelShipment(order);
//                return "Order Shipment cancelled successfully";
//            }
//        }
//        return "Order cannot be cancelled";
//    }

}
