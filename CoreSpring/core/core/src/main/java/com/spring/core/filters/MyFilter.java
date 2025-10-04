package com.spring.core.filters;

import java.io.IOException;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

@Component
public class MyFilter implements Filter{
	
	@PostConstruct
	public void init() {
	    System.out.println("✅ MyFilter loaded successfully!");
	}


	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("My Filter started");
		chain.doFilter(request, response);	
		System.out.println("My filter completed");
	}
	@Override
	public void destroy() {
		Filter.super.destroy();
	}

}
