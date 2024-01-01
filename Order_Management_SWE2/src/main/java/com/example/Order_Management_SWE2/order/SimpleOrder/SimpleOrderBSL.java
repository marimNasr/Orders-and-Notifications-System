package com.example.Order_Management_SWE2.order.SimpleOrder;
import java.util.*;
import com.example.Order_Management_SWE2.Customer.model.Customer;
import com.example.Order_Management_SWE2.DataBase.DataBase;
import com.example.Order_Management_SWE2.DataBase.DatabaseController;
import com.example.Order_Management_SWE2.Notification.NotificationBSL;
import com.example.Order_Management_SWE2.Payment.PaymentBSL;
import com.example.Order_Management_SWE2.Product.ProductBSL;
import com.example.Order_Management_SWE2.order.model.Order;
import com.example.Order_Management_SWE2.order.model.OrderState;
import org.springframework.stereotype.Service;
import com.example.Order_Management_SWE2.Product.model.Product;


@Service
public class SimpleOrderBSL {
    DatabaseController DBController= new DatabaseController();
    ProductBSL productBSL = new ProductBSL();
    PaymentBSL paymentBSL = new PaymentBSL();
    Map<String, Integer> products = new HashMap<String, Integer>();
    DataBase dataBase = new DataBase();
    NotificationBSL notificationBSL;
    Map<Product,Integer> productsMap;
    List<Order> orders = dataBase.getOrders();

    public SimpleOrderBSL(){
        productsMap= dataBase.getProductsMap();
        notificationBSL = new NotificationBSL();
    }
   public String makeSimpleOrder(SimpleOrder order){
       boolean x = false;
        products = (HashMap<String, Integer>) order.getProducts();
        for(HashMap.Entry<String, Integer> entry : products.entrySet()) {
            boolean productEnough = productBSL.ifProductEnough(entry.getKey(),entry.getValue());
            boolean pay = paymentBSL.paySimpleOrder(order, order.getUsername(), DBController);
            if(productEnough && pay){
                x = true;
            }
            else {
                x = false;
                break;
            }
        }
        if(x){
            order.setState(OrderState.placed);
            DBController.addOrder(order);
            order.setPlaceTime();
            notificationBSL.addNotification(order);

            return "Order placed successfully";
        }
        return "Failed to make order";
   }

   public String shipSimpleOrder(int orderId){
       SimpleOrder order = (SimpleOrder) DBController.getOrder(orderId);
       if(order==null){
           return "order is not found or being canceled";
       }
       order.setState(OrderState.shipping);
       order.setShipTime();
       notificationBSL.addNotification(order);
       return "Order is shipping";
   }


   public void cancelPlacement(SimpleOrder order){
       products =  order.getProducts();
       for(HashMap.Entry<String, Integer> entry : products.entrySet()) {
            Product product = productBSL.getProduct(entry.getKey());
            product.getSubCategory().setCounter(product.getSubCategory().getCounter() + entry.getValue());
            productBSL.increaseQuantity(product,entry.getValue());
       }
       float price = order.getPrice();
       float fees = order.getFees();
       String name = order.getUsername();
       Customer customer = DBController.getUser(name);
       customer.setBalance(customer.getBalance() + price + fees);
       orders.remove(order);
   }

   public void cancelShipment(SimpleOrder order){
       order.setState(OrderState.placed);
       String name = order.getUsername();
       Customer customer = DBController.getUser(name);
       float fees = order.getFees();
       customer.setBalance(customer.getBalance()+ fees);
   }

   public String cancel(int  orderId){
       SimpleOrder order = (SimpleOrder) DBController.getOrder(orderId);
       long currentTime = System.currentTimeMillis();

       if (order.getState()==OrderState.placed){
           order.setState(OrderState.placementcancelled);
           notificationBSL.addNotification(order);
           cancelPlacement(order);
           return "Order Placement cancelled successfully";
       }else if(order.getState()==OrderState.shipping){
           long elapsedTime2 = currentTime - order.getShipTime();
           long shipCancellationTime = 60000;
           if(elapsedTime2 <= shipCancellationTime){
               order.setState(OrderState.shippingcancelled);
               notificationBSL.addNotification(order);
               cancelShipment(order);
               return "Order Shipment cancelled successfully";
           }
       }
       return "Order cannot be cancelled";
   }

}
