package com.example.Order_Management_SWE2.model;


import java.util.List;

public abstract class Order {
    int ID;
    List<Product> Products;
    float Price;
    String state;
    float Fees;
    String CustomerUsername;

    public Order() {}

    public Order(String customerName,List<Product> products, float price, String state, float fees) {
        Products = products;
        Price = price;
        this.state = state;
        Fees = fees;
        CustomerUsername = customerName;
    }
    public int getID() {
        return ID;
    }

//    //public void setID(int ID) {
//        this.ID = ID;
//    }

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
}
