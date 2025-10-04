/*
package com.spring.basic.config; 
import  org.springframework.context.annotation.Bean; 
import org.springframework.context.annotation.Configuration; 
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static org.springframework.security.config.Customizer.withDefaults;
  
@Configuration 
@EnableWebSecurity
public class SecurityConfig {
	 @Bean
	    public UserDetailsService userDetailsService() {
	        UserDetails adminUser = User.withUsername("admin")
	                                    .password("{noop}admin123")
	                                    //.authorities("ACCESS_DASHBOARD", "MANAGE_USERS")	
	                                    .roles("ADMIN")
	                                    .build();
	        return new InMemoryUserDetailsManager(adminUser);
	    }

  @Bean 
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception { 
	  System.out.println("Custom Security Filter Chain");
	http 
		.authorizeHttpRequests(auth -> auth
				.requestMatchers("/order/getOrder").hasRole("ADMIN")
				.requestMatchers("/user/getUser").permitAll() // Allow access without
				.requestMatchers("/pizza/addPizzaOrder").permitAll()
				
				 .anyRequest().authenticated() // Secure all other endpoints
				)
		  	.httpBasic(withDefaults());  // ✅ Fix for deprecated httpBasic()
	      // .formLogin(withDefaults());  // ✅ Fix for deprecated formLogin()

  return http.build();
  }
  
  
}

*/

  
 