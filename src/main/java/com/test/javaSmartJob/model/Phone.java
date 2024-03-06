package com.test.javaSmartJob.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "phone")
@EntityListeners(AuditingEntityListener.class)
public class Phone {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Integer number;
	private Integer cityCode;
	private Integer countryCode;
	private Integer user;	

	public Phone() {

	}

	public Phone(Long id, 
					Integer number, 
					Integer cityCode, 
					Integer countryCode, 
					Integer user) {
		this.id = id;
		this.number = number;
		this.cityCode = cityCode;
		this.countryCode = countryCode;
		this.user = user;
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
		return cityCode;
	}

	public void setCityCode(Integer citycode) {
		this.cityCode = cityCode;
	}
	
	public Integer getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(Integer countryCode) {
		this.countryCode = countryCode;
	}
	
	public Integer getUsuario() {
		return user;
	}

	public void setUsuario(Integer usuario) {
		this.user = usuario;
	}
}
