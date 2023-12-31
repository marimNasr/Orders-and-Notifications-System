package com.example.Order_Management_SWE2.DataBase;
import com.example.Order_Management_SWE2.Customer.model.Customer;
import com.example.Order_Management_SWE2.Product.model.Category;
import com.example.Order_Management_SWE2.Product.model.Product;
import com.example.Order_Management_SWE2.Product.model.SubCategory;
import com.example.Order_Management_SWE2.order.CompundOrder.CompoundOrder;
import com.example.Order_Management_SWE2.order.SimpleOrder.SimpleOrder;
import com.example.Order_Management_SWE2.order.model.Order;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataBase {
   private static List<Customer> customers = new ArrayList<Customer>();
   private List<Order> orders = new ArrayList<Order>();
   private List<Product> products= new ArrayList<Product>();
   // get prducts map
   @Getter
   private static Map<Product, Integer> productsMap = new HashMap<Product, Integer>();
  HashMap<String, Integer> product = new HashMap<>();
   private ArrayList<SimpleOrder> order = new ArrayList<SimpleOrder>();

   public DataBase(){


      customers.add(new Customer("AyaMohamed77","aya@gmail.com","123456789","01100104604","Giza",40000,"Ar","Email"));
      customers.add(new Customer("MariamNasr66","mariam@gmail.com","20211020","01102085630","Shobra",30000,"En","SMS"));
      customers.add(new Customer("KarinKheir88","Karin@gmail.com","1357901","01278792903","Cairo",50000,"Ar","SMS"));
      customers.add(new Customer("KariemGamal33","Karim@gmail.com","22821422","01148454445","Eltagmo3",30000,"En","SMS"));
      customers.add(new Customer("FadyHany44","Fady@gmail.com","20210292","01003909994","Shobra",10000,"Ar","Email"));
      /////////////////////////////////////////////////////////////////////////////////////////////////////////////
      Product product1 =new Product("4578","Baby Bed","Elmorshdy", Category.CATEGORY1, SubCategory.subCATEGORY1,1200);
      Product product2 =new Product("1489","Master Bed","Elmorshdy",Category.CATEGORY1,SubCategory.subCATEGORY1,5600);
      Product product3 = new Product("4565","Dinning Table","Elmorshdy",Category.CATEGORY1,SubCategory.subCATEGORY3,1500);
      Product product4 = new Product("1473","Vase","Elmorshdy",Category.CATEGORY1,SubCategory.subCATEGORY2,400);
      products.add(product1);
      products.add(product2);
      products.add(product3);
      products.add(product4);
//      Products of orders/////////////////////////////////////////////////////////////////////////////////////////////////////////
      productsMap.put(product1,10);
      productsMap.put(product2,10);
      productsMap.put(product3,10);
      productsMap.put(product4,10);
      product.put("Baby Bed" ,10);
      product.put("Master Bed" ,10);
   ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      order.add(new SimpleOrder(123,"MariamNasr66", product,6800,100));
      order.add(new SimpleOrder(234,"AyaMohamed77",product,3100,150));
      orders.add(new CompoundOrder(459,"KariemGamal33",product,3100,150,order));

//      orders.add(new SimpleOrder("KariemGamal33",products3,4000,"Hold",120));
//      orders.add(new SimpleOrder("FadyHany44",products3,7100,"Confirmed",190));
//      orders.add(new SimpleOrder("KarinKheir88",products4,24900,"Shipped",400));
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
   public ArrayList<SimpleOrder> getOrder(){
      return order;
   }
}