package com.ecommerce.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.model.User;
import com.ecommerce.model.UserSearchBody;
import com.ecommerce.repository.UserRepository;
import com.ecommerce.specification.UserSpecification;

@RestController
@RequestMapping("users")
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	//Get all users
	@GetMapping("all")
	public List<User> getAllUser() {
		List<User> users = (List<User>) userRepository.findAll();
		return users;
	}
	
	//Add a user
	@PostMapping("add")
	public User addUser(@RequestBody User user) {
		return userRepository.save(user);
	}
	
	//Search user by userId
	@GetMapping("user/{id}")
	public Optional<User> searchUserById(@PathVariable int id) {
		return userRepository.findById(id);
	}
	
	//Update a user information
	@PutMapping("update/{id}")
	public User updateUser(@RequestBody User user) {
		return userRepository.save(user);
	}
	
	//Delete a user
	@DeleteMapping("delete/{id}")
	public void deleteUser(@PathVariable int id) {
		userRepository.deleteById(id);;
	}
	
	//Search users by field
	@PostMapping("searchByField")
	public List<User> searchByField(@RequestBody UserSearchBody userSearchBody) {
		String column = userSearchBody.getField();
		String value = userSearchBody.getValue();
		UserSpecification us = new UserSpecification(column, value);
		return userRepository.findAll(us);
	}
}
