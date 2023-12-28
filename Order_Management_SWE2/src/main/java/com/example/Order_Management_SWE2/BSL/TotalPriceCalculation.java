package com.example.Order_Management_SWE2.BSL;

import com.example.Order_Management_SWE2.model.Order;

public interface TotalPriceCalculation {
    float calculate(Order order);
}
