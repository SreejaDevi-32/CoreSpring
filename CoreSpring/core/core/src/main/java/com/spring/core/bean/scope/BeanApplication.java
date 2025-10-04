package com.spring.core.bean.scope;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.context.WebApplicationContext;
 
@SpringBootApplication
//@ComponentScan(basePackages = {"com.spring.core.bean.scope","com.spring.core.componentscan","com.spring.core.config"})
//@ComponentScan (basePackages = {"com.spring.core.exceptions"})
public class BeanApplication {
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(BeanApplication.class, args);
		//WebApplicationContext webContext = (WebApplicationContext) SpringApplication.run(BeanApplication.class, args);
		System.out.println("Bean Application Started");
		/*EmployeeService eService1 = context.getBean(EmployeeService.class);
		User user1 =context.getBean(User.class);
		EmployeeService eService2 = context.getBean(EmployeeService.class);
		//System.out.println("Hashcodes of eService1:"+eService1.hashCode()+"and eService2:"+eService2.hashCode());
		
		
		User user2 = context.getBean(User.class);
		//System.out.println("Hashcodes of user1:"+user1.hashCode() +"and user2:"+user2.hashCode());
		 
		 */
	}

}
