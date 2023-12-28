package com.example.Order_Management_SWE2.model;

import com.example.Order_Management_SWE2.cotroller.TotalPriceCalculation;

import java.util.List;

public class Order {

    int ID;
    List<Product> Products;
    float Price;
    String state;
    TotalPriceCalculation Calc;
    Customer customer;
    float Fees;
    public Order(int ID, List<Product> products, float price, String state, Customer customer, float fees) {
        this.ID = ID;
        Products = products;
        Price = price;
        this.state = state;
        this.customer = customer;
        Fees = fees;
    }
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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

    public void setPrice(float price) {
        Price = price;
    }

    public TotalPriceCalculation getCalc() {
        return Calc;
    }

    public void setCalc(TotalPriceCalculation calc) {
        Calc = calc;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
