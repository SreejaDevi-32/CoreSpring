package com.spring.core.aop;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
@RestController
@RequestMapping("/icecream")
public class IceCreamPage {
	
	@GetMapping(value = "/ordericecream/{name}")
	public ResponseEntity<?> orderIceCream(@PathVariable String name) throws NotInListException {
		List<String> icecreamList = new ArrayList<>(Arrays.asList("vanilla", "butterscotch","choclate"));
		if(!icecreamList.contains(name))
		{
			HttpStatus status = HttpStatus.valueOf(300);
			System.out.println("Ice cream is not in List");
			throw new NotInListException(status,"Not an IceCream ${name}");
		}
		else
		{
			System.out.println("Ice Cream ordered");
			Map<String,Object> response = new LinkedHashMap<>();
			response.put("status",HttpStatus.OK);
			response.put("message", "You Ordered Icecream ${name}");
			return ResponseEntity.ok()
					.body(response);
		}
	}
	
	@ExceptionHandler(NotInListException.class)
	public ResponseEntity<Object> handleNotInListException(NotInListException e)
	{
		Map<String,Object> exception = new LinkedHashMap<>();
		exception.put("status", e.getStatus().value());
		exception.put("message", e.getMessage());
		return ResponseEntity.status(e.getStatus())
				.body(exception);
	}

}
//SecurityProperties
//UserDetailsServiceAutoConfiguration
