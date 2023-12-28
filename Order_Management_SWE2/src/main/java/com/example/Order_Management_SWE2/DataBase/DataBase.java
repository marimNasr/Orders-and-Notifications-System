package com.example.Order_Management_SWE2.DataBase;
import com.example.Order_Management_SWE2.model.*;

import java.util.ArrayList;
import java.util.List;

public class DataBase {
   private List<Customer> customers = new ArrayList<Customer>();
   private List<Order> orders = new ArrayList<Order>();
   private List<Product> products= new ArrayList<Product>();

   public DataBase(){


      customers.add(new Customer("AyaMohamed77","aya@gmail.com","123456789","01100104604","Giza",40000));
      customers.add(new Customer("MariamNasr66","mariam@gmail.com","20211020","01102085630","Shobra",30000));
      customers.add(new Customer("KarinKheir88","Karin@gmail.com","1357901","01278792903","Cairo",50000));
      customers.add(new Customer("KariemGamal33","Karim@gmail.com","22821422","01148454445","Eltagmo3",30000));
      customers.add(new Customer("FadyHany44","Fady@gmail.com","20210292","01003909994","Shobra",10000));
      /////////////////////////////////////////////////////////////////////////////////////////////////////////////
      products.add(new Product("4578","Baby Bed","Elmorshdy",Category.CATEGORY1, SubCategory.subCATEGORY1,1200));
      products.add(new Product("1489","Master Bed","Elmorshdy",Category.CATEGORY1,SubCategory.subCATEGORY1,5600));
      products.add(new Product("4565","Dinning Table","Elmorshdy",Category.CATEGORY1,SubCategory.subCATEGORY3,1500));
      products.add(new Product("1473","Vase","Elmorshdy",Category.CATEGORY1,SubCategory.subCATEGORY2,400));
      //Products of orders/////////////////////////////////////////////////////////////////////////////////////////////////////////
      List<Product> selectedProducts = new ArrayList<>();
      selectedProducts.add(products.get(0));selectedProducts.add(products.get(1));
      List<Product> selectedProducts1 = new ArrayList<>();
      selectedProducts.add(products.get(0));selectedProducts.add(products.get(2));selectedProducts.add(products.get(3));
      List<Product> selectedProducts2 = new ArrayList<>();
      selectedProducts.add(products.get(1));selectedProducts.add(products.get(3));
      List<Product> selectedProducts3 = new ArrayList<>();
      selectedProducts.add(products.get(2));selectedProducts.add(products.get(1));
      List<Product> selectedProducts4 = new ArrayList<>();
      selectedProducts.add(products.get(2));selectedProducts.add(products.get(1));selectedProducts.add(products.get(0));selectedProducts.add(products.get(3));
   ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      orders.add(new SimpleOrder(selectedProducts,6800,"Shipped",100));
      orders.add(new SimpleOrder(selectedProducts1,3100,"Confirmed",150));
      orders.add(new SimpleOrder(selectedProducts2,4000,"Hold",120));
      orders.add(new SimpleOrder(selectedProducts3,7100,"Confirmed",190));
      orders.add(new SimpleOrder(selectedProducts4,24900,"Shipped",400));
   }

   public List<Customer> getCustomers() {
      return customers;
   }

   public void addCustomer(Customer c) {
      customers.add(c);
   }

   public void setOrders(List<Order> orders) {
      this.orders = orders;
   }

   public void setProducts(List<Product> products) {
      this.products = products;
   }

   public List<Product> getProducts() {
      return products;
   }

   public List<Order> getOrders() {
      return orders;
   }
}
