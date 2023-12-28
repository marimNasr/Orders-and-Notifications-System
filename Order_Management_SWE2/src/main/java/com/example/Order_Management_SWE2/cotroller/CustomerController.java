package com.example.Order_Management_SWE2.cotroller;

import com.example.Order_Management_SWE2.BSL.CustomerBSL;
import com.example.Order_Management_SWE2.BSL.ProductBSL;
import com.example.Order_Management_SWE2.model.Customer;
import com.example.Order_Management_SWE2.model.Login;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CustomerController {
    CustomerBSL customerBSL = new CustomerBSL();
    ProductController productController = new ProductController();

    public CustomerController(CustomerBSL customerBSL) {
        this.customerBSL = customerBSL;
    }

    @PostMapping("/signup")
    public String add(@RequestBody Customer customer){
        return customerBSL.add(customer);
    }

    @GetMapping(value = "/getCustomer/{username}")
    public Customer get(@PathVariable("username") String userName){
        return customerBSL.get(userName);
    }

    @PostMapping("/login")
    public String login(@RequestBody Login login) {
        return login.log(login.getEmail(), login.getPass()) + productController.getListOfProducts();
    }
}
