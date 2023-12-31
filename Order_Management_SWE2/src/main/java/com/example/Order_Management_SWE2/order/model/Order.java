package com.example.Order_Management_SWE2.order.model;


import java.util.Map;

public abstract class Order {
    int id;
    Map<String,Integer> products;
    float price;
    OrderState state;
    float Fees;
    String username;
    long placeTime;
    long shipTime;

    public Order() {}

    public Order(int id,String username, Map<String, Integer> items, float price, float fees) {
        this.id = id;
        this.price = price;
        this.Fees = fees;
        this.username = username;
        this.products = items;

    }

    public int getId() {
        return id;
    }

    public float getFees() {
        return Fees;
    }

    public Map<String, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<String, Integer> products) {
        this.products = products;
    }

    public float getPrice() {
        return price;
    }


    public String getUsername(){
      return username;
    }

    public OrderState getState() {
        return state;
    }

    public void setState(OrderState state) {
        this.state = state;
    }
    public long getPlaceTime() {
        return placeTime;
    }
    public void setPlaceTime() {
        this.placeTime = System.currentTimeMillis();
    }
    public long getShipTime() {
        return shipTime;
    }
    public void setShipTime() {
        this.shipTime = System.currentTimeMillis();
    }

}
