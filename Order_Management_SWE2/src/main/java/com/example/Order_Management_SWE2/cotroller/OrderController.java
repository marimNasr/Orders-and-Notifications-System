package com.example.Order_Management_SWE2.cotroller;

import com.example.Order_Management_SWE2.BSL.SimpleOrderBSL;
import com.example.Order_Management_SWE2.model.Product;
import com.example.Order_Management_SWE2.model.SimpleOrder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class OrderController {
    SimpleOrderBSL simpleOrderBSL = new SimpleOrderBSL();
    @PostMapping("/simpleOrder")
    public String simpleOrder(@RequestBody List<Product> products){
        return simpleOrderBSL.makeSimpleOrder(products);
    }
}
