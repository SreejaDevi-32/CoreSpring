package com.spring.core;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.support.DefaultSingletonBeanRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

import com.spring.core.componentscan.Student;
                                                                         

@SpringBootApplication
@ComponentScan(basePackages = {"com.spring.core"})
public class CoreApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(CoreApplication.class, args);
		Dev dev = context.getBean(Dev.class);
		dev.build();
		User user = context.getBean(User.class);
		System.out.println("User bean Created:"+user.getUserName());
		
		EagerBean eagerBean = context.getBean(EagerBean.class);
		eagerBean.doSomething();
		
		LazyBean lazyBean = context.getBean(LazyBean.class);
		lazyBean.doSomething();
		
		System.out.println("Calling Laptop Bean");
		
		/*
		Laptop laptop = context.getBean(Laptop.class);
		laptop.useSingletonBeanDestroy("eagerBean", eagerBean);
		eagerBean.doSomething();
		*/
		
		//((ConfigurableApplicationContext) context).close();
		ConfigurableBeanFactory beanFactory = (ConfigurableBeanFactory) context.getAutowireCapableBeanFactory();
	    DefaultSingletonBeanRegistry registry = (DefaultSingletonBeanRegistry) beanFactory;
	    registry.destroySingleton("eagerBean");
	    eagerBean.doSomething();
	    
	}

}
