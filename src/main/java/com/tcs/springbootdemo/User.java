package com.tcs.springbootdemo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;  
	
	@NotBlank
	private String name;
	
	@Email
	private String emial ;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
