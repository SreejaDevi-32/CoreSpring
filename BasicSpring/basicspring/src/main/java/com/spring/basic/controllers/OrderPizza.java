package com.spring.basic.controllers;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pizza")
public class OrderPizza {
	
	@GetMapping("/addPizzaOrder")
	public Map<Object,Object> addOrder(@RequestParam String custName) {
		System.out.println("Add Order Page");
		Map<Object,Object> orderMap = new LinkedHashMap<>();
		int orderNo =1;
		orderMap.put("customerName",custName);
		orderMap.put("OrderNo", orderNo);
		orderMap.put("Message", "Your Order Successful");
		return orderMap;
	}
	
	@GetMapping("/getPizzaOrder")
	public String getOrder()
	{
		return "Ordered Customer";
		
	}

}
