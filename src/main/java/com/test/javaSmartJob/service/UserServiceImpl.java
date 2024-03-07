package com.test.javaSmartJob.service;

import java.sql.Date;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.test.javaSmartJob.model.User;
import com.test.javaSmartJob.repository.UserRepository;
import com.test.javaSmartJob.model.Response;

import org.apache.commons.validator.routines.EmailValidator;

import lombok.*;

@Service
@Data
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository repository;
	
	@NonNull
	private Response response;
	
	@NonNull
	private Map<String, String> message;

	public List<User> findUser(@RequestBody User user){
		List<User> listUsers= repository.findByEmail(user.email);
		return listUsers;
	}
	
	
	public Response createUser(@RequestBody User user) {
			
			response = new Response();
			message = new HashMap<>();
			        
	        boolean validationEmail = EmailValidator.getInstance().isValid(user.email);
	        
	        Calendar today = Calendar.getInstance();
	        user.created = (@NonNull Date) today.getTime();
	        user.modified = (@NonNull Date) today.getTime();
	        user.lastLogin = (@NonNull Date) today.getTime();
	        user.isActive = true;
	        user.token = UUID.randomUUID();
	        user.id = UUID.randomUUID();
			
			if(!repository.findByEmail(user.email).isEmpty()) {
				message.put("Mensaje Error", "El correo ya se encuentra registrado");
				response.codeResponse = HttpStatus.BAD_REQUEST;
				response.messageResponse = message;
				return response;
			} else if (validationEmail != true){
				message.put("Mensaje Error", "La estructura del correo es incorrecta");
				response.codeResponse = HttpStatus.BAD_REQUEST;
				response.messageResponse = message;
				return response;
			}else {
				message.put("Mensaje", "Registro creado");
				response.codeResponse = HttpStatus.OK;
				response.messageResponse = message;
				repository.save(user);
				return response;
			}	
	}
	
	public User updateUser(@RequestBody User user) {
		Calendar today = Calendar.getInstance();
		user.modified = (@NonNull Date) today.getTime();
		user.lastLogin = (@NonNull Date) today.getTime();
		return repository.save(user);
	}
	
	public void deleteUser(@RequestBody User user) {
		repository.delete(user);
	}

}
