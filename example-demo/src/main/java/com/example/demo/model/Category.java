package com.example.demo.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="category")
public class Category {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
    @Column(name="CATEGARY_ID")
	private Long id;
	
    @Column(name="CATEGARY_NAME")
	private String CATEGARY_NAME;
    
    @Column(name="CREATE_AT")
	private LocalDateTime CREATE_AT;
    
    @Column(name="UPDATE_AT")
	private LocalDateTime UPDATE_AT;

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
