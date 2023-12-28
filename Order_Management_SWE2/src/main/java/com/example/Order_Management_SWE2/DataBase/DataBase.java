package com.example.Order_Management_SWE2.DataBase;
import com.example.Order_Management_SWE2.model.Customer;
import com.example.Order_Management_SWE2.model.Order;
import com.example.Order_Management_SWE2.model.Product;

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
      customers.add(new Customer("FadyHany44","Fady@gmail.com","20210292","01003909994","Shobra",1000));
      /////////////////////////////////////////////////////////////////////////////////////////////////////////////
      products.add(new Product("1245","TV","Toshiba","Electronics",12000,736));
      products.add(new Product("4578","Table","Elmorshdy","Furniture",1200,450));
      products.add(new Product("1489","Bed","Elmorshdy","Furniture",5600,140));
      products.add(new Product("4898","Washing Machine","Toshiba","Electronics",4500,120));
      products.add(new Product("4788","Fan","Toshiba","Electronics",600,300));
      products.add(new Product("4565","Dinning Table","Elmorshdy","Furniture",1500,45));
      products.add(new Product("1473","Vasa","Elmorshdy","Furniture",400,130));
      products.add(new Product("4980","Boiler","Toshiba","Electronics",500,300));
      products.add(new Product("1478","Fridge","Toshiba","Electronics",14200,630));
      //Products of orders/////////////////////////////////////////////////////////////////////////////////////////////////////////
      List<Product> selectedProducts = new ArrayList<>();
      selectedProducts.add(products.get(0));selectedProducts.add(products.get(1));
      List<Product> selectedProducts1 = new ArrayList<>();
      selectedProducts.add(products.get(0));selectedProducts.add(products.get(5));selectedProducts.add(products.get(6));
      List<Product> selectedProducts2 = new ArrayList<>();
      selectedProducts.add(products.get(1));selectedProducts.add(products.get(7));
      List<Product> selectedProducts3 = new ArrayList<>();
      selectedProducts.add(products.get(2));selectedProducts.add(products.get(8));
      List<Product> selectedProducts4 = new ArrayList<>();
      selectedProducts.add(products.get(2));selectedProducts.add(products.get(8));selectedProducts.add(products.get(3));selectedProducts.add(products.get(4));
   ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      orders.add(new Order(1020,selectedProducts,13200,"Shipped",customers.get(0),100));
      orders.add(new Order(2030,selectedProducts1,13900,"Confirmed",customers.get(3),150));
      orders.add(new Order(4060,selectedProducts2,1500,"Hold",customers.get(1),120));
      orders.add(new Order(5090,selectedProducts3,19700,"Confirmed",customers.get(1),190));
      orders.add(new Order(7602,selectedProducts4,24900,"Shipped",customers.get(2),400));
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

   public List<Order> getOrders() {
      return orders;
   }

}
