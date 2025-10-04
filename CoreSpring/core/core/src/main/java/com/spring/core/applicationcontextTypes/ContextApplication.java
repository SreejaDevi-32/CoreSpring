package com.spring.core.applicationcontextTypes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.core.applicationcontextTypes.MyComponent;
import com.spring.core.applicationcontextTypes.AppConfig;

//@SpringBootApplication
@ComponentScan(basePackages= {"com.spring.core.applicationcontextTypes"})
public class ContextApplication {

    public static void main(String[] args) {
        //ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class); //AppConfig from the previous example.
        /*ApplicationContext context = SpringApplication.run(ContextApplication.class, args);
    	MyComponent myComponent = context.getBean(MyComponent.class);

        String frenchGreeting = myComponent.getFrenchGreeting("Pierre");
        System.out.println(frenchGreeting); // Output: Bonjour, Pierre!

        String englishGreeting = myComponent.getEnglishGreeting("John");
        System.out.println(englishGreeting); //Output: Hello, John!
        
        
        ApplicationContext context1 = SpringApplication.run(ContextApplication.class,args);
        NewsAgency newsAgency = context1.getBean(NewsAgency.class);
        
        newsAgency.publishNews("Breaking news without breaks");
        newsAgency.publishNews("Hot topic without hotness");
        */
    	
    	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
    	ClassPathxmlEx bean = context.getBean(ClassPathxmlEx.class);
        bean.doSomething();
        context.close();
    }
}