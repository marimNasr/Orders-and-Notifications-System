package com.example.Order_Management_SWE2.Product;

import com.example.Order_Management_SWE2.DataBase.DataBase;
import com.example.Order_Management_SWE2.Product.model.Product;
import com.example.Order_Management_SWE2.Product.model.SubCategory;

import java.util.List;
import java.util.Map;

public class ProductBSL {
    String strProducts = "";
    String header = "\nName\tPrice\tVendor\tCategory\tSubCategory\n";
    DataBase dataBase = new DataBase();
    List<Product> products = dataBase.getProducts();
    Map<Product,Integer> productsMap = dataBase.getProductsMap();


    public String display(){
        for(Product product : products){
            strProducts = strProducts + product.getName() + "\t" + product.getPrice() + " LE\t"
            + product.getVendor() + "\t" + product.getCategory()  + "\t" + product.getSubCategory()+"\n" ;
        }
        return header + strProducts;
    }

    public boolean ifProductEnough(String ProductName , int numOfProduct){
        for (Map.Entry<Product, Integer> entry : productsMap.entrySet()) {
            Product product = entry.getKey();
            Integer quantity = entry.getValue();
            if (product.getName().equals(ProductName)) {
                SubCategory subCategory = product.getSubCategory();
                if(quantity >= numOfProduct){
                    entry.setValue(quantity - numOfProduct);
                    subCategory.setCounter(subCategory.getCounter() - numOfProduct);
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    public Product getProduct(String productName){
        for (Map.Entry<Product, Integer> entry : productsMap.entrySet()) {
            Product product = entry.getKey();
            if (product.getName().equals(productName)) {
                return product;
            }
        }
        return null;
    }
}
