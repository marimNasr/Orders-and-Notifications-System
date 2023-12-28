package com.example.Order_Management_SWE2.model;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Order {
    int ID;
    List<Product> Products;
    Map<Product,Integer> quantity;
    float Price;
    String state;
    float Fees;
    String CustomerUsername;

    public Order() {}

    public Order(String customerName,HashMap<Product,Integer> items, float price, String state, float fees) {
//        Products = products;
        Price = price;
        this.state = state;
        Fees = fees;
        CustomerUsername = customerName;
        quantity = items;
    }
//    {
//        "customerName":"m"
//        "products":{"knife":2,"shoe":3},
//        "price":2.6
//    }

    public int getID() {
        return ID;
    }

//    //public void setID(int ID) {
//        this.ID = ID;
//    }

    public void setFees(float fees) {
        Fees = fees;
    }

    public float getFees() {
        return Fees;
    }

    public List<Product> getProducts() {
        return Products;
    }

    public void setProducts(List<Product> products) {
        Products = products;
    }

    public float getPrice() {
        return Price;
    }

    public abstract void setPrice(float price) ;
    public  String getCustomerUsername(){
        return getCustomerUsername();
    }

}
