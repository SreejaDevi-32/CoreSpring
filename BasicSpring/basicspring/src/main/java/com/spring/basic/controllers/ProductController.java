package com.spring.basic.controllers;

import java.lang.reflect.Method;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.basic.classes.Product;
import com.spring.basic.classes.HateosLinks;
@RestController
@RequestMapping("/products")
public class ProductController {
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable Long id)
	{
		Product product = new Product(id,"Laptop",1200.0);
		Link verifyLink = WebMvcLinkBuilder.linkTo(ProductController.class)
											.slash("sms-verify-finish")
											.slash(product.getId())
											.withRel("verify")
											.withType("POST");
		Link updateLink= WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProductController.class).updateProduct(product.getId()))
										  .withRel("update")
										  .withType("PUT");
		product.addLink(verifyLink);
		product.addLink(updateLink);
		return new ResponseEntity<>(product,HttpStatus.OK);
	}
	  
	@PutMapping("/{id}/update")
	public ResponseEntity<String> updateProduct(@PathVariable Long id) {
	    // logic to update product
	    return ResponseEntity.ok("Product updated successfully!");
	}

}
