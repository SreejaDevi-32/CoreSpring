package com.spring.core.bean.scope;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
@ConditionalOnProperty(prefix="user",value="enabled",havingValue="true", matchIfMissing =true)
public class User implements InitializingBean {
	
	public User()
	{
		System.out.println("User Bean created (Singleton)");
	}
    @Override
    public void afterPropertiesSet() throws Exception {
        // Perform initialization logic here
        System.out.println("UserBean initialized "+this.hashCode());
    }
    
    
}