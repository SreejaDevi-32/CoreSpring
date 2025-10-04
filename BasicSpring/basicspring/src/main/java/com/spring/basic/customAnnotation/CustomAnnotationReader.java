package com.spring.basic.customAnnotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.basic.service.CustomAnnotationService;

@Component
public class CustomAnnotationReader {
	
	@Autowired
	private CustomAnnotationService customAnnotationService;
	
	public void annotationReader() throws Exception
	{
		//fetch class method from CustomAnnotationService
		for(Method method:customAnnotationService.getClass().getDeclaredMethods())
		{
			
			MyCustomAnnotation annotation = method.getAnnotation(MyCustomAnnotation.class);
			System.out.println("Method : "+method.getName());
			System.out.println(" Value : "+annotation.value());
			System.out.println(" Enabled : "+annotation.enabled());
			
			if(annotation.enabled())
			{
				method.invoke(customAnnotationService);
			}
		}
	}
	

}
