package com.example.Order_Management_SWE2.BSL;

import com.example.Order_Management_SWE2.DataBase.DataBase;
import com.example.Order_Management_SWE2.model.Order;
import com.example.Order_Management_SWE2.model.Product;
import com.example.Order_Management_SWE2.model.SimpleOrder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SimpleOrderBSL {
    DataBase dataBase;
    Order SimpleOrder = new SimpleOrder();
    public SimpleOrderBSL(){
        dataBase = new DataBase();
    }
   public String makeSimpleOrder(List<Product> products){

        return null;
    }
}
