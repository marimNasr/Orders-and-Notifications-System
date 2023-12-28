package com.example.Order_Management_SWE2.cotroller;

import com.example.Order_Management_SWE2.BSL.CustomerBSL;
import com.example.Order_Management_SWE2.model.Customer;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CustomerController {
    CustomerBSL customerBSL = new CustomerBSL();

    public CustomerController(CustomerBSL customerBSL) {
        this.customerBSL = customerBSL;
    }

    @PostMapping("/add")
    public String add(@RequestBody Customer customer){
        return customerBSL.add(customer);
    }

    @GetMapping(value = "/getCustomer/{username}")
    public Customer get(@PathVariable("username") String userName){
        return customerBSL.get(userName);
    }

    @PostMapping("/login")
    public String login(@RequestBody String email, String pass) {
        if (customerBSL.login(email, pass)) {
            return "Login successful!";
        } else {
            return "Login failed. Please check your credentials.";
        }
    }


}
