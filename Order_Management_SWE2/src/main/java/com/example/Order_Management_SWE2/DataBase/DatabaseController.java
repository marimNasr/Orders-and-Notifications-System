package com.example.Order_Management_SWE2.DataBase;

import com.example.Order_Management_SWE2.model.Customer;

import java.util.List;

public class DatabaseController
{
    DataBase dataBase = new DataBase();
    List<Customer> customers = dataBase.getCustomers();
    public Customer getUser(String username){
        for(Customer customer : customers){
            if(customer.getUserName().equals(username))
                return customer;
        }
        return null;
    }
}
