package com.test.evaluacionJava.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.test.evaluacionJava.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	List<Usuario> findByName(@Param("name") String name);
	List<Usuario> findByEmail(@Param("email") String email);

}
