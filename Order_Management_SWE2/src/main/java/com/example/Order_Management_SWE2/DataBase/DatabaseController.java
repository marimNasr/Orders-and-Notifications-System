package com.example.Order_Management_SWE2.DataBase;

import com.example.Order_Management_SWE2.Customer.model.Customer;
import com.example.Order_Management_SWE2.order.model.Order;

import java.util.List;

public class DatabaseController
{
    DataBase dataBase = new DataBase();
    List<Customer> customers = dataBase.getCustomers();
    List<Order> orders = dataBase.getOrders();
    public Customer getUser(String username){
        for(Customer customer : customers){
            if(customer.getUserName().equals(username)) {
                return customer;
            }
        }
        return null;
    }

    public void addCustomer(Customer c) {
        customers.add(c);
    }
    public void addOrder(Order order){
        orders.add(order);
    }
    public void displayOrders(){
        for(Order order : orders){
            System.out.println(order.getUsername());
        }
    }

}
