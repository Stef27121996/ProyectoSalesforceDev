package com.test.javaSmartJob.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.*;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "phone")
@EntityListeners(AuditingEntityListener.class)
@Data
public class Phone {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NonNull private Long id;

	@NonNull private Integer number;
	private Integer cityCode;
	private Integer countryCode;
	@NonNull private Integer user;

}
