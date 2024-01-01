package com.example.Order_Management_SWE2.Product;

import com.example.Order_Management_SWE2.Product.ProductBSL;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ProductController {
    ProductBSL productBSL = new ProductBSL();
    String listOfProducts = productBSL.display();

    public String getListOfProducts() {
        return listOfProducts;}

}
