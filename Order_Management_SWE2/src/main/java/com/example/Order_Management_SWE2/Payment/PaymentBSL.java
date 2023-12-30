package com.example.Order_Management_SWE2.Payment;

import com.example.Order_Management_SWE2.DataBase.DatabaseController;
import com.example.Order_Management_SWE2.Customer.model.Customer;
import com.example.Order_Management_SWE2.order.model.Order;
import org.springframework.stereotype.Service;

@Service
public class PaymentBSL {
    public boolean paySimpleOrder(Order order, String username, DatabaseController DBController) {
        if(DBController.getUser(username)==null) {
            return false;
        }
        Customer customer = DBController.getUser(username);
        float balance = customer.getBalance();
        float price = order.getPrice();
        float fees = order.getFees();

        if (balance >= price + fees) {
            customer.setBalance(balance - (price + fees));
            return true;
        }

        return false;
    }


}

