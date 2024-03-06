package com.test.javaSmartJob.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.test.javaSmartJob.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	List<User> findBy(@Param("email") String email);

}
