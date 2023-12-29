package com.example.Order_Management_SWE2.model;

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

    public String getCategory() {
        return category.getCategoryName();
    }
    public String getSubCategory() {return subCategory.getSubCategoryName();}

    public void setCategory(Category category) {
        category = category;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float price) {
        Price = price;
    }

}
