package com.example.Order_Management_SWE2;

import com.example.Order_Management_SWE2.BSL.CustomerBSL;
import com.example.Order_Management_SWE2.DataBase.DataBase;
import com.example.Order_Management_SWE2.cotroller.CustomerController;
import com.example.Order_Management_SWE2.model.Customer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class OrderManagementSwe2Application {

	public static void main(String[] args) {
		SpringApplication.run(OrderManagementSwe2Application.class, args);
//		DataBase dataBase = new DataBase();
//		CustomerBSL customerBSL = new CustomerBSL();
//		CustomerController customerController = new CustomerController(customerBSL);
//		System.out.println(customerController.login("aya@gmail.com", "123456789"));
	}
}
