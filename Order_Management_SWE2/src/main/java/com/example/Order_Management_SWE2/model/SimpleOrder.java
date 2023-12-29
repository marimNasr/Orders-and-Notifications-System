package com.example.Order_Management_SWE2.model;

import com.example.Order_Management_SWE2.BSL.SimpleCalc;
import com.example.Order_Management_SWE2.BSL.TotalPriceCalculation;

import java.util.HashMap;
import java.util.List;

public class SimpleOrder extends Order {
    public SimpleOrder() {}

    public SimpleOrder(String username, HashMap<String, Integer> products, float price, String state, float fees) {
        super(username,products, price, state, fees);
    }

    @Override
    public void setPrice(float price) {
        TotalPriceCalculation calc = new SimpleCalc();
        price = calc.calculate(this);
    }
}
