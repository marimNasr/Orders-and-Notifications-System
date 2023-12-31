package com.example.Order_Management_SWE2.order.CompundOrder;
import java.util.*;

import com.example.Order_Management_SWE2.Customer.model.Customer;
import com.example.Order_Management_SWE2.Product.model.Product;
import com.example.Order_Management_SWE2.DataBase.DatabaseController;
import com.example.Order_Management_SWE2.Payment.PaymentBSL;
import com.example.Order_Management_SWE2.Product.ProductBSL;
import com.example.Order_Management_SWE2.order.SimpleOrder.SimpleOrder;
import com.example.Order_Management_SWE2.order.model.Order;
import com.example.Order_Management_SWE2.order.model.OrderState;

public class CompoundOrderBSL {
    DatabaseController DBController= new DatabaseController();
    ProductBSL productBSL = new ProductBSL();
    PaymentBSL paymentBSL = new PaymentBSL();
    Map<String, Integer> products = new HashMap<>();
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
            order.setPlaceTime();
            Timer timer = new Timer(true);
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    order.setState(OrderState.shipping);
                    order.setShipTime();
                    System.out.println("Order" + " has been shipped.");
                    timer.cancel();
                }
            }, 120000);
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
        products = order.getProducts();
        for(Map.Entry<String, Integer> entry : products.entrySet()) {
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

    public void returnProducts(Order order){
        products = order.getProducts();
        for(Map.Entry<String, Integer> entry : products.entrySet()) {
            Product product = productBSL.getProduct(entry.getKey());
            productBSL.increaseQuantity(product,entry.getValue());
            product.getSubCategory().setCounter(product.getSubCategory().getCounter() + entry.getValue());
        }

    }
    public void cancelPlacement(CompoundOrder order){
        returnProducts(order);
        float price = order.getPrice();
        float fees = order.getFees();
        String name = order.getUsername();
        Customer customer = DBController.getUser(name);
        customer.setBalance(customer.getBalance() + price + fees);
        orders = order.getOrders();
        for(Order Order : orders) {
            returnProducts(Order);
            price = Order.getPrice();
            fees = Order.getFees();
            name = Order.getUsername();
            customer = DBController.getUser(name);
            customer.setBalance(customer.getBalance() + price + fees);
            orders.remove(Order);
            System.out.println(name+ " has been returned");

        }
        orders.remove(order);

    }

    public void cancelShipment(CompoundOrder order){
        order.setState(OrderState.placed);
        String name = order.getUsername();
        Customer customer = DBController.getUser(name);
        float fees = order.getFees();
        customer.setBalance(customer.getBalance()+ fees);
        orders = order.getOrders();
        for(Order Order : orders) {
            Order.setState(OrderState.placed);
            name = Order.getUsername();
            customer = DBController.getUser(name);
            fees = Order.getFees();
            customer.setBalance(customer.getBalance()+ fees);
            System.out.println(name+ " has been returned");
        }
    }
    public String cancel(int  orderId){
        CompoundOrder order = (CompoundOrder) DBController.getOrder(orderId);
        long currentTime = System.currentTimeMillis();
        long elapsedTime = currentTime - order.getPlaceTime();
        long placeCancellationTime = 120000; // 2 minute in milliseconds


        if (elapsedTime <= placeCancellationTime) {
            cancelPlacement(order);
            return "Order Placement cancelled successfully";
        }
        if(order.getState()==OrderState.shipping){
            long elapsedTime2 = currentTime - order.getShipTime();
            long shipCancellationTime = 60000; // 2 minute in milliseconds
            if(elapsedTime2 <= shipCancellationTime){
                cancelShipment(order);
                return "Order Shipment cancelled successfully";
            }
        }
        return "Order cannot be cancelled";
    }

}
