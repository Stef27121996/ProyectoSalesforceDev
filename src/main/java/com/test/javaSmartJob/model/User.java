package com.test.javaSmartJob.model;

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "user")
@EntityListeners(AuditingEntityListener.class)
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	private String name;

	@CreatedDate
	public Date created;
	public Date modified;
	public Date lastLogin;
	public Boolean isActive;
	public String email;
	public String password;
	
	public User() {

	}

	public User( Long id,  
					Date created, 
					Date modified, 
					Date lastLogin, 
					Boolean isActive) {
		this.id = id;
		this.created = created;
		this.modified = modified;
		this.lastLogin = lastLogin;
		this.isActive = isActive;

	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}
	
	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date last_login) {
		this.lastLogin = lastLogin;
	}
	
	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isactive) {
		this.isActive = isActive;
	}

}
