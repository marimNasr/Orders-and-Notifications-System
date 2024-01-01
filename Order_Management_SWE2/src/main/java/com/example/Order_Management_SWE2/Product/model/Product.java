package com.example.Order_Management_SWE2.Product.model;

public class Product {
    String SerialNum ;
    String Name;
    String Vendor;
    Category category;
    SubCategory subCategory;
    float Price;
    String subCategoryName;

    public Product(String serialNum, String name, String vendor, Category c1,SubCategory sub, float Price){

        this.SerialNum = serialNum;
        this.Name = name;
        this.Vendor = vendor;
        this.category = c1;
        this.subCategory = sub;
        this.Price = Price;
        this.subCategoryName = sub.getSubCategoryName();
    }

    public String getName() {
        return Name;
    }

    public String getVendor() {
        return Vendor;
    }

    public Category getCategory() {
        return category;
    }
    public SubCategory getSubCategory() {return subCategory;}

    public float getPrice() {
        return Price;
    }

}
