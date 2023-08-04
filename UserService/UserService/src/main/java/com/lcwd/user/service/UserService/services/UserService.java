package com.lcwd.user.service.UserService.services;

import java.util.List;

import com.lcwd.user.service.UserService.entities.User;

public interface UserService {
	
	
	//create user
	User saveUser(User user);
	
	//get all users
	List<User> getAllUser();
	
	//get single user by id
	User getUser(String userId);

}
