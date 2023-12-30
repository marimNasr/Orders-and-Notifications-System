package com.example.Order_Management_SWE2.DataBase;
import com.example.Order_Management_SWE2.Customer.model.Customer;
import com.example.Order_Management_SWE2.Product.model.Category;
import com.example.Order_Management_SWE2.Product.model.Product;
import com.example.Order_Management_SWE2.Product.model.SubCategory;
import com.example.Order_Management_SWE2.order.SimpleOrder.SimpleOrder;
import com.example.Order_Management_SWE2.order.model.Order;

import java.util.ArrayList;
import java.util.HashMap;
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
      products.add(new Product("4578","Baby Bed","Elmorshdy", Category.CATEGORY1, SubCategory.subCATEGORY1,1200));
      products.add(new Product("1489","Master Bed","Elmorshdy",Category.CATEGORY1,SubCategory.subCATEGORY1,5600));
      products.add(new Product("4565","Dinning Table","Elmorshdy",Category.CATEGORY1,SubCategory.subCATEGORY3,1500));
      products.add(new Product("1473","Vase","Elmorshdy",Category.CATEGORY1,SubCategory.subCATEGORY2,400));
//      Products of orders/////////////////////////////////////////////////////////////////////////////////////////////////////////
      HashMap<String, Integer> products = new HashMap<>();
      products.put("Baby Bed",10);
      HashMap<String, Integer> products2 = new HashMap<>();
      products.put("Master Bed",10);
      HashMap<String, Integer> products3 = new HashMap<>();
      products.put("Dinning Table",10);
      HashMap<String, Integer> products4 = new HashMap<>();
      products.put("Vase",10);
//   ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      orders.add(new SimpleOrder("MariamNasr66", products,6800,"Shipped",100));
      orders.add(new SimpleOrder("AyaMohamed77",products2,3100,"Confirmed",150));
      orders.add(new SimpleOrder("KariemGamal33",products3,4000,"Hold",120));
      orders.add(new SimpleOrder("FadyHany44",products3,7100,"Confirmed",190));
      orders.add(new SimpleOrder("KarinKheir88",products4,24900,"Shipped",400));
   }

   public List<Customer> getCustomers() {
      return customers;
   }




   public List<Product> getProducts() {
      return products;
   }
   public List<Order> getOrders(){
      return orders;
   }


}