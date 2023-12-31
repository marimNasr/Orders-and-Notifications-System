package com.example.Order_Management_SWE2.order;

import com.example.Order_Management_SWE2.order.CompundOrder.CompoundOrder;
import com.example.Order_Management_SWE2.order.SimpleOrder.SimpleOrderBSL;
import com.example.Order_Management_SWE2.order.CompundOrder.CompoundOrderBSL;
import com.example.Order_Management_SWE2.order.SimpleOrder.SimpleOrder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class OrderController {
    SimpleOrderBSL simpleOrderBSL = new SimpleOrderBSL();
    CompoundOrderBSL CompOrderBSL = new CompoundOrderBSL();


    @PostMapping("/simpleOrder")
    public String simpleOrder(@RequestBody SimpleOrder order) {

        return simpleOrderBSL.makeSimpleOrder(order);
    }
//    @PostMapping("/compoundOrder")
//    public String compoundOrder(@RequestBody CompoundOrder Order) {
//
//        return CompOrderBSL.makeCompoundOrder(Order);
//    }
}
