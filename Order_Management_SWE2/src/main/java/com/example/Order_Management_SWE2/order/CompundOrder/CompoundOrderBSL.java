package com.example.Order_Management_SWE2.order.CompundOrder;
import java.util.*;

import com.example.Order_Management_SWE2.Customer.model.Customer;
import com.example.Order_Management_SWE2.DataBase.DataBase;
import com.example.Order_Management_SWE2.Notification.NotificationBSL;
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
    NotificationBSL notificationBSL;
    String friendsName = "";
    public CompoundOrderBSL(){
        notificationBSL = new NotificationBSL();
    }

    public String makeCompoundOrder(CompoundOrder order){
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
            notificationBSL.addNotification(order);
            order.setPlaceTime();
            for (Order simOrder : orders) {
                simOrder.setState(OrderState.placed);
                DBController.addOrder(simOrder);
                notificationBSL.addNotification(simOrder);
            }
            return "compound order placement is done";
        }
       return friendsName + "Order(s) can not be placed, faild to place compound order";
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

    public String shipCompoundOrder(int orderId){
        CompoundOrder order = (CompoundOrder) DBController.getOrder(orderId);
        if(order==null)
            return "order is not found or being canceled";
        order.setState(OrderState.shipping);
        order.setShipTime();
        notificationBSL.addNotification(order);
        orders = order.getOrders();
        for(Order Order : orders) {
            Order.setState(OrderState.shipping);
            Order.setShipTime();
            notificationBSL.addNotification(Order);
        }
        return "Order is shipping";
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
        order.setState(OrderState.placementcancelled);
        notificationBSL.addNotification(order);
        orders = order.getOrders();
        Iterator<? extends Order> iterator = order.getOrders().iterator();
        while (iterator.hasNext()) {
            Order subOrder = iterator.next();
            returnProducts(subOrder);
            price = subOrder.getPrice();
            fees = subOrder.getFees();
            name = subOrder.getUsername();
            customer = DBController.getUser(name);
            customer.setBalance(customer.getBalance() + price + fees);
            subOrder.setState(OrderState.placementcancelled);
            notificationBSL.addNotification(subOrder);
        }
        for (Order o : orders){
            DBController.removeOrder(o);
        }
        DBController.removeOrder(order);
    }

    public void cancelShipment(CompoundOrder order){
        order.setState(OrderState.placed);
        String name = order.getUsername();
        Customer customer = DBController.getUser(name);
        float fees = order.getFees();
        customer.setBalance(customer.getBalance()+ fees);
        order.setState(OrderState.shippingcancelled);
        notificationBSL.addNotification(order);
        orders = order.getOrders();

        for(Order Order : orders) {
            Order.setState(OrderState.placed);
            name = Order.getUsername();
            customer = DBController.getUser(name);
            fees = Order.getFees();
            customer.setBalance(customer.getBalance()+ fees);
            order.setState(OrderState.shippingcancelled);
            notificationBSL.addNotification(Order);
        }
    }
    public String cancel(int  orderId){
        CompoundOrder order = (CompoundOrder) DBController.getOrder(orderId);
        long currentTime = System.currentTimeMillis();
        if (order.getState()==OrderState.placed){
            cancelPlacement(order);
            return "Order Placement cancelled successfully";
        }
        else if(order.getState()==OrderState.shipping){
        long elapsedTime2 = currentTime - order.getShipTime();
            long shipCancellationTime = 60000;
            if(elapsedTime2 <= shipCancellationTime){
                cancelShipment(order);
                return "Order Shipment cancelled successfully";
            }
        }
        return "Order cannot be cancelled";
    }


}
