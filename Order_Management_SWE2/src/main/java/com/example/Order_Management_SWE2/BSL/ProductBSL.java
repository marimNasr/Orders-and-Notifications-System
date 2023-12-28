package com.example.Order_Management_SWE2.BSL;

import com.example.Order_Management_SWE2.DataBase.DataBase;
import com.example.Order_Management_SWE2.model.Product;

import java.util.List;

public class ProductBSL {
    String strProducts = "";
    String header = "\nName\tPrice\tVendor\tCategory\tSubCategory\n";
    DataBase dataBase = new DataBase();
    List<Product> products = dataBase.getProducts();
    public String display(){
        for(Product product : products){
            strProducts = strProducts + product.getName() + "\t" + product.getPrice() + " LE\t"
            + product.getVendor() + "\t" + product.getCategory()  + "\t" + product.getSubCategory()+"\n" ;
        }
        return header + strProducts;
    }

}
