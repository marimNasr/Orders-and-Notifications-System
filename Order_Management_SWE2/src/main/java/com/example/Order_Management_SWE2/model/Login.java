package com.example.Order_Management_SWE2.model;

import com.example.Order_Management_SWE2.BSL.CustomerBSL;
import com.example.Order_Management_SWE2.cotroller.CustomerController;

public class Login {
    String email;
    String pass;
    CustomerBSL customerBSL = new CustomerBSL();

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String log(String email, String pass){
        if (customerBSL.login(email, pass)) {
            return "Login successful!";
        } else {
            return "Login failed. Please check your credentials.";
        }
    }
}
