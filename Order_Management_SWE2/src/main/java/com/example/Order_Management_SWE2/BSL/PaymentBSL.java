package com.example.Order_Management_SWE2.BSL;

import com.example.Order_Management_SWE2.model.Customer;
import com.example.Order_Management_SWE2.model.Order;
import org.springframework.stereotype.Service;

@Service
public class PaymentBSL {
    public String decreaseBalance(Order[] orders, float fees){
        if(orders.length == 1){
            Customer customer = orders[0].getCustomer();
            float balance = customer.getBalance();
            float price = orders[0].getPrice();
            if(balance >= price+fees) {
                customer.setBalance(balance - (price + fees));
                return "Payment Done";
            }
            else
                return "Balance is not enough";
        }
        else {
            Customer customer;
            float dividedFees = fees/orders.length;
            for (Order order : orders) {

                customer = order.getCustomer();
                float balance = customer.getBalance();
                float price = order.getPrice();
                float total = price + dividedFees;

                if (balance >= total) {
                    customer.setBalance(balance - total);
                    return "Payment Done";
                }
                else
                    return "Balance is not enough";
            }
        }
        return null;
    }
}
