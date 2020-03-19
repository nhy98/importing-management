package com.group8.management.service;

import java.util.List;

import com.group8.management.entities.User;

public interface UserService {
	List<User> findAll();
	
	User findOne(String id);
	
	int create(User user);
	
	int update(User user);
	
	int deleteOne(String id);
	
	int login(String username, String password);
	
	int checkRole(String userRole, String role);
		    
}