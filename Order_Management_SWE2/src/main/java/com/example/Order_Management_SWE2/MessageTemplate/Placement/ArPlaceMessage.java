package com.example.Order_Management_SWE2.MessageTemplate.Placement;

import com.example.Order_Management_SWE2.order.CompundOrder.CompoundOrder;
import com.example.Order_Management_SWE2.order.model.Order;

import java.util.Map;

public class ArPlaceMessage extends PlaceMessage {
    @Override
    public String createMessages(Order order) {
        String Temp = "";
        msg = "";
        msg = msg + "عميلنا العزيز " ;
        msg = msg + "\n "+order.getUsername();
        msg = msg +":يرجى احاطتكم علما بأنه تم تأكيد طلبك و الذي يحتوي على ";
        String products = "";
        Map<String, Integer> items = order.getProducts();

        for(Map.Entry<String, Integer> item : items.entrySet()){
            products = products + item.getKey() + " والذي قمت بشراء عدد  "+ Integer.toString(item.getValue()) + "  قطع منه  \n";
        }
        msg = msg +products;
        msg = msg+ "بنجاح ";
        msg = msg + "ويحمل الرقم التعريفي ";
        msg = msg + order.getId();
        return msg;
    }

}
