package com.libraryapp.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.libraryapp.main.model.User;
import com.libraryapp.main.service.IUserService;

@RestController
public class UserController {

	@Autowired
	private IUserService userService;

	@PostMapping("/user/save")
	public ResponseEntity<User> addUser(@RequestBody User user) {
		User newUser = userService.saveUser(user);
		ResponseEntity<User> responseEntity = new ResponseEntity<>(newUser, HttpStatus.CREATED);
		return responseEntity;
	}

	@GetMapping("/user/{userId}")
	public ResponseEntity<User> getUser(@PathVariable("userId") int userId) {
		User user = userService.viewUserById(userId);
		ResponseEntity<User> responseEntity = new ResponseEntity<>(user, HttpStatus.OK);
		return responseEntity;
	}

	@GetMapping("/user/all")
	public List<User> getAllUser() {
		List<User> users = userService.viewAllUsers();
		return users;
	}

}
