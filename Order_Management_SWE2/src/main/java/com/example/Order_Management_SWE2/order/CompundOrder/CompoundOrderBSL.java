package com.example.Order_Management_SWE2.order.CompundOrder;
import java.util.Timer;
import java.util.TimerTask;
import com.example.Order_Management_SWE2.DataBase.DatabaseController;
import com.example.Order_Management_SWE2.Payment.PaymentBSL;
import com.example.Order_Management_SWE2.Product.ProductBSL;
import com.example.Order_Management_SWE2.order.SimpleOrder.SimpleOrder;
import com.example.Order_Management_SWE2.order.model.Order;

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

//    public String makeCompoundOrder(CompoundOrder order){//products,orders
//       boolean myOrder = orderValidation(order);
//        orders = order.getOrders();
//        for(Order Order : orders) {
//            if(!orderValidation(Order)){
//                friendsName = friendsName + Order.getUsername() + "\n";
//            }
//        }
//        if(myOrder && friendsName == ""){
//            order.setState("Placed");
//            DBController.addOrder(order);
//            order.setPlaceTime();
//            Timer timer = new Timer(true);
//            timer.schedule(new TimerTask() {
//                @Override
//                public void run() {
//                    // This code will be executed after 2 seconds
//                    order.setState("Shipped");
//                    System.out.println("Order" + " has been shipped.");
//                    // Additional logic can be added here if needed
//                    timer.cancel(); // Cancel the timer after executing the task
//                }
//            }, 60000);
//            for (SimpleOrder simOrder : orders) {
//                simOrder.setState("Placed");
//                DBController.addOrder(simOrder);
//            }
//            return "Order is done";
//        }
//       return friendsName + "Order(s) is not done";
//    }
//    public boolean orderValidation(Order order){
//        boolean x = false;
//        products = (HashMap<String, Integer>) order.getProducts();
//        for(HashMap.Entry<String, Integer> entry : products.entrySet()) {
//            boolean productEnough = productBSL.ifProductEnough(entry.getKey(), entry.getValue());
//            boolean pay = paymentBSL.paySimpleOrder(order, order.getUsername(), DBController);
//            if(productEnough && pay){
//                x = true;
//            }else{
//                x = false;
//                break;
//            }
//        }
//        return x;
//    }
}
