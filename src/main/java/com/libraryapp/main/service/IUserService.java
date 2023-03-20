package com.libraryapp.main.service;

import java.util.List;

import com.libraryapp.main.model.User;

public interface IUserService {
	
	public  User saveUser(User user);
	
	public User viewUserById (int userId);
	
	public List<User> viewAllUsers(); 

}
