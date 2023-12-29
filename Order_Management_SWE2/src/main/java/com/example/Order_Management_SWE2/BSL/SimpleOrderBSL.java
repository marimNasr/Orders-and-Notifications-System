package com.example.Order_Management_SWE2.BSL;

import ch.qos.logback.core.joran.sanity.Pair;
import com.example.Order_Management_SWE2.DataBase.DataBase;
import com.example.Order_Management_SWE2.DataBase.DatabaseController;
import com.example.Order_Management_SWE2.model.Customer;
import com.example.Order_Management_SWE2.model.Order;
import com.example.Order_Management_SWE2.model.Product;
import com.example.Order_Management_SWE2.model.SimpleOrder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SimpleOrderBSL {
    DatabaseController DBController= new DatabaseController();
    ProductBSL productBSL = new ProductBSL();
    PaymentBSL paymentBSL = new PaymentBSL();
    Order SimpleOrder = new SimpleOrder();
    Customer customer = new Customer();
    HashMap<String, Integer> products = new HashMap<>();
    public SimpleOrderBSL(){

    }

   public String makeSimpleOrder(SimpleOrder order){
        ArrayList<Order> arrayOfOrder = new ArrayList<Order>();
        arrayOfOrder.add(order);
        products = (HashMap<String, Integer>) order.getProducts();
        for(HashMap.Entry<String, Integer> entry : products.entrySet()) {
            boolean productEnough = productBSL.ifProductEnough((HashMap<String, Integer>) entry);
            boolean pay = paymentBSL.pay(arrayOfOrder, order.getCustomerUsername(), DBController);
            if(productEnough && pay){
                return "Order Done";
            }
            return "Fail";
        }
        return "";
    }
}
