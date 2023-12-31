package com.example.Order_Management_SWE2.order.SimpleOrder;
import java.util.*;

import com.example.Order_Management_SWE2.Customer.model.Customer;
import com.example.Order_Management_SWE2.DataBase.DataBase;
import com.example.Order_Management_SWE2.DataBase.DatabaseController;
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
    HashMap<String, Integer> products = new HashMap<>();
    DataBase dataBase = new DataBase();

    Map<Product,Integer> productsMap = dataBase.getProductsMap();
    List<Order> orders = dataBase.getOrders();

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
            Timer timer = new Timer(true);
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    order.setState(OrderState.shipping);
                    order.setShipTime();
                    System.out.println("Order"+ " has been shipped.");
                    timer.cancel();
                }
            }, 120000);
//            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            String formattedOrderTime = dateFormat.format(new Date(order.getTime()));
//            // Print the formatted order time
//            System.out.println("Order placed at: " + formattedOrderTime);
            return "Order is done";
        }
        return "Failed to make order";
   }

   public void cancelPlacement(SimpleOrder order){
       products = (HashMap<String, Integer>) order.getProducts();
       for(HashMap.Entry<String, Integer> entry : products.entrySet()) {
            Product product = productBSL.getProduct(entry.getKey());
            product.getSubCategory().setCounter(product.getSubCategory().getCounter() + entry.getValue());
            productsMap.put(product,productsMap.get(product) + entry.getValue());
       }

       float price = order.getPrice();
       float fees = order.getFees();
       String name = order.getUsername();
       Customer customer = DBController.getUser(name);
       customer.setBalance(customer.getBalance() + price + fees);
       orders.remove(order);
       System.out.println(productsMap);
   }

   public void cancelShipment(SimpleOrder order){
       order.setState(OrderState.placed);
       String name = order.getUsername();
       Customer customer = DBController.getUser(name);
       float fees = order.getFees();
       customer.setBalance(customer.getBalance()+ fees);
   }

   public String cancel(SimpleOrder order){
       long currentTime = System.currentTimeMillis();
       long elapsedTime = currentTime - order.getPlaceTime();
       long placeCancellationTime = 120000; // 2 minute in milliseconds
       if (elapsedTime <= placeCancellationTime) {
           cancelPlacement(order);
           return "Order Placement cancelled successfully";
       }
       if(order.getState().equals(OrderState.shipping)){
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