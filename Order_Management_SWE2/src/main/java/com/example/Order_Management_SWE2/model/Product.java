package com.example.Order_Management_SWE2.model;

public class Product {
    String SerialNum ;
    String Name;
    String Vendor;
    Category Category;
    float Price;
    int RemainingNum;

    public Product(String serialNum, String name, String vendor, String category, float Price, int remainingNum){

        this.SerialNum=serialNum;
        this.Name=name;
        this.Vendor=vendor;

        this.Price=Price;
        this.RemainingNum=remainingNum;
    }

    public String getSerialNum() {
        return SerialNum;
    }

    public void setSerialNum(String serialNum) {
        SerialNum = serialNum;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getVendor() {
        return Vendor;
    }

    public void setVendor(String vendor) {
        Vendor = vendor;
    }

    public Category getCategory() {
        return Category;
    }

    public void setCategory(Category category) {
        Category = category;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float price) {
        Price = price;
    }

    public int getRemainingNum() {
        return RemainingNum;
    }

    public void setRemainingNum(int remainingNum) {
        RemainingNum = remainingNum;
    }
}
