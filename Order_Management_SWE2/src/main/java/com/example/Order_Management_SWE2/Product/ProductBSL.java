package com.example.Order_Management_SWE2.Product;

import com.example.Order_Management_SWE2.DataBase.DataBase;
import com.example.Order_Management_SWE2.Product.model.Product;
import com.example.Order_Management_SWE2.Product.model.SubCategory;

import java.util.List;
import java.util.Map;

public class ProductBSL {
    String strProducts = "";
    DataBase dataBase = new DataBase();
    List<Product> products = dataBase.getProducts();
    Map<Product,Integer> productsMap;

    public ProductBSL(){
        productsMap= dataBase.getProductsMap();
    }
    public String display(){
        String header = "\nName\tPrice\tVendor\tCategory\tSubCategory\n";
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
                    productsMap.put(product,quantity-numOfProduct);
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

    public void increaseQuantity(Product p,int q ){
        int x =productsMap.get(p);
        x+=q;
        productsMap.put(p,x);
    }
}
