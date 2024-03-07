package com.test.javaSmartJob.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.test.javaSmartJob.model.User;
import com.test.javaSmartJob.model.Response;
import com.test.javaSmartJob.service.UserService;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@Data
@RequiredArgsConstructor
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/user")
	@ResponseStatus(HttpStatus.OK)
	public List<User> findUser(@RequestBody User user) {
		return userService.findUser(user);
	}
	
	@PostMapping("/user")
	public Response createUser(@RequestBody User user) {
		return userService.createUser(user);
	}
	
	@PutMapping("/user")
	public User updateUser(@RequestBody User user) {
		return userService.updateUser(user);
	}
	
	@DeleteMapping("/user")
	public void deleteUser(@RequestBody User user) {
		userService.deleteUser(user);
	}

} 
