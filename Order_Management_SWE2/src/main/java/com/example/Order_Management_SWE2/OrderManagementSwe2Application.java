package com.example.Order_Management_SWE2;

import com.example.Order_Management_SWE2.DataBase.DataBase;
import com.example.Order_Management_SWE2.MessageTemplate.Canclletion.CancelMessage;
import com.example.Order_Management_SWE2.MessageTemplate.Canclletion.EnCancel;
import com.example.Order_Management_SWE2.MessageTemplate.Placement.ArPlaceMessage;
import com.example.Order_Management_SWE2.MessageTemplate.Placement.EnPlaceMessage;
import com.example.Order_Management_SWE2.MessageTemplate.Placement.PlaceMessage;
import com.example.Order_Management_SWE2.MessageTemplate.shippment.EnShipMessage;
import com.example.Order_Management_SWE2.MessageTemplate.shippment.ShipmentMessage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrderManagementSwe2Application {

	public static void main(String[] args) {
		System.out.println("Hello World!");
		SpringApplication.run(OrderManagementSwe2Application.class, args);
//		DataBase d = new DataBase();
//		PlaceMessage p = new ArPlaceMessage();
//		ShipmentMessage s = new EnShipMessage();
//		CancelMessage c = new EnCancel();
////		System.out.println(c.SendM(d.getOrders().get(0)));
//		System.out.println(p.SendM(d.getOrders().get(0)));

//		CustomerBSL customerBSL = new CustomerBSL();
//		CustomerController customerController = new CustomerController(customerBSL);
//		System.out.println(customerController.login("aya@gmail.com", "123456789"));
	}
}
