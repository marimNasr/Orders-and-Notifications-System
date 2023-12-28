package com.example.Order_Management_SWE2.model;

public enum Category {
    CATEGORY1("Furniture",SubCategory.subCATEGORY1,
              SubCategory.subCATEGORY2,
              SubCategory.subCATEGORY3);

    private final SubCategory[] categories;
    private String categoryName;

    Category(String name,SubCategory...subCategories) {
        this.categories = subCategories;
        this.categoryName = name;
    }

    public String getCategoryName() {
        return categoryName;
    }

}