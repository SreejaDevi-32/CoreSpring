/*
 * package com.spring.core.config;
 * 
 * import org.springframework.beans.factory.annotation.Value; import
 * org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.ComponentScan; import
 * org.springframework.context.annotation.Configuration;
 * 
 * import com.spring.core.User; import
 * com.spring.core.componentscan.OfflineOrder; import
 * com.spring.core.componentscan.OnlineOrder; import
 * com.spring.core.componentscan.Order;
 * 
 * @Configuration
 * 
 * @ComponentScan(basePackages= {"com.spring.core","com.spring.bean.scope"})
 * public class BeanConfiguration {
 * 
 * @Bean User createUser() { return new User("Sreeja", "Password"); }
 * 
 * @Bean public Order createOrder(@Value("${isOnlineOrder}") boolean
 * isOnlineOrder) { if(isOnlineOrder) { return new OnlineOrder(); } else {
 * return new OfflineOrder(); }
 * 
 * } }
 */