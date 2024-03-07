package com.test.javaSmartJob.model;

import java.sql.Date;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import lombok.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "userApi")
@EntityListeners(AuditingEntityListener.class)
@Data
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NonNull public UUID id;
	@NonNull private String name;

	@CreatedDate
	@NonNull public Date created;
	@NonNull public Date modified;
	@NonNull public Date lastLogin;
	@NonNull public Boolean isActive;
	@Email @NonNull public String email;
	@NonNull public String password;
	@NonNull public UUID token;
	
}
