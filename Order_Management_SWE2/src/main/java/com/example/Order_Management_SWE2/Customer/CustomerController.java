package com.example.Order_Management_SWE2.Customer;

import com.example.Order_Management_SWE2.Customer.model.Customer;
import com.example.Order_Management_SWE2.Product.ProductController;
import com.example.Order_Management_SWE2.Customer.model.Login;
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
