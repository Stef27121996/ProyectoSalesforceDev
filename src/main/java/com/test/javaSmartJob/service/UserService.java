package com.test.javaSmartJob.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.test.javaSmartJob.model.Response;
import com.test.javaSmartJob.model.User;

public interface UserService {
	
	public List<User> findUser(User user);
	public Response createUser(User user);
	public User updateUser(User user);
	public void deleteUser(User user);
	
}
