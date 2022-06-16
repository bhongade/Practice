package com.example.dto;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

public class CategoryDto {

	public Long id;
	
	public String CATEGARY_NAME;
    
	public LocalDateTime CREATE_AT;
    
	public LocalDateTime UPDATE_AT;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCATEGARY_NAME() {
		return CATEGARY_NAME;
	}

	public void setCATEGARY_NAME(String cATEGARY_NAME) {
		CATEGARY_NAME = cATEGARY_NAME;
	}

	public LocalDateTime getCREATE_AT() {
		return CREATE_AT;
	}

	public void setCREATE_AT(LocalDateTime cREATE_AT) {
		CREATE_AT = cREATE_AT;
	}

	public LocalDateTime getUPDATE_AT() {
		return UPDATE_AT;
	}

	public void setUPDATE_AT(LocalDateTime uPDATE_AT) {
		UPDATE_AT = uPDATE_AT;
	}

    
}
