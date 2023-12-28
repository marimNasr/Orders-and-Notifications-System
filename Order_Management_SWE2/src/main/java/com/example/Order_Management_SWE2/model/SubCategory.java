package com.example.Order_Management_SWE2.model;

public enum SubCategory {
    subCATEGORY1("Bed",200),
    subCATEGORY2("Vase",100),
    subCATEGORY3("Table",100);


    private String subCategoryName;
    private int counter;

    SubCategory(String displayName, int count) {
        this.subCategoryName = displayName;
        this.counter = count;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public String getSubCategoryName() {
        return subCategoryName;
    }


}
