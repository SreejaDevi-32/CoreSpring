package com.spring.basic.classes;

import java.util.HashMap;
import java.util.Map;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

@Service
@ComponentScan(basePackages = {"com.spring.basic"})
public class UserCaches {
	
	  private final Map<String, String> userData = new HashMap<>();
	  public UserCaches() {
		userData.put("Sreeja", "Low Memory");
		userData.put("Satish", "High Memory");
	}
	
	@Cacheable(value = "users", key = "#username")
	public String getUserByName(String username)
	{
		System.out.println("Fetching brain from "+username);
		
		return userData.get(username);
	}
	
	@CachePut(value = "users" , key = "#username")
	public String updateUser(String username,String newDetails)
	{
		System.out.println("Update Spring Brain with "+username);
		userData.put(username, newDetails);
		return newDetails;
	}
	
	@CacheEvict(value = "users" , key = "#username")
	public void deleteUser(String username)
	{
		System.out.println("Delete brain for "+username);
		userData.remove(username);
	}

}
