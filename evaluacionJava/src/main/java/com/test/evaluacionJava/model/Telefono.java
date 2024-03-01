package com.test.evaluacionJava.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "telefono")
@EntityListeners(AuditingEntityListener.class)
public class Telefono {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Integer number;
	private Integer citycode;
	private Integer countrycode;
	private Integer usuario;	

	public Telefono() {

	}

	public Telefono(Long id, 
					Integer number, 
					Integer citycode, 
					Integer countrycode, 
					Integer usuario) {
		this.id = id;
		this.number = number;
		this.citycode = citycode;
		this.countrycode = countrycode;
		this.usuario = usuario;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}
	
	public Integer getCityCode() {
		return citycode;
	}

	public void setCityCode(Integer citycode) {
		this.citycode = citycode;
	}
	
	public Integer getCountryCode() {
		return countrycode;
	}

	public void setCountryCode(Integer countrycode) {
		this.countrycode = countrycode;
	}
	
	public Integer getUsuario() {
		return usuario;
	}

	public void setUsuario(Integer usuario) {
		this.usuario = usuario;
	}
}
