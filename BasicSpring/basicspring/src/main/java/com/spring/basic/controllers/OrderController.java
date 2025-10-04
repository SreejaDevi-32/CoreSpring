package com.spring.basic.controllers;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpHeaders;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;
import com.spring.basic.Exceptions.ZeroCustomException;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	 @PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/getOrder")
	public ResponseEntity<?> getOrderDetails() {
		System.out.println("Get order details method executed");
		HttpHeaders header = new HttpHeaders();
		header.add("OrderName", "Something");
		//header.add("OrderNo", orderno);
		HttpStatus status = HttpStatus.OK;
		
		Map<String,Object> response = new LinkedHashMap<String,Object>();
		response.put("StatusName", status.value());
		response.put("StatusValue", status.name());
		response.put("Message", "Succesfully fetched the Order");
		return ResponseEntity.status(status)
						.body(response);
		
	}
	 
	 @GetMapping("/orderno/{ordernum}")
	 public ResponseEntity getOrderNo(@PathVariable int ordernum) throws ZeroCustomException {

		if(ordernum==0)
		{
			throw new ZeroCustomException(HttpStatus.valueOf(400),"Bad Request");
		}
		else
		{
		 Map<String,Object> responseNo = new LinkedHashMap<>();
		 HttpStatus status2 = HttpStatus.OK;
	
		 responseNo.put("StatusName", status2.value());
			responseNo.put("StatusValue", status2.name());
			responseNo.put("Message", "Ordered"+ordernum);
		 System.out.println("Order Successful");
		 return ResponseEntity.status(status2)
				 				.body(responseNo);
	 }

}
	 @ExceptionHandler
	 public ResponseEntity<Map> handleZeroCustomException(ZeroCustomException e)
	 {
		 Map<String,Object> responseEx = new LinkedHashMap<>();
		 responseEx.put("status", e.getStatus().value());
		 responseEx.put("Message", "OrderNo must not be Zero");
		return ResponseEntity.status(e.getStatus().value())
							.body(responseEx);
	 }
}
