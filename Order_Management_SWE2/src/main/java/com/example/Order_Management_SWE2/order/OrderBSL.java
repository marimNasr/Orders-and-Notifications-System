package com.example.Order_Management_SWE2.order;

import com.example.Order_Management_SWE2.DataBase.DataBase;
import com.example.Order_Management_SWE2.order.model.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderBSL {
    DataBase dataBase;
    private List <Order> orders;
    public OrderBSL(){
        dataBase = new DataBase();
    }

    public Order get(int id){
        for(Order order : orders){
            if(order.getID() == id)
                return order;
        }
        return null;
    }

    public void add(Order[] ords){
        orders.addAll(List.of(ords));
    }

    public List<Order> getOrders() {
        return orders;
    }

//    public Order makeOrder(List<Product> products) {
//        return new Order(1020, products, 13900, "Shipped", customers.get(0), 100);
//    }
}
