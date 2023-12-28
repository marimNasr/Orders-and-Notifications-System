package com.example.Order_Management_SWE2.model;

import com.example.Order_Management_SWE2.BSL.CompoundCalc;
import com.example.Order_Management_SWE2.BSL.TotalPriceCalculation;

import java.util.List;

public class CompoundOrder extends Order{
    List<Order> orders;

    public CompoundOrder() {}

//    public CompoundOrder(String username,List<Product> products, float price, String state, float fees) {
//        super(username,products, price, state, fees);
//    }


    public void setPrice(float price) {
        TotalPriceCalculation calc = new CompoundCalc();
        price = calc.calculate(this);
    }
}
