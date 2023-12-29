package com.example.Order_Management_SWE2.model;


import java.util.HashMap;
import java.util.Map;

public abstract class Order {
    int ID;
    Map<String,Integer> products;
    float Price;
    String state;
    float Fees;
    String CustomerUsername;

    public Order() {}

    public Order(String customerName, HashMap<String, Integer> items, float price, String state, float fees) {
        Price = price;
        this.state = state;
        Fees = fees;
        CustomerUsername = customerName;
        products = items;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setFees(float fees) {
        Fees = fees;
    }

    public float getFees() {
        return Fees;
    }

    public Map<String, Integer> getProducts() {
        return (HashMap<String, Integer>) products;
    }

    public void setProducts(HashMap<String, Integer> products) {
        this.products = products;
    }

    public float getPrice() {
        return Price;
    }

    public abstract void setPrice(float price) ;
    public  String getCustomerUsername(){
        return CustomerUsername;}
}
