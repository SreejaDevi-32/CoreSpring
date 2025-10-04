package com.spring.basic.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.basic.classes.UserCaches;
import com.spring.basic.service.CacheInspectionService;

@RestController
@RequestMapping("/cache")
public class UserCacheController {
	
	@Autowired
	private UserCaches userCache;
	
	@Autowired
	private CacheInspectionService cacheInspectionService;
	
	@GetMapping("/cacheData")
	public void getCacheData()
	{
		cacheInspectionService.printCacheContents("users1");
	}
	
	@GetMapping("/{username}")
	public String getCacheUser(@PathVariable  String  username)
	{
		String value= userCache.getUserByName(username);
		return username+" Having "+value;
	}
	
	@PutMapping("/{username}")
	public String updateCacheUser(@PathVariable String username , @RequestParam String Details)
	{
		String detail = userCache.updateUser(username, Details);
		return username +"Having "+detail;
	}
	
	@DeleteMapping("/{username}")
	public String deleteCacheUser(@PathVariable String username)
	{
		userCache.deleteUser(username);
		return username;
	}

}
