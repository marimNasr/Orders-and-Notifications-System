package com.example.Order_Management_SWE2.BSL;

import com.example.Order_Management_SWE2.DataBase.DatabaseController;
import com.example.Order_Management_SWE2.model.Customer;
import com.example.Order_Management_SWE2.model.Order;
import com.example.Order_Management_SWE2.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class PaymentBSL {
    public boolean pay(ArrayList<Order> orders, String username, DatabaseController DBController) {
        for (Order order : orders) {
            Customer customer = DBController.getUser(username);
            float balance = customer.getBalance();
            float price = order.getPrice();
            float fees = order.getFees();

            if (balance >= price + fees) {
                customer.setBalance(balance - (price + fees));
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}
