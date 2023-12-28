package com.example.Order_Management_SWE2.model;

import com.example.Order_Management_SWE2.BSL.SimpleCalc;
import com.example.Order_Management_SWE2.BSL.TotalPriceCalculation;

import java.util.List;

public class SimpleOrder extends Order {
    public SimpleOrder() {}

    public SimpleOrder(List<Product> products, float price, String state, float fees) {
        super(products, price, state, fees);
    }

    @Override
    public void setPrice(float price) {
        TotalPriceCalculation calc = new SimpleCalc();
        price = calc.calculate(this);
    }
}
