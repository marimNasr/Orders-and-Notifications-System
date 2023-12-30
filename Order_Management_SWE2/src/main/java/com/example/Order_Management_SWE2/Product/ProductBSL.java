package com.example.Order_Management_SWE2.Product;

import com.example.Order_Management_SWE2.DataBase.DataBase;
import com.example.Order_Management_SWE2.Product.model.Product;
import com.example.Order_Management_SWE2.Product.model.SubCategory;

import java.util.List;

public class ProductBSL {
    String strProducts = "";
    String header = "\nName\tPrice\tVendor\tCategory\tSubCategory\n";
    DataBase dataBase = new DataBase();
    SubCategory subCategory;
    List<Product> products = dataBase.getProducts();
    public String display(){
        for(Product product : products){
            strProducts = strProducts + product.getName() + "\t" + product.getPrice() + " LE\t"
            + product.getVendor() + "\t" + product.getCategory()  + "\t" + product.getSubCategory()+"\n" ;
        }
        return header + strProducts;
    }
    public boolean ifProductEnough(String ProductName , int numOfProduct){

        for(Product product : products){
            if (product.getName().equals(ProductName)) {
                SubCategory subCategory = product.getSubCategory();
                if(subCategory.getCounter() >= numOfProduct){
                    subCategory.setCounter(subCategory.getCounter() - numOfProduct);
                    return true;
                }
                return false;
            }
        }

        return false;
    }
}
