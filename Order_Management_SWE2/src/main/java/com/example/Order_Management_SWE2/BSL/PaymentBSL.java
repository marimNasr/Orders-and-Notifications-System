package com.example.Order_Management_SWE2.BSL;

import com.example.Order_Management_SWE2.DataBase.DatabaseController;
import com.example.Order_Management_SWE2.model.Customer;
import com.example.Order_Management_SWE2.model.Order;
import com.example.Order_Management_SWE2.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentBSL {
//    public String pay(Order[] orders, String username, DatabaseController DBController){
//        for(Order order : orders){
//            Customer customer = DBController.getUser(username);
//            float balance = customer.getBalance();
//            float price = order.getPrice();
//            float fees = order.getFees();
//            List<Product> products=order.getProducts();
//            for(Product p:products){
//
//
//            }
//            if(balance >= price+fees) {
//                customer.setBalance(balance - (price + fees));
//                return "Payment Done";
//            }
//        }




//        if(orders.length == 1){
//            else
//                return "Balance is not enough";
//        }
//        else {
//            Customer customer;
//            float dividedFees = fees/orders.length;
//            for (Order order : orders) {
//
//                customer = order.getCustomer();
//                float balance = customer.getBalance();
//                float price = order.getPrice();
//                float total = price + dividedFees;
//
//                if (balance >= total) {
//                    customer.setBalance(balance - total);
//                    return "Payment Done";
//                }
//                else
//                    return "Balance is not enough";
//            }
//        }
//        return null;
//    }
}
