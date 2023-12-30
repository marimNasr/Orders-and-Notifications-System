package com.example.Order_Management_SWE2.order.CompundOrder;

import com.example.Order_Management_SWE2.DataBase.DatabaseController;
import com.example.Order_Management_SWE2.Payment.PaymentBSL;
import com.example.Order_Management_SWE2.Product.ProductBSL;
import com.example.Order_Management_SWE2.order.SimpleOrder.SimpleOrder;
import com.example.Order_Management_SWE2.order.model.Order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CompoundOrderBSL {
    DatabaseController DBController= new DatabaseController();
    ProductBSL productBSL = new ProductBSL();
    PaymentBSL paymentBSL = new PaymentBSL();
    HashMap<String, Integer> products = new HashMap<>();

    public String makeCompoundOrder(CompoundOrder order){
        boolean x = false;
        products = (HashMap<String, Integer>) order.getProducts();
        for(HashMap.Entry<String, Integer> entry : products.entrySet()) {
            boolean productEnough = productBSL.ifProductEnough(entry.getKey(), entry.getValue());


            boolean pay = paymentBSL.paySimpleOrder(order, order.getUsername(), DBController);
            if(productEnough && pay){
                x = true;
            }else{
                x = false;
                break;
            }

        }
        if(x){
            DBController.addOrder(order);
        }

        return x ? "Order is done" : "Failed to make order";

    }

}
