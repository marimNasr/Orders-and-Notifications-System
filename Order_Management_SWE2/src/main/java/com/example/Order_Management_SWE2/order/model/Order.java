package com.example.Order_Management_SWE2.order.model;


import java.util.HashMap;
import java.util.Map;

public abstract class Order {
    int ID;
    Map<String,Integer> products;
    float price;
    String state;
    float Fees;
    String username;
    public Order() {}

    public Order(String username, HashMap<String, Integer> items, float price, String state, float fees) {
        this.price = price;
        this.state = state;
        this.Fees = fees;
        this.username = username;
        this.products = items;
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
        return price;
    }



    public String getUsername(){
      return username;
    }
}
