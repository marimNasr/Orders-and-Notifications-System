package com.example.Order_Management_SWE2.BSL;

import com.example.Order_Management_SWE2.DataBase.DataBase;
import com.example.Order_Management_SWE2.DataBase.DatabaseController;
import com.example.Order_Management_SWE2.model.Customer;
import com.example.Order_Management_SWE2.model.Order;
import com.example.Order_Management_SWE2.model.Product;
import com.example.Order_Management_SWE2.model.SimpleOrder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SimpleOrderBSL {
    DatabaseController DBController;
    Order SimpleOrder = new SimpleOrder();
    public SimpleOrderBSL(){
        DBController = new DatabaseController();
    }

   public String makeSimpleOrder(Order o){
        String username = o.getCustomerUsername();
        List<Product>p= o.getProducts();
        System.out.print(p);
//        float balance = customer.getBalance();
//        float total = o.getPrice() + o.getFees();
//        if(balance >= total){
//            customer.setBalance(balance - total);
//            return "";
//        }
//        else{
//
//        }
        return "";
    }
}
