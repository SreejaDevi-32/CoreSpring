package com.spring.core.componentscan;

import java.awt.PageAttributes.MediaType;
import java.net.http.HttpHeaders;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")


public class OrderController {
	@Autowired
	Order order;
	
	@GetMapping("/fetchOrder")
	public String getOrderDetails() {
		System.out.println("Fetching Order Details");
		return "Fetching Order Details";
		
	}
	//http://localhost:8080/api/createOrder?orderno=1
	@PostMapping("/createOrder")
	public String createOrderwithId(@RequestParam int orderno) {
		order.createOrder();
		System.out.println("Order is created with number : "+orderno);
		return "Order is created with number : "+orderno;
	}
	
	@PostMapping("/createOrderBody")
	public String createOrderwithPath(@RequestBody String body)
	{
		System.out.println("Order is created with body JSON : "+body);
		return "Order is created with body JSON : "+body;
	}
	
	//http://localhost:8080/api/saveOrder/sreeja
	@PutMapping("/saveOrder/{path}")
	public String addToCart(@PathVariable String path) {
		System.out.println("Order is added to cart"+path);
		return "Order is added to cart"+path;
	}
	//http://localhost:8080/api/deleteOrder?continue
	@DeleteMapping("/deleteOrder")
	public String deleteOrder() {
		System.out.println("Order is Deleted");
		return "Order is Deleted";
	}
	
	@GetMapping("/users")
    public ResponseEntity<Map<String, Object>> getUser() {
        org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
        headers.add("My-Header1", "SomeValue1");
        headers.add("My-Header2", "SomeValue2");
        HttpStatus status = HttpStatus.OK;
       

        Map<String, Object> response = new LinkedHashMap<>();
        response.put("StatusCode", status.value());
        response.put("StatusName", status.name());
        response.put("message", "My response in JSON");
        response.put("headers", headers.toSingleValueMap()); // Convert HttpHeaders to a simple map

        return ResponseEntity.ok()
                             .headers(headers) // You still set the headers in the HTTP response
                             .body(response);
    }
	

}
