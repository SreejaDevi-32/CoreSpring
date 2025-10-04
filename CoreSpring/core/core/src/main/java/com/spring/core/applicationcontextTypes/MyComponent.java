package com.spring.core.applicationcontextTypes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class MyComponent {

    @Autowired
    private MessageSource messageSource;

    public String getFrenchGreeting(String name) {
        Locale frenchLocale = Locale.FRANCE; // Create Locale.FRANCE
        return messageSource.getMessage("greeting", new Object[] { name }, frenchLocale);
    }

    public String getEnglishGreeting(String name){
        Locale englishLocale = Locale.US;
        return messageSource.getMessage("greeting", new Object[]{name}, englishLocale);
    }
}
