package com.example.Order_Management_SWE2.BSL;

import com.example.Order_Management_SWE2.DataBase.DataBase;
import com.example.Order_Management_SWE2.model.Product;
import com.example.Order_Management_SWE2.model.SubCategory;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

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
    public boolean ifProductEnough(HashMap<String, Integer> orderProducts){
        Set<String> setOfProductsName = orderProducts.keySet();
        for(String productName : setOfProductsName){
            for(Product product : products){
                if (product.getName().equals(productName)) {
                    SubCategory subCategory = SubCategory.valueOf(product.getSubCategory());
                    if(subCategory.getCounter() >= orderProducts.get(productName)){
                        subCategory.setCounter(subCategory.getCounter() - orderProducts.get(productName));
                        return true;
                    }
                    return false;
                }
            }
        }
        return false;
    }
}
