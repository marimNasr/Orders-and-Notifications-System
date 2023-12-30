package com.example.Order_Management_SWE2.Customer;

import com.example.Order_Management_SWE2.Customer.model.Customer;
import com.example.Order_Management_SWE2.DataBase.DataBase;
import com.example.Order_Management_SWE2.DataBase.DatabaseController;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerBSL {
    private DataBase dataBase;
    private DatabaseController databaseController;
    private List<Customer> customers;
    public CustomerBSL() {
        dataBase = new DataBase();
        databaseController = new DatabaseController();
        customers = dataBase.getCustomers();
        }

    public Customer get(String userName){
        for(Customer customer : customers){
            if(customer.getUserName().equals(userName))
                return customer;
        }
        return null;
    }
    //sign up
    public String add(Customer customer){
        for(Customer customer1 : customers) {
            if(customer1.getEmail().equals(customer.getEmail()) || customer1.getUserName().equals(customer.getUserName()))
                return "this user name already exists";
        }
        databaseController.addCustomer(customer);
        return "user added successfully";
    }

    public boolean login(String email, String pass){
        for(Customer customer : customers){
            if(customer.getEmail().equals(email) && customer.getPass().equals(pass)){
                    return true;
            }
        }
        return false;
    }

}
