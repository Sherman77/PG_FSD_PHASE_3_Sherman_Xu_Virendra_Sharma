package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.exceptionhandling.LoginFailedException;
import com.ecommerce.exceptionhandling.UserNotFoundException;
import com.ecommerce.model.AdminChangePasswordBody;
import com.ecommerce.model.AdminPostBody;
import com.ecommerce.model.AdminUser;
import com.ecommerce.repository.AdminUserRepository;

@RestController
@RequestMapping("admin")
public class AdminUserController {
	
	@Autowired
	AdminUserRepository adminUserRepository;
	
	//Login
	@PostMapping("login")
	public AdminUser login(@RequestBody AdminPostBody adminPostBody) throws UserNotFoundException, LoginFailedException {
		String username = adminPostBody.getUsername();
		String password = adminPostBody.getPassword();
		
		List<AdminUser> list = adminUserRepository.getAdminUserByUsername(username);
		if (list == null || list.size() == 0) {
			throw new UserNotFoundException("User not found.");
		}
		AdminUser admin = list.get(0);
		if (!admin.getPassword().equals(password)) {
			throw new LoginFailedException("Incorrect password.");
		}
		
		return admin;
	}
	
	//Change password
	@PostMapping("changePassword")
	public int changePassword(@RequestBody AdminChangePasswordBody adminChangePasswordBody) throws UserNotFoundException {
		String username = adminChangePasswordBody.getUsername();
		String newPassword = adminChangePasswordBody.getNewPassword();
		
		List<AdminUser> list = adminUserRepository.getAdminUserByUsername(username);
		if (list == null || list.size() == 0) {
			throw new UserNotFoundException("User not found.");
		}
		
		return adminUserRepository.changeUserPassword(username, newPassword);
	}

}
