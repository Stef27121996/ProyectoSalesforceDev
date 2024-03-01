package com.test.evaluacionJava.Controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.test.evaluacionJava.model.Usuario;
import com.test.evaluacionJava.repository.UsuarioRepository;

@RestController
@RequestMapping("/api")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository repository;
	
	
	@GetMapping("/usuarios")
	@ResponseStatus(HttpStatus.OK)
	public List<Usuario> allPersons(){
		return repository.findAll();
	}
	
	@GetMapping("/usuario/info")
	@ResponseStatus(HttpStatus.OK)
	public List<Usuario> findInfo(@RequestBody Usuario usuario) {
		return repository.findByEmail(usuario.email);
	}
	
	@PostMapping("/usuario")
	public List<Object> createPerson(@RequestBody Usuario usuario) {
		
		List<Object> respuesta = new ArrayList();
		Map<String, String> Mensaje = new HashMap<>();
		
		Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
 
        Matcher mather = pattern.matcher(usuario.email);
        
        Calendar today = Calendar.getInstance();
		usuario.created = today.getTime();
		usuario.modified = today.getTime();
		usuario.last_login = today.getTime();
		usuario.isactive = true;
		usuario.id = (long) 35;
		
		if(!repository.findByEmail(usuario.email).isEmpty()) {
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
			//repository.save(usuario);
			return respuesta;
		}	
	}
	
	@PutMapping("/usuario/actualiza")
	public Usuario updatePerson(@RequestBody Usuario usuario) {
		Calendar today = Calendar.getInstance();
		usuario.modified = today.getTime();
		usuario.last_login = today.getTime();
		return repository.save(usuario);
	}
	
	@DeleteMapping("/usuario/eliminar")
	public void deletePerson(@RequestBody Usuario usuario) {
		repository.delete(usuario);
	}

} 
