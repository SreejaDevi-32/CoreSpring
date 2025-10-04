package com.spring.core.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.spring.core.Interceptors.LoggingInterceptor;
import com.spring.core.filters.MyFilter;

import jakarta.servlet.FilterRegistration;

@Configuration
@ComponentScan(basePackages= {"com.spring.core.config","com.spring.core.Interceptors","com.spring.core.filters"})
public class Webconfig implements WebMvcConfigurer{

	@Autowired
	LoggingInterceptor loggingInterceptor;
	public void addInterceptors(InterceptorRegistry registry)
	{
		registry.addInterceptor(loggingInterceptor) // prehandle 
				.addPathPatterns("/icecream/**");
		
		
	}
	
	//@Bean
	public FilterRegistrationBean<MyFilter> myFirstFilter() {
		FilterRegistrationBean<MyFilter> frBean = new FilterRegistrationBean<>();
		frBean.setFilter(new MyFilter());
		frBean.addUrlPatterns("/icecream/*");
		return frBean;
	}
	
	
}
//AuthenticationManager
//ProviderManager
//UsernamePasswordAuthenticationFilter
//AuthenticationProvider
