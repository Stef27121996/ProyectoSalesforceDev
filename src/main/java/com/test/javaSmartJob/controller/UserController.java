package com.test.javaSmartJob.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

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
import com.test.javaSmartJob.repository.UserRepository;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	private UserRepository repository;

	@GetMapping("/user")
	@ResponseStatus(HttpStatus.OK)
	public List<User> findBy(@RequestBody User usuario) {
		return repository.findBy(usuario.email);
	}
	
	@PostMapping("/user")
	public List<Object> createPerson(@RequestBody User user) {
		
		List<Object> respuesta = new ArrayList();
		Map<String, String> Mensaje = new HashMap<>();
		
		Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
 
        Matcher mather = pattern.matcher(user.email);
        
        Calendar today = Calendar.getInstance();
        user.created = today.getTime();
        user.modified = today.getTime();
        user.lastLogin = today.getTime();
        user.isActive = true;
        user.id = (long) 35;
		
		if(!repository.findBy(user.email).isEmpty()) {
			Mensaje.put("Mensaje Error", "El correo ya se encuentra registrado");
			respuesta.add(HttpStatus.BAD_REQUEST);
			respuesta.add(Mensaje);
			return respuesta;
		} else if (mather.find() != true){
			Mensaje.put("Mensaje Error", "La estructura del correo es incorrecta");
			respuesta.add(HttpStatus.BAD_REQUEST);
			respuesta.add(Mensaje);
			return respuesta;
		}else {
			Mensaje.put("Mensaje", "Registro creado");
			respuesta.add(HttpStatus.OK);
			respuesta.add(Mensaje);
			repository.save(user);
			return respuesta;
		}	
	}
	
	@PutMapping("/user")
	public User updatePerson(@RequestBody User user) {
		Calendar today = Calendar.getInstance();
		user.modified = today.getTime();
		user.lastLogin = today.getTime();
		return repository.save(user);
	}
	
	@DeleteMapping("/user")
	public void deletePerson(@RequestBody User user) {
		repository.delete(user);
	}

} 
