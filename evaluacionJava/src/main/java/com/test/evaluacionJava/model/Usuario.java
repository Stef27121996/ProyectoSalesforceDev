package com.test.evaluacionJava.model;

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
@Table(name = "usuario")
@EntityListeners(AuditingEntityListener.class)
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	private String name;

	@CreatedDate
	public Date created;
	public Date modified;
	public Date last_login;
	public Boolean isactive;
	public String email;
	public String password;
	
	public Usuario() {

	}

	public Usuario( Long id,  
					Date created, 
					Date modified, 
					Date last_login, 
					Boolean isactive) {
		this.id = id;
		this.created = created;
		this.modified = modified;
		this.last_login = last_login;
		this.isactive = isactive;

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
		return last_login;
	}

	public void setLastLogin(Date last_login) {
		this.last_login = last_login;
	}
	
	public Boolean getIsActive() {
		return isactive;
	}

	public void setIsActive(Boolean isactive) {
		this.isactive = isactive;
	}

}
